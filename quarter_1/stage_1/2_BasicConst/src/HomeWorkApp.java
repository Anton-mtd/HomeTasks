import java.util.Scanner;

public class HomeWorkApp {
    public static void main(String[] args) {
/*      Все методы были проверены и работают.
        Метод main решил оставить пустым.
*/
    }

    public static boolean sumChecker10_20(int number1, int number2) {
        int sum = number1 + number2;
        return sum > 10 && sum <= 20;
    }

    public static void checkNumber (int number) {
        if (number >= 0)
            System.out.println("Число " + number + ": положительное");
        else
            System.out.println("Число " + number + ": отрицательное");
    }

    public static boolean isNegativeNumber (int number) {
        return number < 0;
    }

    public static void multiPrintString (String line,int number) {
        for (int i = 0; i < number ; i++) {
            System.out.println(line);
        }
    }

    public static boolean leapYear (int year) {
        if (isNegativeNumber(year))
        {
            System.out.println("Ошибка: введите положительное число");
            return false;
        }
        else {
            if (year % 100 == 0){
                if (year % 400 == 0)
                    return true;
                else
                    return false;
            }
            else {
                if (year % 4 == 0)
                    return true;
                else
                    return false;
            }
        }
    }
}
