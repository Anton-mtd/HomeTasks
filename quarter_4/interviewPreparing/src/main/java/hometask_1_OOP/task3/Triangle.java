package hometask_1_OOP.task3;

public class Triangle extends Shape {

    private int firstSide;

    private int secondSide;

    private int angleBetweenSides;

    public Triangle(int firstSide, int secondSide, int angleBetweenSides) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.angleBetweenSides = angleBetweenSides;
    }

    @Override
    Number calculatePerimeter() {
        double thirdSide = findThirdSide().doubleValue();
        return firstSide + secondSide + thirdSide;
    }

    @Override
    Number calculateSquare() {
        return (firstSide * findHeight()) / 2;
    }

    private Number findThirdSide() {
       double bigCathetus = Math.cos(Math.toRadians(180 - angleBetweenSides)) * secondSide + firstSide;
       double smallCathetus = findHeight();
       return Math.sqrt(Math.pow(bigCathetus, 2) + Math.pow(smallCathetus, 2));
    }

    private double findHeight() {
        return Math.sin(Math.toRadians(180 - angleBetweenSides)) * secondSide;
    }
}
