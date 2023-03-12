package hometask_3_JavaCore.task2;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable{

    Counter counter;
    ReentrantLock lock;

    public CountThread(Counter counter, ReentrantLock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            int roll = new Random().nextInt(10);
            if (roll >= 5) {
                counter.increment();
            } else {
                counter.decrement();
            }
            System.out.printf("%s %d \n", Thread.currentThread().getName() + " changed count by ", Counter.getCount());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}
