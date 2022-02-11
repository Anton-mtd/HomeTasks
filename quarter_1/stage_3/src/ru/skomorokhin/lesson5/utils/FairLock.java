package ru.skomorokhin.lesson5.utils;

import java.util.List;
import java.util.concurrent.Semaphore;

public class FairLock {

    private final static Semaphore s = new Semaphore(1, true);

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = List.of(
                new Thread(new Bulb("first")),
                new Thread(new Bulb("second")),
                new Thread(new Bulb("third")),
                new Thread(new Bulb("fourth"))
        );

        threads.forEach(Thread::start);
        Thread.sleep(5000);
        threads.forEach(Thread::interrupt);
    }

    public static class Bulb implements Runnable {

        private final String name;

        public Bulb(String name) {
            this.name = name;
        }

        public void run() {
            Thread self = Thread.currentThread();
            while (!self.isInterrupted()) {
                try {
                    s.acquire();
                    doWork(self);
                } catch (InterruptedException e) {
                    break;
                } finally {
                    s.release();
                }
            }
        }

        private void doWork(Thread self) {
            System.out.println(name + " bulb is on");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                self.interrupt();
            }
            System.out.println(name + " bulb is off");
        }
    }

}