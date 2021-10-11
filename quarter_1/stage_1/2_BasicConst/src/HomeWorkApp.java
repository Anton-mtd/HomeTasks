import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp {

    public static void main(String[] args) {
//        Урок 3
//        задание 1
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) array1[i] = 1;
            else array1[i] = 0;
        }
//______________________________________
//        задание 2
        int[] array2 = new int[100];
        for (int i = 1; i <= 100; i++) {
            array2[i - 1] = i;
        }
//______________________________________
//        задание 3
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                System.out.println("Элемент массива: [" + i + "] равен " + array3[i] + " что меньше 6, поэтому умножаем его на 2 и получаем " + array3[i] * 2);
            }
        }
//______________________________________
//        задание 4
        int[][] array4 = new int[7][7];
        for (int i = 0; i < array4.length; i++) {
            array4[i][i] = 1;
            array4[i][array4.length - 1 - i] = 1;
        }
        for (int i = 0; i < array4.length; i++) {
            System.out.println();
            for (int j = 0; j < array4[i].length; j++) {
                System.out.print(array4[i][j] + "   ");
            }
        }
//
        System.out.println();
//______________________________________
//        задание 5
        int[] array5 = createArray(5, 4);
        for (int i : array5) {
            System.out.print(array5[i]);
        }
//
        System.out.println();
//______________________________________
//        задание 6
        int[] array6 = new int[10];
        Random random = new Random();
        for (int i = 0; i < array6.length; i++) {
            array6[i] = random.nextInt(101);
        }
        int maxValue = array6[0];
        int minValue = array6[0];
        for (int i = 0; i < array6.length; i++) {
            if (array6[i] > maxValue) maxValue = array6[i];
            else if (array6[i] < minValue) minValue = array6[i];
        }

        System.out.println("max: " + maxValue);
        System.out.println("min: " + minValue);
//______________________________________
//        задание 7
        int[] array7_1 = {1,2,3,4,5,7,8};
        int[] array7_2 = {1,2,3,4,5,7,9};

        System.out.println(isEqualArrayParts(array7_1));
        System.out.println(isEqualArrayParts(array7_2));
//
        System.out.println();
//______________________________________
//        задание 8
        int[] array8 = {1,2,3,4,5,6,7,8};

        moveArraysElement(array8,3);
        moveArraysElement(array8,-4);

        for (int i : array8) {
            System.out.print(i + ",");
        }
    }

    public static int[] createArray ( int len, int initialValue){
            int[] array = new int[len];
            Arrays.fill(array, initialValue);
            return array;
        }

    public static boolean isEqualArrayParts(int[] array) {
        int numberArray = 1;
        int leftPart = 0;
        int rightPart = 0;
        for (int value : array) {
            leftPart += value;
            rightPart = 0;
            for (int j = numberArray; j < array.length; j++) {
                rightPart += array[j];
                if (leftPart == rightPart && j == array.length - 1) return true;
                else if (leftPart < rightPart) break;
            }
            ++numberArray;
        }
        return false;
    }

    public static void moveArraysElement(int[] array, int number) {
        if (number < 0){
            number = array.length - Math.abs(number);
        }
        int nextValue = 0;
        int currentValue = array[0];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j == array.length - 1) {
                    array[0] = currentValue;
                }
                else{
                    nextValue = array[j + 1];
                    array[j + 1] = currentValue;
                    currentValue = nextValue;
                }
            }
        }
    }
}
