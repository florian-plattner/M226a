package program;

/**
 * Contains only static methods that are used to visualize the content of Maps.
 *
 * @author Florian Plattner
 * @version 1.0
 */
public class Visualizer {

    public static void printMap(Route route, int width, int height){
        int[][] points = route.getPoints();
        char[][] output = new char[height][width * 2];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width * 2; x++) {
                output[y][x] = ' ';
            }
        }
        for (int i = 0; i < points.length; i++) {
            int[] point = {points[i][0], points[i][1]};
            char[] number = String.valueOf(i).toCharArray();
            for (int i1 = 0; i1 < number.length; i1++) {
                if (point[0] + i1 < output.length) {
                    output[point[1]][point[0] + i1] = number[i1];
                }
            }
        }
        for (int y = height - 1; y >= 0; y--) {
            for (int x = 0; x < width * 2; x++) {
                System.out.print(output[y][x]);
            }
            System.out.print("\n");
        }
    }
}
