package lesson1.Participants;

import lesson1.Participants.Activity;

import java.util.Random;

public class Human implements Activity {
    private int runDistance;
    private int jumpHeight;

    public Human(int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public Human() {
        runDistance = new Random().nextInt(301) + 400;
        jumpHeight = new Random().nextInt(2) + 1;
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
