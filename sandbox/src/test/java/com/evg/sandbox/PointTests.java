package com.evg.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by evg on 15.09.16.
 */
public class PointTests {
    Point p1 = new Point(10.0, 3.0);
    Point p2 = new Point(6.0, 6.0);

    @Test
    public void test_getX(){
        Assert.assertEquals( p1.getX(), 10.0);
    }

    @Test
    public void test_getY(){
        Assert.assertEquals(p1.getY(), 3.0);
    }

    @Test
    public void test_setX(){
        p1.setX(7.0);
        Assert.assertEquals(p1.getX(), 7.0);
        p1.setX(3.0);
        Assert.assertEquals(p1.getX(), 3.0);
    }

    @Test
    public void test_distance(){
        Assert.assertEquals(p1.distance(p2), 5.0);
    }
}
