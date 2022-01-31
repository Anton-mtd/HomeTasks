package ru.skomorokhin.lesson1.homeWork.task3;

public class Task3 {

    public static void main(String[] args) {
        Box<Fruit> box1 = new Box<>();
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        box1.addFruit(new Orange());


        Box<Fruit> box2 = new Box<>();
        box2.addFruit(new Apple());
        box2.addFruit(new Apple());
        box2.addFruit(new Apple());

        box1.putInOtherBox(box2);

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
    }
}
