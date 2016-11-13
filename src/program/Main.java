package program;

/**
 * Only contains the main method as the entry point to the program.
 *
 * @author Florian Plattner
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.generateMap();
        userInterface.menu();
    }
}
