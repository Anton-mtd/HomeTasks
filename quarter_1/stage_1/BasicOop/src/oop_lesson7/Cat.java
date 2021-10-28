package oop_lesson7;

public class Cat {

    private final int appetite;
    private final String name;
    private boolean fullness;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFullness() {
        return fullness;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        if (appetite > plate.getFood()){
            System.out.println("Food is not enough. Please add " + (appetite - plate.getFood()) + " food's unit or more.");
        }
        else {
            System.out.println("Cat has eaten!");
            fullness = true;
            plate.decreaseFood(appetite);
        }
    }

    @Override
    public String
    toString() {
        return name + ":\n"
                + "appetite = " + appetite + "\n"
                + "name = " + name + "\n"
                + "fullness = " + fullness + "\n";
    }
}
