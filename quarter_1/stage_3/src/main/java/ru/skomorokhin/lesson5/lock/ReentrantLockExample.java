package ru.skomorokhin.lesson5.lock;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
//        simpleLockExample();
        tryLockExample();
    }

    private static void tryLockExample() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        ReentrantLock lock = new ReentrantLock();



        executor.submit(() -> {
            try {
//                if (lock.tryLock()) {
                if (lock.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        count++;
                        sleep(100);
                        System.out.println(count);
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("Lock is busy!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            try {
//                if (lock.tryLock()) {
                if (lock.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        count++;
                        sleep(100);
                        System.out.println(count);
//                        System.out.println("Held by me: " + lock.isHeldByCurrentThread());
                    } finally {
                        lock.unlock();
                    }
                }  else {
                    System.out.println("Lock is busy!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
        });

        executor.shutdown();
    }

    private static void simpleLockExample() throws InterruptedException {
        Lock lock = new ReentrantLock();

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": Before lock");
            try {
                lock.lock();
                System.out.println(threadName + " is acquired lock");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(threadName + ": After lock");
                lock.unlock();
            }
        };

        List<Callable<Object>> tasks = Collections.nCopies(5, Executors.callable(task));

//        List<Callable<Object>> result = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            result.add(Executors.callable(task));
//        }
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.invokeAll(tasks);
        executorService.shutdown();
    }

    private static void await(CyclicBarrier cb) {
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static void sleep(int milli) {
        try {
            Thread.sleep(TimeUnit.MILLISECONDS.toMillis(milli));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
