package lesson2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int column, int row) {
        super(String.format("В ячейке %s , %s не верный формат. Не число!%n", column, row));

    }
}
