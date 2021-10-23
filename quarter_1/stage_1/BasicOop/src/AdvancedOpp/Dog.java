package AdvancedOpp;

public class Dog extends Animal {

    private final int RUN_DISTANCE = 500;
    private final int SWIM_DISTANCE = 10;

    public Dog(String name) {
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
        if (distance <= SWIM_DISTANCE){
            super.swim(distance);
        }
        else System.out.println(super.name + " не может проплыть больше " + SWIM_DISTANCE + " м.");
    }
}
