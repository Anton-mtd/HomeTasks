package lesson6.homeWork;

import javafx.scene.control.Alert;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Client extends CommunicationClientServer {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8189;
    public static final String CONNECTION_ERROR_MESSAGE = "Невозможно установить сетевое соединение";

    private int port;
    private String host;
    private Socket socket;
    private DataInputStream socketInput;
    private DataOutputStream socketOutput;

    public Client(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public Client() {
        this(SERVER_PORT, SERVER_HOST);
    }

    public static void main(String[] args) {
        Client client = new Client();
        boolean result = client.connect();

        if (!result) {
            String errorMessage = CONNECTION_ERROR_MESSAGE;
            System.err.println(errorMessage);
            client.showErrorDialog(errorMessage);
        } else {
            System.out.println("Клиент подключился к серверу.");
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    client.sendingMessage(client.socketOutput);
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    client.getingMessage(client.socketInput, "server");
                }
            });
            thread1.start();
            thread2.start();

        }
    }

    public boolean connect() {
        try {
            this.socket = new Socket(this.host, this.port);
            this.socketInput = new DataInputStream(socket.getInputStream());
            this.socketOutput = new DataOutputStream(socket.getOutputStream());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось установить соединение");
            return false;
        }
    }


    public void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
