package org.example;

public class Rectangle implements GeometricFigures {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
        public double calculatePerimeter() {
            return calculatePerimeter(width, height, width, height);
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

