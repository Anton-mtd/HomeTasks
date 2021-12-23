package lesson2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Двумерный массив не является размером 4Х4!");
    }
}
