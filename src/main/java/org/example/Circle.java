package org.example;

public class Circle implements GeometricFigures{
    private double radius;
    private String fillColor;
    private String borderColor;
    public Circle(double radius, String fillColor, String borderColor){
   this.radius = radius;
   this.fillColor = fillColor;
   this.borderColor = borderColor;
    }
    @Override
    public double calculateArea() {
        return 0;
    }
    @Override
    public double calculatePerimeter(double... sides) {
       return Math.PI * radius * radius;
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
