package IrregularPolygon;

import java.awt.Point;
import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    public IrregularPolygon() {

    }

    public void add(Point2D.Double aPoint) {
        myPolygon.add(aPoint);
    }

    public void draw() {
        DrawingTool pencil = new DrawingTool();
        
        System.out.println("Polygon size: " + myPolygon.size());
        for (int x = 0; x < myPolygon.size(); x++) {
            if (x == 0) {
                pencil.up();
                pencil.move(myPolygon.get(x).x, myPolygon.get(x).y);
                pencil.down();
                System.out.println("Drawing");
                continue;
            }
            pencil.move(myPolygon.get(x).x, myPolygon.get(x).y);
            if (x == myPolygon.size() - 1) {
                pencil.down();
                pencil.move(myPolygon.get(0).x, myPolygon.get(0).y);
                continue;
            }
        }
    }

    public double perimeter() {
        double perimeter = 0.0;
        for (int x = 0; x < myPolygon.size(); x++) {
            if (x == (myPolygon.size() - 1)) {
                perimeter += Point.distance(myPolygon.get(x).x, myPolygon.get(x).y, myPolygon.get(0).x, myPolygon.get(0).y);
                continue;
            }
            perimeter += Point.distance(myPolygon.get(x).x, myPolygon.get(x).y, myPolygon.get(x + 1).x, myPolygon.get(x + 1).y);
            // if (x == (myPolygon.size() - 1)) {
            //     perimeter += Point.distance(myPolygon.get(x).x, myPolygon.get(x).y, myPolygon.get(0).x, myPolygon.get(0).y);
            // }
        }
        return perimeter;
    }

    public double area() {
        int totalFirstElement = 0;
        int totalSecondElement = 0;
        double returningVal = 0;
        for (int x = 0; x < myPolygon.size() - 1; x++) {
          totalFirstElement += myPolygon.get(x).getX() * myPolygon.get(x + 1).getY();
        }
        for (int x = 0; x < myPolygon.size() - 1; x++) {
          totalSecondElement += myPolygon.get(x + 1).getX() * myPolygon.get(x).getY();
        }
        totalFirstElement += myPolygon.get(myPolygon.size() - 1).getX() * myPolygon.get(0).getY();
        totalSecondElement += myPolygon.get(0).getX() * myPolygon.get(myPolygon.size() - 1).getY();
        returningVal = Math.abs(0.5 * (totalFirstElement - totalSecondElement));
        return returningVal;
    }
}
