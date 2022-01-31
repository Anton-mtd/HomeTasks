package ru.skomorokhin.lesson1.homeWork.task3;


import java.util.ArrayList;
import java.util.List;

public class Box<E extends Fruit> {

    List<E> fruitList;
    private FruitType fruitType;

    public Box() {
        fruitList = new ArrayList<E>();
        fruitType = null;
    }

    private enum FruitType {
        APPLE, ORANGE,
    }

    public void addFruit(E fruit) {
        if (fruitList.isEmpty()) {
            if (fruit instanceof Apple) {
                fruitType = FruitType.APPLE;
                fruitList.add(fruit);
            } else if (fruit instanceof Orange) {
                fruitType = FruitType.ORANGE;
                fruitList.add(fruit);
            }
        } else if (fruitList.get(0).getClass() == fruit.getClass()) {
            fruitList.add(fruit);
        } else {
            System.out.println("фрукт несовместим для добавления");
        }
    }

    public float getWeight() {
        float totalWeight = 0;
        for (E fruit : fruitList) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box box) {
        if (this.getWeight() == box.getWeight()) {
            return true;
        } else return false;
    }

    public void putInOtherBox(Box box) {
        if (this.fruitType == box.fruitType) {
            box.fruitList.addAll(this.fruitList);
            this.fruitList.clear();
            this.fruitType = null;
        } else if (box.fruitList.isEmpty()) {
            box.fruitList.addAll(this.fruitList);
            this.fruitList.clear();
            box.fruitType = this.fruitType;
            this.fruitType = null;
        } else if (this.fruitType == null) {
            System.out.println("коробка пустая, нечего пересыпать");
        } else {
            System.out.println("Фрукты в данных коробках несовместимы");
        }
    }
}
