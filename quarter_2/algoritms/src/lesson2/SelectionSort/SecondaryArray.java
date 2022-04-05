package lesson2.SelectionSort;

import java.util.Random;

public class SecondaryArray {
    private static Random random = new Random();
    private static boolean isRepeat = false;
    private static boolean isShuffle = true;

    public static Integer[] getArray(int lenght, int gapElements) {
        Integer[] arr = new Integer[lenght];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + ((isRepeat) ? (random.nextInt(10) >= 8 ? 0 : gapElements) : gapElements);
        }
        if (isShuffle) {
            shuffleArray(arr);
        }
        return arr;
    }

    public static void shuffleArray(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int change = random.nextInt(n);
            swap(arr, i, change);
        }
    }

    private static void swap(Integer[] a, int first, int second) {
        int memory = a[first];
        a[first] = a[second];
        a[second] = memory;
    }



    public static void main(String[] args) {

        Integer[] arr = SecondaryArray.getArray(50000, 3);

        SpeedTest.startTime();

        SelectionDoubleSort.sort(arr);
//        SelectionSort.sort(arr);
        SpeedTest.endTime();

    }
}
