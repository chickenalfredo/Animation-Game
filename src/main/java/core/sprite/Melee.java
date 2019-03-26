package core.sprite;

import core.sprite.interfaces.MeleeType;

/**
 * 
 */
public abstract class Melee extends Weapon implements MeleeType {

    /**
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Melee(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    /**
     * 
     * @param enemy
     * @return
     */
    @Override
    public double damageEnemy(Entity enemy) {
        return 0;
    }

}
