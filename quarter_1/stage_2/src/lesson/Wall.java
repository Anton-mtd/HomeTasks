package lesson;

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
    public boolean canPass(Activity anyObject){
        boolean canJump = height <= anyObject.jump();
        if (canJump) {
            System.out.println(anyObject.getClass().getSimpleName() + " Успешно приодолел высоту " + height + " м." );
            return true;
        }
        else {
            System.out.println(anyObject.getClass().getSimpleName() + " не смог приодолеть высоту " + height + " м.");
            return false;
        }
    }
}
