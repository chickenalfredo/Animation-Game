package core.sprite;

import core.sprite.interfaces.RangedType;

public class Ranged extends Weapon implements RangedType {

    public Ranged(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public void draw() {

    }

    @Override
    public void update() {

    }

    @Override
    public void collisionResolution(Sprite sprite) {

    }

    @Override
    public double damageEnemy(Entity enemy) {
        return 0;
    }

}
