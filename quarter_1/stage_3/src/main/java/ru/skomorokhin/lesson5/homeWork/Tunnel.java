package ru.skomorokhin.lesson5.homeWork;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private Semaphore semaphoreForTunnel = new Semaphore(2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                semaphoreForTunnel.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphoreForTunnel.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
