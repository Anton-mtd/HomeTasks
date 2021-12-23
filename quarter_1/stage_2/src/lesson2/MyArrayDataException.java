package lesson2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException() {
        super("Wrong data");
    }

    public void defineWrongData(int column, int row){
        System.out.printf("В ячейке %s , %s не верный формат. Не число!%n", column, row);
    }
}
