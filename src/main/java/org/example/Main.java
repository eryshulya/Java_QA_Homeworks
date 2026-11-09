package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 4, 9, "Black", "White");
        Rectangle rectangle = new Rectangle(1, 2, "Brown", "Purp");
        Circle circle = new Circle(4, "Pink", "Orange");
        System.out.println("КРУГ");
        System.out.println("Периметр: " + circle.calculatePerimeter());
        System.out.println("Площадь: " + circle.calculateArea());
        System.out.println("Цвет заливки: " + circle.getFillColor());
        System.out.println("Цвет границы: " + circle.getBorderColor());
        System.out.println("....................");
        System.out.println("ПРЯМОУГОЛЬНИК");
        System.out.println("Периметр: " + rectangle.calculatePerimeter());
        System.out.println("Площадь: " + rectangle.calculateArea());
        System.out.println("Цвет заливки: " + rectangle.getFillColor());
        System.out.println("Цвет границы: " + rectangle.getBorderColor());
        System.out.println("....................");
        System.out.println("ТРЕУГОЛЬНИК");
        System.out.println("Периметр: " + triangle.calculatePerimeter());
        System.out.println("Площадь: " + triangle.calculateArea());
        System.out.println("Цвет заливки: " + triangle.getFillColor());
        System.out.println("Цвет границы: " + triangle.getBorderColor());
    }
}