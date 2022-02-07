package ru.skomorokhin.client.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.skomorokhin.client.ClientChat;
import ru.skomorokhin.client.model.Network;
import ru.skomorokhin.client.model.dialogs.Dialogs;
import ru.skomorokhin.client.model.ReadCommandListener;
import ru.skomorokhin.clientserver.Command;
import ru.skomorokhin.clientserver.CommandType;
import ru.skomorokhin.clientserver.commands.AuthOkCommandData;
import ru.skomorokhin.clientserver.commands.AuthTimeIsOverCommandData;
import ru.skomorokhin.clientserver.commands.ErrorCommandData;


import java.io.File;
import java.io.IOException;

public class AuthController {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button authButton;

    private ReadCommandListener readMessageListener;

    public void executeAuth(ActionEvent actionEvent) {
        String login = loginField.getText();
        String password = passwordField.getText();

        if (login == null || login.isBlank() || password == null || password.isBlank()) {
            Dialogs.AuthError.EMPTY_CREDENTIALS.show();
            return;
        }

        if (!connectToServer()) {
            Dialogs.NetworkError.SERVER_CONNECT.show();
        }

        try {
            Network.getInstance().sendAuthMessage(login, password);
            ClientChat.INSTANCE.setPathToFileMessageHistory("src/main/resources/messagesHistory/" + login + "_MessagesHistory.json");
        } catch (IOException e) {
            Dialogs.NetworkError.SEND_MESSAGE.show();
            e.printStackTrace();
        }
    }

    private boolean connectToServer() {
        Network netWork = Network.getInstance();
        return netWork.isConnected() || netWork.connect();
    }

    public void initializeMessageHandler() {
        connectToServer();
        readMessageListener = getNetwork().addReadMessageListener(new ReadCommandListener() {
            @Override
            public void processReceivedCommand(Command command) {
                if (command.getType() == CommandType.AUTH_OK) {
                    AuthOkCommandData data = (AuthOkCommandData) command.getData();
                    String username = data.getUsername();
                    createFileMessagesHistory(ClientChat.INSTANCE.getPathToFileMessageHistory());
                    Platform.runLater(() -> ClientChat.INSTANCE.switchToMainChatWindow(username));
                } else if (command.getType() == CommandType.ERROR){
                    ErrorCommandData data = (ErrorCommandData) command.getData();
                    Platform.runLater(() -> {
                        Dialogs.AuthError.INVALID_CREDENTIALS.show(data.getErrorMessage());
                    });
                } else if (command.getType() == CommandType.AUTH_TIME_IS_OVER){
                    AuthTimeIsOverCommandData data = (AuthTimeIsOverCommandData) command.getData();
                    Platform.runLater(() -> {
                        Dialogs.AuthError.AUTH_TIME_IS_OVER.show(data.getAuthTimeIsOverMessage());
                    });
                    try {
                        Thread.sleep(2000L);
                        System.exit(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void close() {
        getNetwork().removeReadMessageListener(readMessageListener);
    }

    private Network getNetwork() {
        return Network.getInstance();
    }

    private void createFileMessagesHistory(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
