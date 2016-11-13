package program;

import java.util.ArrayList;

/**
 * Contains maps and methods to compare them and uses the Visualizer class to print the maps.
 *
 * @author Florian Plattner
 * @version 1.0
 */
public class Analytic {
    private ArrayList<Map> maps;

    public Analytic() {
        maps = new ArrayList<>();
    }

    public void removeMaps(){
        maps.clear();
    }

    public void addMap(int pointsCount){
        int[][] points = new int[pointsCount][2];
        for (int[] point : points) {
            point[0] = (int) (Math.random() * (24 - 1));
            point[1] = (int) (Math.random() * (24 - 1));
        }
        maps.add(new Map(points, 24, 24));
    }

    public void bruteForceRoute(){
        for (Map map : maps) {
            System.out.print("\n");
            for (int i = 0; i < map.getWidth(); i++) System.out.print("--");
            long time = System.currentTimeMillis();
            Route route = map.bruteForceRoute();
            long timeDifference = System.currentTimeMillis() - time;
            Visualizer.printMap(route, 24, 24);
            for (int i = 0; i < map.getWidth(); i++) System.out.print("--");
            System.out.println("\nDistance: " + route.getDistance());
            System.out.println("Time: " + (timeDifference * 0.001) + " seconds");
            System.out.print("\n");
        }
    }

    public void evolveRoute(){
        for (Map map : maps) {
            System.out.print("\n");
            for (int i = 0; i < map.getWidth(); i++) System.out.print("--");
            long time = System.currentTimeMillis();
            Route route = map.evolveRoute(4096);
            long timeDifference = System.currentTimeMillis() - time;
            Visualizer.printMap(route, 24, 24);
            for (int i = 0; i < map.getWidth(); i++) System.out.print("--");
            System.out.println("\nDistance " + route.getDistance());
            System.out.println("Time " + (timeDifference * 0.001) + " seconds");
            System.out.print("\n");
        }
    }

    public void compareMethods(){
        for (Map map : maps) {
            System.out.print("\n");
            for (int i = 0; i < map.getWidth(); i++) System.out.print("--");
            long time = System.currentTimeMillis();
            Route route = map.bruteForceRoute();
            long timeDifference = System.currentTimeMillis() - time;
            Visualizer.printMap(route, 24, 24);
            for (int i = 0; i < map.getWidth(); i++) System.out.print("--");

            time = System.currentTimeMillis();
            Route route1 = map.evolveRoute(4096);
            long timeDifference1 = System.currentTimeMillis() - time;
            Visualizer.printMap(route1, 24, 24);
            for (int i = 0; i < map.getWidth(); i++) System.out.print("--");
            System.out.print("\n");

            System.out.println("Brute forced distance: " + route.getDistance());
            System.out.println("Evolved distance:  " + route1.getDistance());
            System.out.println("Brute force time: " + (timeDifference * 0.001) + " seconds");
            System.out.println("Evolution time: " + (timeDifference1 * 0.001) + " seconds");

            if(timeDifference - timeDifference1 >= 0){
                System.out.println("The evolution method was " + ((timeDifference - timeDifference1) * 0.001) + " seconds faster");
            }else{
                System.out.println("The evolution method was " + ((timeDifference1 - timeDifference) * 0.001) + " seconds slower");
            }
            System.out.println("The distance was " + (route1.getDistance() - route.getDistance()) + " units shorter with the brute force method");
        }
    }
}
