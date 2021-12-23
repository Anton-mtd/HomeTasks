package lesson1.Participants;

import lesson1.Participants.Activity;

import java.util.Random;

public class Robot implements Activity {
    private int runDistance;
    private int jumpHeight;

    public Robot(int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public Robot() {
        this.runDistance = new Random().nextInt(1001) + 500;
        this.jumpHeight = new Random().nextInt(8) + 3;
    }

    @Override
    public int runDistance() {
        System.out.println(getClass().getSimpleName() + " может пробежать " + runDistance + " м.");
        return runDistance;
    }

    @Override
    public int jumpHeight() {
        System.out.println(getClass().getSimpleName() + " может перепрыгнуть " + jumpHeight + " м.");
        return jumpHeight;
    }
}
