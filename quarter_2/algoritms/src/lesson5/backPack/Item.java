package lesson5.backPack;

public class Item {
    private final String name;
    private final int cost;
    private final int weight;

    public Item(String name, int cost, int weight) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String
    toString() {
        return this.getName();
    }
}
