package se.liu.maxra518.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeTest
{
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Circle shape1 = new Circle(3, 5, 5, Color.red);
        Circle shape2 = new Circle(9, 7, 8, Color.blue);
        Rectangle shape3 = new Rectangle(5, 7,9,10, Color.yellow);
        Text sampleText = new Text(3,5, 3, Color.red, "tja tja");

        shapes.add(shape1);
        shapes.add(shape2);
        shapes.add(shape3);
        shapes.add(sampleText);

    }
}
