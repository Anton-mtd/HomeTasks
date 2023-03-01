package hometask_1_OOP.task3;

public class Main {

    public static void main(String[] args) {
        Shape circle = new Circle(15);
        System.out.println("Circle P and S: " + circle.calculatePerimeter() + " and " + circle.calculateSquare());
        Shape square = new Square(10);
        System.out.println("Square P and S: " + square.calculatePerimeter() + " and " + square.calculateSquare());
        Shape triangle = new Triangle(15,13,70);
        System.out.println("Triangle P and S: " + triangle.calculatePerimeter() + " and " + triangle.calculateSquare());
    }

}
