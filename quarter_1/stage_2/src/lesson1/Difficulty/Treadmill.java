package lesson1.Difficulty;
import lesson1.Participants.Activity;

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
    public boolean canPass(Activity participant){
        boolean canRun = distance <= participant.runDistance();
        if (canRun) {
            System.out.println(participant.getClass().getSimpleName() + " Успешно пробежал дистанцию " + distance + " м.");
            return true;
        }
        else {
            System.out.println(participant.getClass().getSimpleName() + " не смог пробежать дистанцию " + distance + " м.");
            return false;
        }
    }
}
