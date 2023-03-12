package hometask_3_JavaCore.task2;


import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new CountThread(Counter.getInstance(), lock));
            thread.start();
        }

    }
}
