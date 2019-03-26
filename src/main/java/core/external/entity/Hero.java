package core.external.entity;

import core.ecs.components.PhysicsComponent;
import core.sprite.Entity;

/**
 * 
 */
public class Hero extends Entity {

    private int lives = 3;

    /**
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Hero(double x, double y, double width, double height) {
        super(x, y, width, height);
        setTerminalChar('H');
    }

    /**
     * 
     * @param player
     */
    public Hero(Hero player) {
        super(player.getX(), player.getY(), player.getWidth(), player.getHeight());
    }

    /**
     * 
     * @return
     */
    public int getLives() {
        return lives;
    }

    /**
     * 
     * @param oneUp
     */
    public void setLives(int oneUp) {
        lives += oneUp;
    }

    /**
     * 
     */
    public void jump() {
        getComponent("PhysicsComponent", PhysicsComponent.class).jump();
    }

}
