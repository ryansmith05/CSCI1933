// Written by Ryan Smith, smi01810

import java.awt.Color;

public class Rectangle {
    private double xPosition;
    private double yPosition;
    private double width;
    private double height;
    private Color color;

    public Rectangle(double xPosition, double yPosition, double width, double height){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
    }

    public double calculatePerimeter(){
        return (this.getWidth() * 2) + (this.getHeight() * 2);
    }

    public double calculateArea(){
        return this.getWidth() * this.getHeight();
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public void setPos(double xPosition, double yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public double getXPos(){
        return xPosition;
    }

    public double getYPos(){
        return yPosition;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public double getWidth(){
        return width;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight(){
        return height;
    }
}
