package ru.skomorokhin.lesson1.generic.collections;

public class Stats<T extends Number> {

    private T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    public double avg() {
        double sum = 0.0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }

        return sum / nums.length;
    }

    public boolean sameAvg(Stats<?> another) {
        return Math.abs(this.avg() - another.avg()) < 0.00001;
    }

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Stats<Integer> intStats = new Stats<>(ints);
        System.out.println("int avg " + intStats.avg());

        Double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0};
        Stats<Double> dblStats = new Stats<>(doubles);

        System.out.println("dbl avg " + dblStats.avg());

        System.out.println("same avg " + intStats.sameAvg(dblStats));

    }
}
