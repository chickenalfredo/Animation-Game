package core;

import core.sprite.*;
import core.map.*;
import core.external.entity.*;
import core.external.level.*;
import java.util.Scanner;
import java.util.List;

/**
 * Terminal output for Demo 1
 * 
 * @author Cloudy Yunfan
 * @since 2019/02/23 11:36
 */
public class GameTerminal {

    private static GameMap level1;

    /**
     * Print string to the terminal
     */
    public static boolean print() {
        List<Sprite> sprite = level1.getSprites();
        Scanner userInput = new Scanner(System.in);
        Hero player = new Hero(0.0, 0.0, 5.0, 5.0);

        for (Sprite each : sprite) {
            if (each instanceof Hero) {
                player = (Hero) each;
            }
        }


        System.out.println(getDisplay());
        printMessage();
        String key = userInput.nextLine();

        // if (input.isSimulationInput(key)) {
        //     if (input.simulateCollision(player, sprite)) {
        //         System.out.println("Collision detected");
        //     } else {
        //         System.out.println("No Collision");
        //         player.move(key);
        //     }
        // } else if (key.equalsIgnoreCase("e")) {
        //     System.exit(0);
        // } else if (key.equalsIgnoreCase("c")) {
        //     System.out.println("Checkpoint not yet implemented");
        // } else if (key.equalsIgnoreCase("r")) {
        //     System.out.println("Restart not yet implemented");
        // } else {
        //     System.out.println("Invalid Input");
        // }

        return true;
    }

    /**
     * 
     */
    public static void printTitle() {
        String str = "";
        str += "********************************\n";
        str += "********************************\n";
        str += "**       AnimationGame        **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**          Welcome           **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**       (Press Enter)        **\n";
        str += "**                            **\n";
        str += "********************************\n";
        str += "********************************\n";
        System.out.println(str);
        level1 = new Chapter1Level1();
    }

    /**
     * 
     */
    private static void printMessage() {
        StringBuilder str = new StringBuilder();
        str.append("\n----------------------------\n");
        str.append("w: move up\n");
        str.append("a: move left\n");
        str.append("s: move down\n");
        str.append("d: move right\n\n");
        str.append("e: close the game\n");
        str.append("\n----------------------------");
        str.append("\nEnter an action");
        System.out.println(str.toString());
    }

    /**
     * Get the display string
     * 
     * @return String - get terminal string to be print on the terminal
     */
    public static String getDisplay() {
        return level1.generateMapTerminal();
    }
    
}
