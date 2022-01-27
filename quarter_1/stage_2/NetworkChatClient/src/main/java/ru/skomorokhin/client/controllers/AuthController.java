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
import ru.skomorokhin.clientserver.commands.ErrorCommandData;


import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class AuthController {

    public static final long AUTHENTICATING_TIME = 30000L;
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
        Timer timer = new Timer("timer");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        };
        timer.schedule(task, AUTHENTICATING_TIME);
        readMessageListener = getNetwork().addReadMessageListener(new ReadCommandListener() {
            @Override
            public void processReceivedCommand(Command command) {
                if (command.getType() == CommandType.AUTH_OK) {
                    AuthOkCommandData data = (AuthOkCommandData) command.getData();
                    String username = data.getUsername();
                    Platform.runLater(() -> ClientChat.INSTANCE.switchToMainChatWindow(username));
                    timer.cancel();
                } else if (command.getType() == CommandType.ERROR){
                    ErrorCommandData data = (ErrorCommandData) command.getData();
                    Platform.runLater(() -> {
                        Dialogs.AuthError.INVALID_CREDENTIALS.show(data.getErrorMessage());
                    });
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

}
