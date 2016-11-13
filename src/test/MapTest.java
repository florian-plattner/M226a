package test;

import org.junit.Before;
import org.junit.Test;
import program.Map;
import program.Route;

import static org.junit.Assert.*;

/**
 * @author Florian Plattner
 * @version 1.0
 */
public class MapTest {
    Map map;
    int[][] points = {{4, 7}, {8, 12}};
    int pointsCount = 2, width = 16, height = 16;

    @Before
    public void initializeClass() {
        map = new Map(points, width, height);
    }

    @Test
    public void bruteForceRoute() throws Exception {
        Route route = map.bruteForceRoute();
        assertEquals(route.getPoints().length, pointsCount);
        for (int[] point : route.getPoints()){
            assertTrue(point[0] < width && point[0] >= 0);
            assertTrue(point[1] < height && point[1] >= 0);
        }
    }

    @Test
    public void evolveRoute() throws Exception {
        Route route = map.evolveRoute(1000);
        assertEquals(route.getPoints().length, pointsCount);
        for (int[] point : route.getPoints()){
            assertTrue(point[0] < width && point[0] >= 0);
            assertTrue(point[1] < height && point[1] >= 0);
        }
    }

    @Test
    public void getPoints() throws Exception {
        assertEquals(pointsCount, map.getPoints().length);
        for (int[] point : map.getPoints()){
            assertTrue(point[0] < width && point[0] >= 0);
            assertTrue(point[1] < height && point[1] >= 0);
        }
    }

    @Test
    public void getWidth() throws Exception {
        assertEquals(map.getWidth(), width);
    }

    @Test
    public void getHeight() throws Exception {
        assertEquals(map.getHeight(), height);
    }

}