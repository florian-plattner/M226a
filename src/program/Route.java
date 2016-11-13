package program;

/**
 * Represents a map with points on it. The class contains Methods to find a route to travel all of the points with a
 * minimal traveling distance.
 *
 * Contains an array with points that describe coordinates in 2D space within the boundaries of the width and height.
 * The main use of this class is the findRoute method which is used to calculate an order of connecting all of the
 * points in which the overall connection distance is as short as possible.
 *
 * @author Florian Plattner
 * @version 1.0
 */
public class Route {
    private int[][] points;
    private float distance;

    public Route(int[][] points, float distance) {
        this.points = points;
        this.distance = distance;
    }

    public float getDistance() {
        return distance;
    }

    public int[][] getPoints() {
        return points;
    }
}
