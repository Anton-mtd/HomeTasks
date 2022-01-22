package ru.skomorokhin.server.chat;

import ru.skomorokhin.server.chat.auth.AuthService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {

    private final List<ClientHandler> clients = new ArrayList<>();
    private AuthService authService;

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server has been started");
            authService = new AuthService();
            while (true) {
                waitAndProcessClientConnection(serverSocket);
            }
        } catch (IOException e) {
            System.err.println("Failed to bind port " + port);
            e.printStackTrace();
        }
    }

    private void waitAndProcessClientConnection(ServerSocket serverSocket) throws IOException {
        System.out.println("Waiting for new client connection");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client has been connected");
        ClientHandler clientHandler = new ClientHandler(this, clientSocket);
        clientHandler.handle();
    }

    public void broadcastMessage(String message, ClientHandler sender) throws IOException {
        if (message.contains("/w")) {
            String[] parts = message.split(" ");
            String userName = parts[1];
            for (ClientHandler client : clients) {
                if (client.getUserName().equals(userName)) {
                    String refactorMessage = message.substring((parts[0].length() + parts[1].length() +1));  // отрезаем "/w userName" от сообщения и направляем все что после
                    client.sendMessage(refactorMessage);
                }
            }
        } else {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(message);
                }
            }
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        this.clients.add(clientHandler);
    }

    public void unSubscribe(ClientHandler clientHandler) {
        this.clients.remove(clientHandler);
    }

    public AuthService getAuthService() {
        return authService;
    }

    public List<ClientHandler> getClients() {
        return clients;
    }
}
