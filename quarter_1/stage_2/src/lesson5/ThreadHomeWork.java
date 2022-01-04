package lesson5;


import java.util.Arrays;


public class ThreadHomeWork {

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        firstMethod(arr);
        secondMethod(arr);
    }

    public static void firstMethod(float[] arr) {
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod(float[] arr) {
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        float[] firstPart = new float[HALF];
        System.arraycopy(arr, 0, firstPart, 0, firstPart.length);
        float[] secondPart = new float[arr.length - HALF];
        System.arraycopy(arr, 0, secondPart, 0, secondPart.length);

        MyThread threadForFirstPart = new MyThread(firstPart);
        MyThread threadForSecondPart = new MyThread(secondPart);
        threadForFirstPart.start();
        threadForSecondPart.start();
        try {
            threadForFirstPart.join();
            threadForSecondPart.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(firstPart, 0, arr, 0, firstPart.length);
        System.arraycopy(secondPart, 0, arr, firstPart.length, secondPart.length);

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

    }
}
