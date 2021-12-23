package lesson1.Difficulty;

import lesson1.Participants.Activity;

import java.util.Random;

public class Wall implements Difficulty {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public Wall() {
        height = new Random().nextInt(6) + 1;
    }

    @Override
    public boolean canPass(Activity participant){
        boolean canJump = height <= participant.jumpHeight();
        if (canJump) {
            System.out.println(participant.getClass().getSimpleName() + " Успешно приодолел высоту " + height + " м." );
            return true;
        }
        else {
            System.out.println(participant.getClass().getSimpleName() + " не смог приодолеть высоту " + height + " м.");
            return false;
        }
    }
}
