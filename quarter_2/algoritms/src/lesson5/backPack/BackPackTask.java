package lesson5.backPack;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BackPackTask {
    private static List<Item> itemsForCarry = new ArrayList<>();
    private static int betterWeight = 0;
    private static int betterCost = 0;
    private static BackPack backPack = new BackPack(13);
    private static int counter = 0;


    public static void main(String[] args) {

        itemsForCarry.add(new Item("PhotoCamera", 130000, 3));
        itemsForCarry.add(new Item("LapTop", 70000, 8));
        itemsForCarry.add(new Item("AudioColumn", 50000, 2));
        itemsForCarry.add(new Item("HairClipper", 10000, 1));
        itemsForCarry.add(new Item("toolKit", 15000, 8));
        itemsForCarry.add(new Item("desktopGame", 12000, 3));
        itemsForCarry.add(new Item("bicycle", 50000, 8));

        theBestFillingForBackpack(itemsForCarry, itemsForCarry.size());

        for (Item insideItem : backPack.getInsideItems()) {
            System.out.printf("предмет: %s цена: %s вес: %s \n", insideItem.getName(), insideItem.getCost(), insideItem.getWeight());
        }
        System.out.println("__________________________________________");
        System.out.println("общая стоимость " + backPack.getTotalCost());
        System.out.println("общая вес " + backPack.getTotalWeight());
    }


    public static void theBestFillingForBackpack(List<Item> list, int length) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {

            List<Item> newList = doOrderSelection(list, length);

            theBestFillingForBackpack(newList, length - 1);

            Set<Integer> excludeIndexes = new LinkedHashSet<>();

            for (int j = 0; j < newList.size(); j++) {
                excludeIndexes.add(j);
                if (totalWeight(excludeIndexes) > backPack.getCapacity()) {
                    continue;
                } else {
                    if (betterCost < totalCost(excludeIndexes)) {
                        betterCost = totalCost(excludeIndexes);
                        betterWeight = totalWeight(excludeIndexes);
                        backPack.setInsideItems(possibleProfitablestOption(excludeIndexes));
                    }
                }
            }
        }
    }

    public static List<Item> doOrderSelection(List<Item> list, int length) {

        int startPosition = list.size() - length;
        Item temp = list.get(list.size() - 1);

        for (int i = list.size() - 1; i >= startPosition; i--) {
            if (i == startPosition) {
                list.set(i, temp);
            } else {
                list.set(i, list.get(i - 1));
            }
        }
        return list;
    }


    private static int totalWeight(Set<Integer> exceptIndexes) {
        int totalWeight = 0;
        for (int i = 0; i < itemsForCarry.size(); i++) {
            if (exceptIndexes.contains(i)) {
                continue;
            } else {
                totalWeight += itemsForCarry.get(i).getWeight();
            }
        }
        return totalWeight;
    }


    private static int totalCost(Set<Integer> exceptIndexes) {
        int totalCost = 0;
        for (int i = 0; i < itemsForCarry.size(); i++) {
            if (exceptIndexes.contains(i)) {
                continue;
            } else {
                totalCost += itemsForCarry.get(i).getCost();
            }
        }
        return totalCost;
    }


    private static List<Item> possibleProfitablestOption(Set<Integer> exceptIndexes) {
        List<Item> preparedList = new ArrayList<>();
        for (int i = 0; i < itemsForCarry.size(); i++) {
            if (exceptIndexes.contains(i)) {
                continue;
            } else {
                preparedList.add(itemsForCarry.get(i));
            }
        }
        return preparedList;
    }
}
