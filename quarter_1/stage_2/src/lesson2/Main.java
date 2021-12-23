package lesson2;

public class Main {
    public static void main(String[] args) {
        String [][] array1 = createAndFillArrayWithData(4,4, "1");
        String[][] array2 = createAndFillArrayWithData(5, 5, "2");
        String[][] array3 = createAndFillArrayWithData(4, 4, "1");
        array3 [1][3] = "a";
        array3 [0][2] = "g";

        sumValues(array1);
        System.out.println("________________");
        sumValues(array2);
        System.out.println("________________");
        sumValues(array3);

        System.out.println("Программа завершена!");
    }

    public static String[][] createAndFillArrayWithData(int column, int row, String number){
        String [][] stringArray = new String[column][row];
        for (int i = 0; i <stringArray.length ; i++) {
            for (int j = 0; j < stringArray[i].length ; j++) {
                stringArray[i][j] = number;
            }
        }
        return stringArray;
    }


    public static boolean checkArray(String[][] array) {
        try {
            if (array.length != 4) {
                throw new MyArraySizeException();
            } else {
                for (String[] string : array) {
                    if (string.length != 4) {
                        throw new MyArraySizeException();
                    }
                }
            }
        } catch (MyArraySizeException myArrayEx) {
            System.out.println(myArrayEx.getMessage());
            return false;
        }
        return true;
    }


    private static void sumValues(String[][] array) {
        if (checkArray(array)) {
            int sum = 0;
            int number = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (!isNumber(array[i][j])) {
                        try {
                            throw new MyArrayDataException();
                        } catch (MyArrayDataException MyDataEx) {
                            MyDataEx.defineWrongData(i, j);
                        }
                    } else {
                        number = Integer.parseInt(array[i][j]);
                        sum += number;
                    }
                }
            }
            System.out.println("Сумма всех чисел в двумерном массиве равна " + sum);
        }
    }


    public static boolean isNumber (String str){
        return str.matches("\\d+");
    }
    
}

