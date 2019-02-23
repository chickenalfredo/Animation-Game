package core.sprite;

/**
 * The abstract Entity class extends Sprite with characteristics for creating
 * new generic entities that will be further defined by concrete subclasses.
 */
abstract public class Entity extends Sprite {

    private String name;
    private double gravity = 1;
    private int health;
    private boolean isEnemy;
    private boolean isColliding = false;

    // Is the entity performing an action right now?
    private boolean isInAction = false;

    // The direction the entity's facing. false = Left, true = Right
    private boolean direction;
    private double speed;

    /**
     * Constructor that calls the constructor of the Sprite class and sets name,
     * health, and speed for the Character
     * 
     * @param entityName   The name of the entity to set
     * @param entityHealth The health of the entity to set
     * @param entitySpeed  The speed of the entity to set
     * @param enemy     is the entity an enemy?
     * 
     * @see Sprite class
     * @param entityX      The x coordinate of the entity to set
     * @param entityY      The y coordinate of the entity to set
     * @param entityWidth  The width of the entity to set
     * @param entityHeight The height of the entity to set
     * @param entityImage  The terminal character representation of the entity
     */
    public Entity(String entityName, int entityHealth, double entitySpeed, boolean enemy, float entityX, float entityY,
            float entityWidth, float entityHeight, char entityImage) {
        super(entityX, entityY, entityWidth, entityHeight, entityImage);
        name = entityName;
        health = entityHealth;
        speed = entitySpeed;
        this.isEnemy = enemy;
    }

    /**
     * TODO
     */
    public void dead() {
    }

    /**
     * Returns a boolean to tell if the character's health has reached 0
     * 
     * @return boolean
     */
    public boolean isDead() {
        return (health <= 0);
    }

    /**
     * Returns the value of the entity's health
     * 
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the value of the entity's health
     * 
     * @param entityHealth The value of health to set.
     */
    public void setHealth(int entityHealth) {
        health = entityHealth;
    }

    /**
     * Returns the value of the entity's gravity
     * 
     * @return gravity
     */
    public double getGravity() {
        return gravity;
    }

    /**
     * Sets the value of the entity's gravity
     * 
     * @param entityGravity The value of gravity to set
     */
    public void setGravity(double entityGravity) {
        gravity = entityGravity;
    }

    /**
     * Returns the value of the entity's direction
     */

    public boolean getDirection() {
        return direction;
    }

    /**
     * Sets the value of the entity's direction
     * 
     * @param entityDirection The direction to set false = left true = right
     */
    public void setDirection(boolean entityDirection) {
        direction = entityDirection;
    }

    /**
     * Returns the value of the entity's speed
     * 
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the entity's speed
     * 
     * @param entitySpeed The value of speed to set
     */
    public void setSpeed(double entitySpeed) {
        speed = entitySpeed;
    }

    /**
     * Checks if the entity is already in an action then moves the character one
     * body length in the direction specified prior to the call
     * 
     * @see Sprite Class
     * @see Coordinate Class
     */

    public void MoveX() {
        if (isInAction == false && isColliding == false) {
            isInAction = true;
            // True = Right, False = Left
            if (direction) {
                setLocation(this.getX() + 2 * this.getWidth() * this.getSpeed(), this.getY());
            } else {
                setLocation(this.getX() - this.getWidth() * this.getSpeed(), this.getY());
            }
            isInAction = false;
        }
    }

    public void runY() {
        if (act)
    }

    /**
     * TO DO
     */
    public void collisionReisInAction(Sprite colliding) {
        isColliding = true;
        if (colliding.getClass().getSimpleName() == Tile) {

        }
        if isEnemy) {

        } else {
            if (colliding.getClass().getSimpleName() == Water) {
                this.setHealth(0);
            }
        }
    }

    }

    public void attack() {
    }
}