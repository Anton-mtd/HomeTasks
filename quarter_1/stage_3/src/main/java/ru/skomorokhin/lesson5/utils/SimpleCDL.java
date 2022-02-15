package ru.skomorokhin.lesson5.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleCDL {

    private static final int THREADS_COUNT = 6;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10, new CustomThreadFactory("CDL Thread"));

        final CountDownLatch cdl = new CountDownLatch(THREADS_COUNT);

        List<Callable<Object>> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Runnable task = createTask(cdl);
            tasks.add(Executors.callable(task));
        }

        System.out.println("Начинаем");
        for (Callable<Object> task : tasks) {
            executorService.submit(task);
        }
//        executorService.invokeAll(tasks);

        try {
            // пока счетчик не приравняется нулю, будем стоять на этой строке
            //Аналог threads.forEach(thread -> thread.join())
            cdl.await();
//            for (Future<Object> future : futures) {
//                future.get();
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // как только все потоки выполнили свои задачи - пишем сообщение
        System.out.println("Работа завершена");
        executorService.shutdown();
    }

    private static Runnable createTask(CountDownLatch cdl) {
        return () -> {
            try {
                // считаем, что выполнение задачи занимает ~1 сек
                Thread.sleep(500 + (int) (500 * Math.random()));
                cdl.countDown();
                // как только задача выполнена, уменьшаем счетчик
                System.out.println(Thread.currentThread().getName() + " - готов");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

}