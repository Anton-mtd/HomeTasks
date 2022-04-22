package lesson5;

public class Exponentiation {


    public static void main(String[] args) {
        System.out.println(Exponentiation.exponent(3, 4));
        System.out.println(Exponentiation.exponent(3, -4));
    }

    public static double exponent(double number, int rate) {

        if (rate > 0) {
            return (double) number * (exponent(number, --rate));
        } else if (rate == 0) {
            return 1;
        } else {
            return 1 / number * (exponent(number, ++rate));
        }
    }
}
