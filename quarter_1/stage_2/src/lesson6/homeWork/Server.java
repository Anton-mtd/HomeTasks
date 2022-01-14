package lesson6.homeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends CommunicationClientServer {
    private static final int PORT = 8189;


    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Сервер начал работу, ожидаем новые подключения");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            Server server = new Server();
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    server.getingMessage(input, "client");
                    Thread.currentThread().interrupt();
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    server.sendingMessage(output);
                    Thread.currentThread().interrupt();
                }
            });
            thread1.start();
            thread2.start();



        } catch (IOException e){
            System.err.println("Ошибка при подключении к порту " + PORT);
            e.printStackTrace();
        }
    }

}
