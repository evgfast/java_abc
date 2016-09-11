
/**
 * Created by evg on 11.09.16.
 */
public class TestPoint {
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
        Point point_one = new Point(20.0, 10.0);
        Point point_two = new Point(65.0, 50.0);
        System.out.println("Method 'distance' from TestPoint class");
        System.out.println(String.format("%4.5f", TestPoint.distance(point_one, point_two)));

        System.out.println();
        System.out.println("Method 'distance' from Point class");
        System.out.println(String.format("%4.5f", point_one.distance(point_two)));
    }
}
