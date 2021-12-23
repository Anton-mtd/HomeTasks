package lesson1;

import lesson1.Difficulty.Difficulty;
import lesson1.Difficulty.Treadmill;
import lesson1.Difficulty.Wall;
import lesson1.Participants.Activity;
import lesson1.Participants.Cat;
import lesson1.Participants.Human;
import lesson1.Participants.Robot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int choise = 0;
        Random random = new Random();

        List<Difficulty> difficulties = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            choise = random.nextInt(11);
            if (choise <= 5) {
                difficulties.add(new Treadmill());
            } else {
                difficulties.add(new Wall());
            }
        }

        List<Activity> participants = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            choise = choise = random.nextInt(11);
            if (choise <= 4) {
                participants.add(new Cat());
            } else if (choise < 7) {
                participants.add(new Human());
            } else {
                participants.add(new Robot());
            }
        }

        for (Difficulty difficulty : difficulties) {
            Iterator<Activity> iterator = participants.iterator();
            while (iterator.hasNext()) {
                if (!difficulty.canPass(iterator.next())) {
                    iterator.remove();
                    System.out.println("Испытание препятствия не завершено. Участник выбывает\n");
                } else {
                    System.out.println("Испытание препятствия завершено. Участник идет дальше\n");
                }
            }
        }
    }
}
