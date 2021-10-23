package AdvancedOpp;

public class Cat extends Animal {

    private final int RUN_DISTANCE = 200;

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance <= RUN_DISTANCE){
            super.run(distance);
        }
        else System.out.println(super.name + " не может пробежать больше " + RUN_DISTANCE + " м.");
    }

    @Override
    public void swim(int distance) {
        System.out.println(super.name + " не умеет плавать");
    }
}
