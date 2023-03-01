package hometask_1_OOP.task3;

public class Circle extends Shape{

    private int diameter;
    private final double PI = 3.14;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    @Override
    Number calculatePerimeter() {
        return PI * diameter;
    }

    @Override
    Number calculateSquare() {
        return PI * Math.pow(diameter, 2) / 4;
    }
}
