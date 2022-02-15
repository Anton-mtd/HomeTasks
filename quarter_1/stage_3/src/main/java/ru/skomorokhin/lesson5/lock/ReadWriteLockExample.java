package ru.skomorokhin.lesson5.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Map<String, String> map = new HashMap<>();

        ReadWriteLock lock = new ReentrantReadWriteLock();

        Runnable writeTask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Try to write");
            lock.writeLock().lock();
            try {
                System.out.println(threadName + " Start write");

                sleep(3);
                map.put("foo", "bar");
            } finally {
                System.out.println(threadName + " Finish write");
                lock.writeLock().unlock();
            }
        };

        Runnable readTask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Try to read");
            lock.readLock().lock();
            try {
                System.out.println(threadName + " Start read");

                System.out.println(map.get("foo"));
                sleep(5);

            } finally {
                System.out.println(threadName + " Finish read");
                lock.readLock().unlock();
            }
        };

        executor.submit(readTask);
        executor.submit(writeTask);

        executor.submit(readTask);
        executor.submit(readTask);

        executor.shutdown();
    }

    private static void sleep(int secs) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(secs));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
