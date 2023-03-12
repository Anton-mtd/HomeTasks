package hometask_3_JavaCore.task1;

public class Ping implements Runnable {
    private final PingPongGame game;

    public Ping(PingPongGame game) {
        this.game = game;
        new Thread(this, "Ping").start();
    }

    @Override
    public void run() {
        while (game.getCounter() < game.getMAX_GAME_STEP()) {
            try {
                game.stepPing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
