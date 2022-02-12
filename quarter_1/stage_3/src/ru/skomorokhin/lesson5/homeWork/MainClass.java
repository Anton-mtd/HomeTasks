package ru.skomorokhin.lesson5.homeWork;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CyclicBarrier cb = new CyclicBarrier(CARS_COUNT, new Runnable() {
        @Override
        public void run() {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }
    });

    public static ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        List<Callable<Object>> cars = new ArrayList<>();
        for (int i = 0; i < CARS_COUNT; i++) {
            cars.add(Executors.callable(new Car(race, 20 + (int) (Math.random() * 10), cb)));
        }

        try {
            executorService.invokeAll(cars);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }




}