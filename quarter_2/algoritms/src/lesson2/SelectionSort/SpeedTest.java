package lesson2.SelectionSort;

public class SpeedTest {

    private static long time;

    public static void startTime() {
        time = System.currentTimeMillis();
    }

    public static void endTime() {
        time = System.currentTimeMillis() - time;
        System.out.println(time);
    }
}
