package core.screens;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

public class ScreenBuilder {

    private static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

    public static Stage defaultScreen(Stage primaryStage) {
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.setWidth(primaryScreenBounds.getWidth());
        primaryStage.setHeight(primaryScreenBounds.getHeight());
        primaryStage.setTitle("Agent Bunny");
        return primaryStage;
    }
    /**
     * @return the primaryScreenBounds
     */
    public static Rectangle2D getPrimaryScreenBounds() {
        return primaryScreenBounds;
    }

}
