package hometask_1_OOP.task3;

public class Square extends Shape {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    Number calculatePerimeter() {
        return side * 4;
    }

    @Override
    Number calculateSquare() {
        return Math.pow(side, 2);
    }
}
