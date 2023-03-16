package hometask_3_JavaCore.task1;

public class PingPongGame {
    private boolean flag;
    private int counter = 1;
    private final int MAX_GAME_STEP = 15;

    synchronized public void stepPing() throws InterruptedException {
        while (flag) {
            wait();
        }
        System.out.println("удар " + counter++  + " в потоке " + Thread.currentThread().getName());
        flag = true;
        Thread.sleep(1000);
        notify();
    }

    synchronized public void stepPong() throws InterruptedException {
        while (!flag) {
            wait();
        }
        System.out.println("удар " + counter++  + " в потоке " + Thread.currentThread().getName());
        flag = false;
        Thread.sleep(1000);
        notify();
    }

    public int getMAX_GAME_STEP() {
        return MAX_GAME_STEP;
    }

    public int getCounter() {
        return counter;
    }
}
