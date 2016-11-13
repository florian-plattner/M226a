package test;

import org.junit.Before;
import org.junit.Test;
import program.Route;

import static org.junit.Assert.*;

/**
 * @author Florian Plattner
 * @version 1.0
 */
public class RouteTest {
    Route route;
    int[][] points = {{4, 7}, {8, 12}};
    int pointsCount = 2;

    @Before
    public void initializeClass() {
        route = new Route(points, 12);
    }

    @Test
    public void getDistance() throws Exception {
        assertNotNull(route.getDistance());
    }

    @Test
    public void getPoints() throws Exception {
        assertEquals(pointsCount, route.getPoints().length);
    }

}