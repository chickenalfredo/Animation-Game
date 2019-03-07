package core.external.entity;

import core.sprite.AbstractEnemy;
import core.sprite.Sprite;

public class Boss extends AbstractEnemy {

    public Boss(double x, double y, double width, double height) {
        super(x, y, width, height);
        setTerminalChar('B');
    }

    @Override
    public void dodge() {}

    @Override
    public void guard() {}

    @Override
    public void attack() {}

    @Override
    public void collisionResolution(Sprite sprite) {}

    @Override
    public void draw() {}

    @Override
    public void update() {}

}
