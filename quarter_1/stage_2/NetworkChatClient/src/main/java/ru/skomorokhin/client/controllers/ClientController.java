package ru.skomorokhin.client.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.skomorokhin.client.ClientChat;
import ru.skomorokhin.client.model.Network;
import ru.skomorokhin.client.model.ReadCommandListener;
import ru.skomorokhin.client.model.dialogs.Dialogs;
import ru.skomorokhin.clientserver.Command;
import ru.skomorokhin.clientserver.CommandType;
import ru.skomorokhin.clientserver.commands.ClientMessageCommandData;
import ru.skomorokhin.clientserver.commands.UpdateUserListCommandData;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ClientController {

    private static final List<String> USER_TEST_DATA = List.of("username1", "username2", "username3");

    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private Button sendButton;
    @FXML
    public ListView<String> userList;

    private ClientChat application;

    public void initialize() {
        userList.setItems(FXCollections.observableList(USER_TEST_DATA));
    }

    public void sendMessage() {
        String message = textField.getText().trim();

        if (message.isEmpty()) {
            textField.clear();
            return;
        }

        String sender = null;
        if (!userList.getSelectionModel().isEmpty()) {
            sender = userList.getSelectionModel().getSelectedItem();
        }

        try {
            if (sender != null) {
                Network.getInstance().sendPrivateMessage(sender, message);
            } else {
                System.out.println("ClientController Network.getInstance().sendMessage(message);");
                Network.getInstance().sendMessage(message);
            }

        } catch (IOException e) {
            application.showErrorDialog("Ошибка передачи данных по сети");
        }

        appendMessageToChat("Я", message);
    }

    private void appendMessageToChat(String sender, String message) {
        textArea.appendText(DateFormat.getDateTimeInstance().format(new Date()));
        textArea.appendText(System.lineSeparator());

        if (sender != null) {
            textArea.appendText(sender + ":");
            textArea.appendText(System.lineSeparator());
        }

        textArea.appendText(message);
        textArea.appendText(System.lineSeparator());
        textArea.appendText(System.lineSeparator());
        textField.setFocusTraversable(true);
        textField.clear();
    }


    public void setApplication(ClientChat application) {
        this.application = application;
    }

    public void initializeMessageHandler() {
        Network.getInstance().addReadMessageListener(new ReadCommandListener() {
            @Override
            public void processReceivedCommand(Command command) {
                if (command.getType() == CommandType.CLIENT_MESSAGE) {
                    ClientMessageCommandData data = (ClientMessageCommandData) command.getData();
                    appendMessageToChat(data.getSender(), data.getMessage());
                } else if (command.getType() == CommandType.UPDATE_USER_LIST) {
                    UpdateUserListCommandData data = (UpdateUserListCommandData) command.getData();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            userList.setItems(FXCollections.observableList(data.getUsers()));
                        }
                    });
                }
            }
        });
    }

    public void close(ActionEvent actionEvent) {
        ClientChat.INSTANCE.getChatStage().close();
    }

    public void updateUsername(ActionEvent actionEvent) {
        TextInputDialog editDialog = new TextInputDialog();
        editDialog.setTitle("Изменить имя пользователя");
        editDialog.setHeaderText("Введите новое имя мпользователя");
        editDialog.setContentText("Username:");

        Optional <String> result = editDialog.showAndWait();
        if (result.isPresent()) {
            try {
                Network.getInstance().updateUsername(result.get());
            } catch (IOException e) {
                e.printStackTrace();
                Dialogs.NetworkError.SEND_MESSAGE.show();
            }
        }
    }

    public void about(ActionEvent actionEvent) {
        Dialogs.AboutDialog.INFO.show();
    }
}