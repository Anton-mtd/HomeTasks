package lesson6;

import java.util.ArrayList;
import java.util.Random;

public class HomeTask {

    private static Random random = new Random();
    private static int treesCounter = 0;
    private static int notBalanceTreesCounter = 0;
    public static ArrayList <TreeImpl<Integer>> trees = new ArrayList<>();

    public static void main(String[] args) {

       while (treesCounter != 20) {
           TreeImpl<Integer> tree = new TreeImpl<>(4);
           while (!tree.isReachedMaxDepthLevel()) {
               tree.add(randomValue());
           }
           trees.add(tree);
           treesCounter++;
       }
        int number = 0;
        for (TreeImpl<Integer> tree : trees) {
            if (!tree.isBalanceTree()) {
                notBalanceTreesCounter++;
            }
            System.out.println(++number + ") " + "balanceTree :" + tree.isBalanceTree());
            tree.display();
        }
        System.out.println("процент несбалансированых деревьев: " + (100 / treesCounter * notBalanceTreesCounter));

    }

    public static int randomValue() {
        int min = -25;
        int max = 25;
        return max - random.nextInt(Math.abs(min) + max + 1);
    }

}
