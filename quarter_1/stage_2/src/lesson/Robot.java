package lesson;

import java.util.Random;

public class Robot implements Activity {
    private int canRun;
    private int canJump;

    public Robot(int canRun, int canJump) {
        this.canRun = canRun;
        this.canJump = canJump;
    }

    public Robot() {
        this.canRun = new Random().nextInt(1001) + 500;
        this.canJump = new Random().nextInt(8) + 3;
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
