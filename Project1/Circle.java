// Written by Ryan Smith, smi01810

import java.awt.Color;

public class Circle {
    private double xPosition;
    private double yPosition;
    private double radius;
    private Color color;

    public Circle(double xPosition, double yPosition, double radius) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.radius = radius;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * this.getRadius();
    }

    public double calculateArea() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setPos(double xPosition, double yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    public double getXPos() {
        return xPosition;
    }

    public double getYPos() {
        return yPosition;
    }
}


