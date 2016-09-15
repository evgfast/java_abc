package com.evg.sandbox;

/**
 * Created by evg on 11.09.16.
 */
public class MainPoint {
    // It calculates the distance between two point.
    public static double distance(Point p1, Point p2){
        double x1 = p1.getX();
        double y1 = p1.getY();

        double x2 = p2.getX();
        double y2 = p2.getY();

        double x = (x2 - x1);
        double y = (y2 - y1);
        double distance = Math.sqrt(Math.pow(x,2) + Math.pow(y , 2));

        return distance;
    }

    public static void main(String[] args) {
        Point point_one = new Point(10.0, 3.0);
        Point point_two = new Point(6.0, 6.0);
        System.out.println("Method 'distance' from com.evg.sandbox.TestPoint class");
        System.out.println(String.format("%4.5f", MainPoint.distance(point_one, point_two)));

        System.out.println();
        System.out.println("Method 'distance' from com.evg.sandbox.Point class");
        System.out.println(String.format("%4.5f", point_one.distance(point_two)));
    }
}
