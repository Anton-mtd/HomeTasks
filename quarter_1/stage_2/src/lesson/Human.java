package lesson;

import java.util.Random;

public class Human implements Activity  {
    private int canRun;
    private int canJump;

    public Human(int canRun, int canJump) {
        this.canRun = canRun;
        this.canJump = canJump;
    }

    public Human() {
        canRun = new Random().nextInt(301) + 400;
        canJump = new Random().nextInt(2) + 1;
    }


    @Override
    public int run() {
        System.out.println(getClass().getSimpleName() + " может пробежать " + canRun + " м.");
        return canRun;
    }

    @Override
    public int jump() {
        System.out.println(getClass().getSimpleName() + " может перепрыгнуть " + canJump + " м.");
        return canJump;
    }

}
