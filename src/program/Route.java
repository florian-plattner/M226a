package program;

/**
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

    public int[][] getPoints() {
        return points;
    }

    public float getDistance() {
        return distance;
    }
}
