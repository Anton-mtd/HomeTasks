package oop_lesson7;

import java.util.Random;

public class TestCatEating {

    public static void main(String[] args) {

        Random random = new Random();
        Plate plate = new Plate(100);
        Cat[] cats = new Cat[10];
        for (int i = 1; i <= 10 ; i++) {
            cats[i - 1] = new Cat("cat " + i, 10 + random.nextInt(5));
            cats[i - 1].eat(plate);
            System.out.println(cats[i - 1].toString());
        }

        System.out.println("Add food for hungry cats \n");
        for (Cat cat : cats) {
            if (!cat.isFullness()){
                plate.increaseFood(cat.getAppetite() - plate.getFood());
                cat.eat(plate);
                System.out.println(cat.toString());
            }
        }
    }
}
