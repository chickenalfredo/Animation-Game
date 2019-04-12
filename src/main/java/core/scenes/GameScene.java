package core.scenes;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
<<<<<<< HEAD
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
=======
import javafx.scene.control.ProgressBar;
>>>>>>> 664c3ce79833f07b0f5667f26f37dd3d084950f9
import core.utils.InputHandler;
import java.io.File;
<<<<<<< HEAD
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import core.App;
=======
>>>>>>> 664c3ce79833f07b0f5667f26f37dd3d084950f9
import core.command.Command;
import core.screens.ScreenBuilder;
import core.sprite.World;

/**
 * 
 */
public class GameScene {

    private static StackPane root;
    private static HBox gameMenu;
    private static Scene GameScene;
    private static Canvas canvas;
    private static GraphicsContext gc;
    private static InputHandler inputHandler = new InputHandler();
    public static double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
    public static double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();
    private static World world;
    private static boolean animationTimer = false;

<<<<<<< HEAD
    /**
     * someComment
     * 
     * @return gh hjkhjkhjkhjkh
     * @see Component.class && Entity.class
     */
=======
>>>>>>> 664c3ce79833f07b0f5667f26f37dd3d084950f9
    public static Scene display(World aWorld) {
        world = aWorld;
        root = new StackPane();
        initScene();

        System.out.println(screenWidth + ": " + screenWidth * 0.031);
        System.out.println(screenHeight + ": " + screenHeight * 0.057);

        GameScene.setOnKeyPressed(new GameLoop());
        GameScene.setOnKeyReleased(new GameLoop());

        if (animationTimer == false) {
            new AnimationTimer() {
                public void handle(long time) {
<<<<<<< HEAD
                    if (world.getHero().getComponent(PositionComponent.class).getX() > (screenWidth / 2)
                            - world.getHero().getComponent(DimensionComponent.class).getWidth() / 2)
                        canvas.relocate(-world.getHero().getComponent(PositionComponent.class).getX()
                                + ((screenWidth - world.getHero().getComponent(DimensionComponent.class).getWidth())
                                        / 2),
                                0);
                    gc.clearRect(0, 0, 3 * screenWidth, screenHeight);
                    if (world.getHero().getComponent(HealthComponent.class).isAlive()) {
                        world.update(time);
                        world.render(gc, time);
                    } else {
                        App.getGameWindow().setScene(TitleScene.display());
                        animationTimer = false;
                        stop();
                    }
=======
                    if (world.getHero().getX() > (screenWidth / 2) - world.getHero().getWidth() / 2)
                        canvas.relocate(-world.getHero().getX() + ((screenWidth - world.getHero().getWidth()) / 2), 0);
                    gc.clearRect(0, 0, 3 * screenWidth, screenHeight);
                    world.update(gc, time);
>>>>>>> 664c3ce79833f07b0f5667f26f37dd3d084950f9
                }
            }.start();
        }
        animationTimer = true;
        return GameScene;
    }

    /**
     * 
     */
    public static class GameLoop implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            Command command = inputHandler.handleInput(event);
            if (command != null) {
                command.execute(world.getHero(), world);
            }
        }
    }

    public static void initScene() {
        Pane camera = new Pane();

        root.getChildren().add(camera);
        Image helpPane;
        try {
            helpPane = new Image(new FileInputStream("resources/assets/Instruction_Final.png"), screenWidth * 0.30,
            screenHeight * 0.30, false, true);
            ImageView imageview = new ImageView(helpPane);
            Group controlHelpPane = new Group(imageview);
            controlHelpPane.setTranslateX(-(screenWidth/2) + controlHelpPane.getBoundsInLocal().getWidth()/4);
            controlHelpPane.setTranslateY(-(screenHeight/2) + controlHelpPane.getBoundsInLocal().getHeight()/2);
            canvas = new Canvas(3 * screenWidth, screenHeight);
            camera.getChildren().add(canvas);
            root.getChildren().add(controlHelpPane);
            gc = canvas.getGraphicsContext2D();

            GameScene = new Scene(root);
            GameScene.getStylesheets().add((new File("resources/css/style.css")).toURI().toString());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

<<<<<<< HEAD
=======
        canvas = new Canvas(3 * screenWidth, screenHeight);
        camera.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        gc.strokeText("hi", 150, 100);

        // StackPane healthBar = new
        // StackPane(world.getHero().getComponent("HealthComponent",
        // HealthComponent.class).getHealthBar(),
        // world.getHero().getComponent("HealthComponent",
        // HealthComponent.class).getHealthDisplay());
        // healthBar.setAlignment(Pos.TOP_LEFT);
        // root.getChildren().add(healthBar);

        GameScene = new Scene(root);
        GameScene.getStylesheets().add((new File("resources/css/style.css")).toURI().toString());
>>>>>>> 664c3ce79833f07b0f5667f26f37dd3d084950f9
    }

    /**
     * 
     * @return
     */
    public static Scene getScene() {
        return GameScene;
    }

    /**
     * 
     * @return
     */
    public static Pane getRoot() {
        return root;
    }

    /**
     * 
     * @param toAdd
     */
    public static void addToRoot(Node toAdd) {
        gameMenu = (HBox) toAdd;
        root.getChildren().add(gameMenu);
        root.setAlignment(Pos.CENTER);
        gameMenu.setAlignment(Pos.CENTER);
    }

    /**
     * 
     */
    public static void removeGameMenu() {
        root.getChildren().remove(gameMenu);
    }

    /**
     * 
     * @return
     */
    public static HBox getGameMenu() {
        return gameMenu;
    }

    /**
     * @return the world
     */
    public static World getWorld() {
        return world;
    }
}