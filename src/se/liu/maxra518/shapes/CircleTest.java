package se.liu.maxra518.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CircleTest
{
    public static void main(String[] args) {
        final List<Circle> circles = new ArrayList<>();
        Circle circle1 = new Circle(3, 5,5, Color.red);
        Circle circle2 = new Circle(9, 7,8, Color.blue);
        Circle circle3 = new Circle(5, 7,9, Color.yellow);

        circles.add(circle1);
        circles.add(circle2);
        circles.add(circle3);

        for (Circle circle : circles) {
            System.out.println(circle.getX());
            System.out.println(circle.getY());
        }


    }
}
