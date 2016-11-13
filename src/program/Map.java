package program;

import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private int[][] points;
    private int width, height;

    public Map(int[][] points, int width, int height){
        this.points = points;
        this.width = width;
        this.height = height;
    }

    public Route bruteForceRoute() {
        int length = points.length;

        int[] order = new int[length];
        for (int i = 0; i < length; i++) {
            order[i] = i;
        }

        ArrayList<int[]> routes = generatePermutations(length, order);

        float shortestDistance = 0;
        int[] shortestOrder = new int[length];

        for (int i = 0; i < routes.size(); i++) {
            int[] currentOrder = routes.get(i);
            float distance = getDistance(currentOrder);

            if (i == 0) {
                shortestDistance = distance;
                shortestOrder = currentOrder;
            } else if (distance < shortestDistance) {
                shortestDistance = distance;
                shortestOrder = currentOrder;
            }
        }

        int[][] orderedPoints = new int[points.length][2];

        for (int i = 0; i < length; i++) {
            orderedPoints[i] = points[shortestOrder[i]];
        }

        return new Route(orderedPoints, shortestDistance);
    }

    public Route evolveRoute(int generations){
        int[] order = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            order[i] = i;
        }

        for (int generation = 0; generation < generations; generation++){
            float shortestDistance = 0;
            int[] shortestOrder = new int[order.length];
            for(int i = 0; i < 32; i++){
                int[] temporaryOrder = order.clone();
                for(int i1 = 0; i1 < 2; i1++){
                    int index = (int)Math.round(Math.random() * (order.length - 1));
                    int index1 = (int)Math.round(Math.random() * (order.length - 1));
                    int temp = temporaryOrder[index];
                    temporaryOrder[index] = temporaryOrder[index1];
                    temporaryOrder[index1] = temp;
                }
                float distance = getDistance(temporaryOrder);
                if (i == 0 || distance < shortestDistance) {
                    shortestDistance = distance;
                    shortestOrder = temporaryOrder;
                }
            }

            order = shortestOrder;
        }

        int[][] orderedPoints = new int[points.length][2];

        for (int i = 0; i < points.length; i++) {
            orderedPoints[i] = points[order[i]];
        }

        return new Route(orderedPoints, getDistance(order));
    }

    private float getDistance(int[] order){
        float distance = 0;

        for (int i = 0; i < points.length; i++) {
            int[] point = points[order[i]];
            int[] point1;

            if (i >= points.length - 1){
                point1 = points[order[0]];
            } else {
                point1 = points[order[i + 1]];
            }

            distance += (float) Math.sqrt(Math.pow(point1[0] - point[0], 2) + Math.pow(point1[1] - point[1], 2));
        }

        return distance;
    }

    private ArrayList<int[]> generatePermutations(int n, int[] array) {
        ArrayList<int[]> permutations = new ArrayList<>();
        if (n == 1) {
            permutations.add(array.clone());
        } else {
            permutations.addAll(generatePermutations(n - 1, array));
            for (int i = 0; i != n - 1; i++) {
                if (n % 2 == 0) {
                    int temp = array[i];
                    array[i] = array[n - 1];
                    array[n - 1] = temp;
                } else {
                    int temp = array[0];
                    array[0] = array[n - 1];
                    array[n - 1] = temp;
                }
                permutations.addAll(generatePermutations(n - 1, array));
            }
        }
        return permutations;
    }


    public int[][] getPoints() {
        return points;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
