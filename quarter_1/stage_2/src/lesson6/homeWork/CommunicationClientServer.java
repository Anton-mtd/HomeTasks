package lesson6.homeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

abstract class CommunicationClientServer {

    void sendingMessage(DataOutputStream output) {
        while (true) {
            try {
                String message = new Scanner(System.in).nextLine();
                if (message.equals("/end")) {
                    System.out.println("Была вызвана команда \"/end\" работа сервера завершена");
                    output.writeUTF(message);
                    System.exit(0);
                    break;
                } else if (!message.isEmpty()){
                    output.writeUTF(message);
                }
            } catch (IOException e) {
                System.err.println("Не удалось отправить сообщение");
                e.printStackTrace();
            }
        }
    }

    void getingMessage(DataInputStream input, String name) {
        while (true) {
            try {
                String message = input.readUTF();
                if (message.equals("/end")) {
                    System.out.println("Была вызвана команда \"/end\" работа сервера завершена");
                    System.exit(0);
                    break;
                }
                System.out.println("From " + name + ": " + message);
            } catch (IOException e) {
                System.out.println("Соединение было закрыто");
                break;
            }
        }
    }
}
