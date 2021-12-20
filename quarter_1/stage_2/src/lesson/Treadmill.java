package lesson;

import java.util.Random;

public class Treadmill implements Difficulty {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public Treadmill() {
        distance = new Random().nextInt(1001) + 100;
    }

    @Override
    public boolean canPass(Activity anyObject){
        boolean canRun = distance <= anyObject.run();
        if (canRun) {
            System.out.println(anyObject.getClass().getSimpleName() + " Успешно пробежал дистанцию " + distance + " м.");
            return true;
        }
        else {
            System.out.println(anyObject.getClass().getSimpleName() + " не смог пробежать дистанцию " + distance + " м.");
            return false;
        }
    }
}
