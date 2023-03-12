package hometask_3_JavaCore.task1;

public class Main {
    public static void main(String[] args) {
        PingPongGame pingPongGame = new PingPongGame();
        new Ping(pingPongGame);
        new Pong(pingPongGame);
    }
}
