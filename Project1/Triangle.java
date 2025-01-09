// Written by Ryan Smith, smi01810

import java.awt.Color;

public class Triangle{
    private double xPosition;
    private double yPosition;
    private double width;
    private double height;
    private Color color;

    public Triangle(double xPosition, double yPosition, double width, double height){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
    }

    public double calculatePerimeter(){
        return 3 * this.getWidth();
    }

    public double calculateArea(){
        return 0.5 * (this.getWidth() * this.getHeight());
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

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }
}
