package ru.skomorokhin.lesson5.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BarrierExample {


    private static final int THREADS_COUNT = 6;


    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(THREADS_COUNT);

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT, new CustomThreadFactory("Barrier Thread"));

        List<Callable<Object>> tasks = new ArrayList<>();

        for (int i = 0; i < THREADS_COUNT; i++) {
            Runnable task = createTask(cb);
            tasks.add(Executors.callable(task));
        }

        executorService.invokeAll(tasks);

        executorService.shutdown();
    }

    private static Runnable createTask(CyclicBarrier cb) {
        return () -> {
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " готовится");
                Thread.sleep(100 + (int) (3000 * Math.random()));
                System.out.println(threadName + " готов");

                cb.await();

                System.out.println(threadName + " запустился");

            } catch (Exception e) {
                e.printStackTrace();
            }

        };
    }
}
