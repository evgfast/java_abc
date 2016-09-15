package com.evg.sandbox;

/**
 * Created by evg on 11.09.16.
 */
public class Point {
    private double x = 0.0;
    private double y = 0.0;

    public Point(){
        this(0.0, 0.0);
    }
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "com.evg.sandbox.Point(" +
                "x = " + x +
                ", y = " + y +
                ')';
    }

    public double distance(Point p){
        double x1 = this.x;
        double y1 = this.y;

        double x2 = p.getX();
        double y2 = p.getY();

        double x = (x2 - x1);
        double y = (y2 - y1);
        double distance = Math.sqrt(Math.pow(x,2) + Math.pow(y , 2));

        return distance;
    }
}
