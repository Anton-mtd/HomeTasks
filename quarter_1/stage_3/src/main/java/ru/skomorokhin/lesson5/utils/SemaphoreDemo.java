package ru.skomorokhin.lesson5.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {
        Semaphore smp = new Semaphore(1, true);
//        Semaphore smp = new Semaphore(2);

        ExecutorService executorService = Executors.newCachedThreadPool(new CustomThreadFactory("Semaphore thread"));

        List<Callable<Object>> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Runnable task = createTask(smp);
            tasks.add(Executors.callable(task));
        }

        executorService.invokeAll(tasks);
//        System.out.println("Main");
        executorService.shutdown();
    }

    private static Runnable createTask(Semaphore smp) {
        return () -> {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.println(threadName + " перед семафором");
                smp.acquire();
                System.out.println(threadName + " получил доступ к ресурсу");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(threadName + " освободил ресурс");
                smp.release();
            }
        };
    }
}
