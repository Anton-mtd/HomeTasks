package lesson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int choise = 0;
        Random random = new Random();

        ArrayList <Difficulty> difficulties = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            choise = random.nextInt(11);
            if (choise <= 5) {
                difficulties.add(new Treadmill());
            }
            else difficulties.add(new Wall());
        }

        ArrayList <Activity> participants = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            choise = choise = random.nextInt(11);
            if (choise <= 4){
                participants.add(new Cat());
            }
            else if (choise < 7){
                participants.add(new Human());
            }
            else participants.add(new Robot());
        }

        for (Difficulty difficulty : difficulties) {
            Iterator <Activity> iterator = participants.iterator();
            while (iterator.hasNext()){
                if(!difficulty.canPass(iterator.next())){
                    iterator.remove();
                    System.out.println("Испытание препятствия завершено. Участник выбывает\n");
                }
                else
                    System.out.println("Испытание препятствия завершено. Участник идет дальше\n");
            }
        }
    }
}
