package lesson2;

public class Main {

    private static final int REQUIRED_SIZE = 4;

    public static void main(String[] args) {
        String[][] array1 = createAndFillArrayWithData(4, 4, "1");
        String[][] array2 = createAndFillArrayWithData(5, 5, "2");
        String[][] array3 = createAndFillArrayWithData(4, 4, "1");
        array3[1][3] = "a";
        array3[0][2] = "g";

        try {
            sumValues(array1);
            System.out.println("________________");
            sumValues(array2);
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            sumValues(array3);
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Программа завершена!");
    }

    private static String[][] createAndFillArrayWithData(int column, int row, String number) {
        String[][] stringArray = new String[column][row];
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                stringArray[i][j] = number;
            }
        }
        return stringArray;
    }


    private static void checkArray(String[][] array) {
        if (array.length != REQUIRED_SIZE) {
            throw new MyArraySizeException();
        }
        for (String[] string : array) {
            if (string.length != REQUIRED_SIZE) {
                throw new MyArraySizeException();
            }
        }
    }


    private static void sumValues(String[][] array) {
        checkArray(array);
        int sum = 0;
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    number = Integer.parseInt(array[i][j]);
                    sum += number;
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Сумма всех чисел в двумерном массиве равна " + sum);
    }

}

