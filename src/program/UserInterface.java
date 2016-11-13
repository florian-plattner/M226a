package program;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    Analytic analytic = new Analytic();

    public UserInterface(){
        scanner = new Scanner(System.in);
    }

    public void menu(){
        System.out.println("\n\n1: generate new map");
        System.out.println("2: brute force route");
        System.out.println("3: use evolution method to find Route");
        System.out.println("4: compare Methods");
        System.out.println("5: exit");

        boolean exit = false;

        if(scanner.hasNextInt()){
            int input = scanner.nextInt();
            System.out.print("\n");


            switch (input){
                case 1:
                    analytic.removeMaps();
                    generateMap();
                    break;
                case 2:
                    analytic.bruteForceRoute();
                    break;
                case 3:
                    analytic.evolveRoute();
                    break;
                case 4:
                    analytic.compareMethods();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("That's not an option, try again!");
            }
        }else{
            System.out.println("That's not an option, try again!");
            scanner.nextLine();
        }

        if(!exit){
            menu();
        }
    }

    public void generateMap(){
        System.out.println("Enter the number of points the map will contain:");
        if(scanner.hasNextInt()){
            int pointsCount = scanner.nextInt();
            analytic.addMap(pointsCount);
        }else{
            System.out.println("This is not a number, try again!");
            generateMap();
        }
    }
}
