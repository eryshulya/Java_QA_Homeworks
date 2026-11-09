package org.example;
public class Triangle implements GeometricFigures {
private double a;
private double b;
private double c;
private double height;
private String fillColor;   // цвет заливки
private String borderColor; // цвет границы
public Triangle(int a,int b, int c, double height, String fillColor, String borderColor){
    this.a = a;
    this.b = b;
    this.c = c;
    this.fillColor = fillColor;
    this.borderColor = borderColor;
    this.height = height;
}
    @Override
    public double calculateArea() {
        return a * height / 2.0;
    }
    public double calculatePerimeter() {
      return calculatePerimeter(a, b, c);
    }
    @Override
    public String getFillColor() {
        return fillColor;
    }
    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
