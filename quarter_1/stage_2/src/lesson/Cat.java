package lesson;

import java.util.Random;

public class Cat implements Activity {
    private int canRun;
    private int canJump;

    public Cat(int canRun, int canJump) {
        this.canRun = canRun;
        this.canJump = canJump;
    }

    public Cat() {
        canRun = new Random().nextInt(51) + 150;
        this.canJump = new Random().nextInt(1) + 1;
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
