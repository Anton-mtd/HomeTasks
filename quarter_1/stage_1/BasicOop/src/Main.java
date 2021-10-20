import AdvancedOpp.*;


public class Main {

    public static void main(String[] args) {
        Animal cat = new Cat("Barsik");
        Animal dog = new Dog("Jack");

        cat.run(100);
        cat.swim(12);
        dog.run(10);
        dog.swim(10);

        System.out.println("Всего создано животных " + Animal.getCounter());
    }

}
