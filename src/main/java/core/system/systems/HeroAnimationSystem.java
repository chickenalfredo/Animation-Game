package core.system.systems;

import java.util.ArrayList;

import core.component.HeroAnimationComponent;
import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.state.State;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class HeroAnimationSystem extends SystemComponent {

    private ArrayList<Image> animateRunning;
    private ArrayList<Image> animateJump;
    private ArrayList<Image> animateIdle;
    private ArrayList<Image> animateFalling;
    private ArrayList<Image> animateRunAndShoot;
    private ArrayList<Image> animateIdleAndShoot;

    private int i = 0;
    private long lastAnimation = 0;

    public HeroAnimationSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(true);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(HeroAnimationComponent.class) != null) {
                addSystemEntity(e);
                animateRunning = e.getComponent(HeroAnimationComponent.class).animateRunning();
                animateJump = e.getComponent(HeroAnimationComponent.class).AnimateJump();
                animateIdle = e.getComponent(HeroAnimationComponent.class).animateIdle();
                animateFalling = e.getComponent(HeroAnimationComponent.class).animateFalling();
                animateRunAndShoot = e.getComponent(HeroAnimationComponent.class).animateRunAndShoot();
                animateIdleAndShoot = e.getComponent(HeroAnimationComponent.class).animateIdleAndShoot();
            }
        }
    }

    public void init(GraphicsContext gc) {
    }

    @Override
    public void update(long delta) {
    }

    @Override
    public void render(GraphicsContext gc, long time) {
        for (Entity e : getSystemEntities()) {
            if (e.getComponent(StateComponent.class).getState() == State.IDLE) {
                switch (e.getComponent(StateComponent.class).getConcurrentState()) {
                case ATTACKING:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateIdleAndShoot.get(iterate(animateIdleAndShoot)));
                    }

                    break;
                case JUMPING:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateJump.get(iterate(animateJump)));
                    }
                    break;
                case FALLING:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateFalling.get(iterate(animateFalling)));
                    }
                    break;
                case NONE:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateIdle.get(iterate(animateIdle)));
                    }
                    break;
                }
            } else {
                switch (e.getComponent(StateComponent.class).getConcurrentState()) {
                case ATTACKING:
                    if (animationTimerOver(60)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateRunAndShoot.get(iterate(animateRunAndShoot)));
                    }
                    break;
                case JUMPING:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateJump.get(iterate(animateJump)));
                    }
                    break;
                case FALLING:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateFalling.get(iterate(animateFalling)));
                    }
                    break;
                case NONE:
                    if (animationTimerOver(60)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateRunning.get(iterate(animateRunning)));
                    }
                    break;
                }
            }
            gc.drawImage(e.getComponent(HeroAnimationComponent.class).getCurrentRender(),
                    e.getComponent(PositionComponent.class).getX(), e.getComponent(PositionComponent.class).getY());
        }
    }

    private int iterate(ArrayList<Image> images) {
        if (i >= images.size() - 1) {
            i = 0;
            return i;
        } else {
            i++;
            return i;
        }
    }

    private boolean animationTimerOver(long duration) {
        long time = System.currentTimeMillis();
        if (time > lastAnimation + duration) {
            lastAnimation = time;
            return true;
        }
        return false;
    }

}
