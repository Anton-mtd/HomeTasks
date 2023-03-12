package hometask_3_JavaCore.task1;

public class Pong implements Runnable{
    private final PingPongGame game;

    public Pong(PingPongGame game) {
        this.game = game;
        new Thread(this, "Pong").start();
    }

    @Override
    public void run() {
        while (game.getCounter() < game.getMAX_GAME_STEP()) {
            try {
                game.stepPong();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
