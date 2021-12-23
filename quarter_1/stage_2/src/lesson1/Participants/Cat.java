package lesson1.Participants;

import lesson1.Participants.Activity;

import java.util.Random;

public class Cat implements Activity {
    private int runDistance;
    private int jumpHeight;

    public Cat(int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public Cat() {
        runDistance = new Random().nextInt(51) + 150;
        this.jumpHeight = new Random().nextInt(1) + 1;
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
