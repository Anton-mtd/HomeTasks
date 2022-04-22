package lesson5.backPack;

import java.util.ArrayList;
import java.util.List;

public class BackPack {

    private List<Item> insideItems = new ArrayList<>();
    private int capacity;


    public BackPack(int capacity) {
        this.capacity = capacity;
    }


    public void setInsideItems(List<Item> insideItems) {
        this.insideItems = insideItems;
    }

    public List<Item> getInsideItems() {
        return insideItems;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (Item insideItem : insideItems) {
            totalCost += insideItem.getCost();
        }
        return totalCost;
    }

    public int getTotalWeight() {
        int totalweight = 0;
        for (Item insideItem : insideItems) {
            totalweight += insideItem.getWeight();
        }
        return totalweight;
    }
}
