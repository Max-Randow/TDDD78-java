package se.liu.maxra518.shapes;

import java.awt.*;
import java.util.ArrayList;

public class ShapeTest
{
    public static void main(String[] args) {
        final ArrayList<Shape> Shapes = new ArrayList<>();
        Circle shape1 = new Circle(3, 5, 5, Color.red);
        Circle shape2 = new Circle(9, 7, 8, Color.blue);
        Rectangle shape3 = new Rectangle(5, 7,9,10, Color.yellow);
        Text sampleText = new Text(3,5, 3, Color.red, "tja tja");

        Shapes.add(shape1);
        Shapes.add(shape2);
        Shapes.add(shape3);
        Shapes.add(sampleText);

        for (Shape shape : Shapes) {
            //shape.draw();
        }


    }
}
