package core.external.entity;

import core.sprite.Entity;
import java.util.Scanner;
import java.lang.System;

public class Player extends Entity {

    int lives = 3;

    public Player(float x, float y, float width, float height, char playerImage, boolean enemy, String playerName,
            int playerHealth, double playerSpeed) {
        super(playerName, playerHealth, playerSpeed, enemy, x, y, width, height, playerImage);

    }

    public static void controlList() {

        System.out.println("\n----------------------------\n" + "w: move up\n" + "a: move left\n" + "s: move down\n"
                + "d: move right\n\n" + "exit: close the game\n" + "restart: return gamestate to startup position\n"
                + "cp: return to last checkpoint" + "\n----------------------------");

    }

    public void receiveInput() {
        controlList();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter an action");
        String in = userInput.nextLine();

        if (in.equalsIgnoreCase("w")) {
            // moveUp();
        }
        if (in.equalsIgnoreCase("a")) {
            setDirection(false);
            moveX();
            // moveLeft();
        }
        if (in.equalsIgnoreCase("s")) {
            // moveDown();
        }
        if (in.equalsIgnoreCase("d")) {
            setDirection(true);
            moveX();
            // moveRight();
        }
        if (in.equalsIgnoreCase("z")) {
            attack();
        }
        if (in.equalsIgnoreCase("exit")) {
            // Application.exit();
            return;
        }
        if (in.equalsIgnoreCase("restart")) {
            // Map(Map startup);
        }
        if (in.equalsIgnoreCase("cp")) {
            // Map(Map lastCP);
        }
        receiveInput();
    }

    public void attack() {

    }

}