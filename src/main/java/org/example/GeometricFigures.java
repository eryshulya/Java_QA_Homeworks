package org.example;
//класс родитель
public interface GeometricFigures {
    double calculateArea();
    String getFillColor();
    String getBorderColor();
    default double calculatePerimeter(double... sides){
        double perimeter = 0;
        for (double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }
}
