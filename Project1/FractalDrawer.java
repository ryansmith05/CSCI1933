// Written by Ryan Smith, smi01810

import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area

    public FractalDrawer() {}  // contructor
    
    public double getTotalArea(){
        return totalArea;
    }
        
    public double drawFractal(String type) {
        Canvas can = new Canvas();
        while (true){
            if (type.equals("circle")){
                drawCircleFractal(100.0, 400.0, 400.0, Color.BLUE, can, 7);
                return totalArea;
            }else if(type.equals("triangle")){
                drawTriangleFractal(100.0, 100.0, 300.0, 400.0, Color.GREEN, can, 7);
                return totalArea;
            }else if(type.equals("rectangle")){
                drawRectangleFractal(100.0, 200.0, 300.0, 300.0, Color.RED, can, 7);
                return totalArea;
            }else {
                System.out.println("Not a valid option");
                return totalArea;
            }
        }
    }

    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        Triangle myTriangle = new Triangle(x, y, width, height);
        myTriangle.setColor(c);
        can.drawShape(myTriangle);
        if (level == 0){
            this.totalArea = getTotalArea() + myTriangle.calculateArea();
        }
        else {
            double newWidth = 0.5 * myTriangle.getWidth();
            double newHeight = 0.5 * myTriangle.getHeight();
            double xPos1 = myTriangle.getXPos() + myTriangle.getWidth();
            double xPos2 = myTriangle.getXPos() + (0.25 * myTriangle.getWidth());
            double xPos3 = myTriangle.getXPos() - (myTriangle.getWidth() / 2);
            double yPos1 = myTriangle.getYPos() - myTriangle.getHeight();

            Triangle myTriangle1 = new Triangle(xPos1, myTriangle.getYPos(), newWidth, newHeight);
            Triangle myTriangle2 = new Triangle(xPos2, yPos1, newWidth, newHeight);
            Triangle myTriangle3 = new Triangle(xPos3, myTriangle.getYPos(), newWidth, newHeight);

            myTriangle1.setColor(Color.YELLOW);
            myTriangle2.setColor(Color.BLACK);
            myTriangle3.setColor(Color.PINK);

            can.drawShape(myTriangle1);
            can.drawShape(myTriangle2);
            can.drawShape(myTriangle3);

            this.totalArea = getTotalArea() + myTriangle.calculateArea();
            this.totalArea = getTotalArea() + myTriangle1.calculateArea();
            this.totalArea = getTotalArea() + myTriangle2.calculateArea();
            this.totalArea = getTotalArea() + myTriangle3.calculateArea();

            drawTriangleFractal(newWidth, newHeight, xPos1, myTriangle.getYPos(), Color.YELLOW, can, level-1);
            drawTriangleFractal(newWidth, newHeight, xPos2, yPos1, Color.BLACK, can, level-1);
            drawTriangleFractal(newWidth, newHeight, xPos3, myTriangle.getYPos(), Color.PINK, can, level-1);
        }
    }

    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        Circle myCircle = new Circle(x, y, radius);
        myCircle.setColor(c);
        can.drawShape(myCircle);
        if (level == 0){
            this.totalArea = getTotalArea() + myCircle.calculateArea();
        }
        else {
            double newRadius = 0.5 * myCircle.getRadius();
            double xPos1 = myCircle.getXPos() - myCircle.getRadius();
            double xPos2 = myCircle.getXPos() + myCircle.getRadius();
            double yPos1 = myCircle.getYPos() - myCircle.getRadius();
            double yPos2 = myCircle.getYPos() + myCircle.getRadius();

            Circle myCircleLeft = new Circle(xPos1, myCircle.getYPos(), newRadius);
            Circle myCircleRight = new Circle(xPos2, myCircle.getYPos(), newRadius);
            Circle myCircleTop = new Circle(myCircle.getXPos(), yPos1, newRadius);
            Circle myCircleBottom = new Circle(myCircle.getXPos(), yPos2, newRadius);

            myCircleLeft.setColor(Color.RED);
            myCircleRight.setColor(Color.GREEN);
            myCircleTop.setColor(Color.GRAY);
            myCircleBottom.setColor(Color.YELLOW);

            can.drawShape(myCircleLeft);
            can.drawShape(myCircleRight);
            can.drawShape(myCircleTop);
            can.drawShape(myCircleBottom);

            this.totalArea = getTotalArea() + myCircle.calculateArea();
            this.totalArea = getTotalArea() + myCircleLeft.calculateArea();
            this.totalArea = getTotalArea() + myCircleRight.calculateArea();
            this.totalArea = getTotalArea() + myCircleTop.calculateArea();
            this.totalArea = getTotalArea() + myCircleBottom.calculateArea();

            drawCircleFractal(newRadius, xPos1, myCircle.getYPos(), Color.RED, can, level-1);
            drawCircleFractal(newRadius, xPos2, myCircle.getYPos(), Color.GREEN, can, level-1);
            drawCircleFractal(newRadius, myCircle.getXPos(), yPos1, Color.GRAY, can, level-1);
            drawCircleFractal(newRadius, myCircle.getXPos(), yPos2, Color.YELLOW, can, level-1);
        }
    }

    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Rectangle myRectangle = new Rectangle(x, y, width, height);
        myRectangle.setColor(c);
        can.drawShape(myRectangle);
        if (level == 0){
            this.totalArea = getTotalArea() + myRectangle.calculateArea();
        }
        else {
            double newWidth = 0.5 * myRectangle.getWidth();
            double newHeight = 0.5 * myRectangle.getHeight();
            double xPos1 = myRectangle.getXPos() - newWidth;
            double xPos2 = myRectangle.getXPos() - newWidth;
            double xPos3 = myRectangle.getXPos() + myRectangle.getWidth();
            double xPos4 = myRectangle.getXPos() + myRectangle.getWidth();
            double yPos1 = myRectangle.getYPos() - newHeight;
            double yPos2 = myRectangle.getYPos() + myRectangle.getHeight();
            double yPos3 = myRectangle.getYPos() - newHeight;
            double yPos4 = myRectangle.getYPos() + myRectangle.getHeight();

            Rectangle myRectangle1 = new Rectangle(xPos1, yPos1, newWidth, newHeight);
            Rectangle myRectangle2 = new Rectangle(xPos2, yPos2, newWidth, newHeight);
            Rectangle myRectangle3 = new Rectangle(xPos3, yPos3, newWidth, newHeight);
            Rectangle myRectangle4 = new Rectangle(xPos4, yPos4, newWidth, newHeight);

            myRectangle1.setColor(Color.BLUE);
            myRectangle2.setColor(Color.YELLOW);
            myRectangle3.setColor(Color.GREEN);
            myRectangle4.setColor(Color.ORANGE);

            can.drawShape(myRectangle1);
            can.drawShape(myRectangle2);
            can.drawShape(myRectangle3);
            can.drawShape(myRectangle4);

            this.totalArea = getTotalArea() + myRectangle.calculateArea();
            this.totalArea = getTotalArea() + myRectangle1.calculateArea();
            this.totalArea = getTotalArea() + myRectangle2.calculateArea();
            this.totalArea = getTotalArea() + myRectangle3.calculateArea();
            this.totalArea = getTotalArea() + myRectangle4.calculateArea();

            drawRectangleFractal(newWidth, newHeight, xPos1, yPos1, Color.BLUE, can, level-1);
            drawRectangleFractal(newWidth, newHeight, xPos2, yPos2, Color.YELLOW, can, level-1);
            drawRectangleFractal(newWidth, newHeight, xPos3, yPos3, Color.GREEN, can, level-1);
            drawRectangleFractal(newWidth, newHeight, xPos4, yPos4, Color.ORANGE, can, level-1);
        }
    }

    public static void main(String[] args){
        System.out.println("Type in all lowercase letters circle, triangle, or rectangle to use for your fractal");
        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();
        FractalDrawer fractalDraw = new FractalDrawer();
        double totalAreaResult = fractalDraw.drawFractal(choice);
        System.out.println("The total area of the Fractal is: " + totalAreaResult);
        myScanner.close();       
    }
}
