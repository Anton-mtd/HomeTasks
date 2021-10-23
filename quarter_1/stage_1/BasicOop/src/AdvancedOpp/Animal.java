package AdvancedOpp;

public abstract class Animal {

    protected String name;
    private static int counter = 0;

    public Animal(String name) {
        ++counter;
        this.name = name;
    }

    public void run(int distance){
        System.out.println(name + " пробежал(а) " + distance + " м.");
    }

    public void swim(int distance){
        System.out.println(name + " проплыл(а) " + distance + " м.");
    }

    public static int getCounter() {
        return counter;
    }

}