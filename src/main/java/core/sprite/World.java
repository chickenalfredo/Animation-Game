package core.sprite;

import java.util.ArrayList;

import core.external.entity.Hero;
import core.external.level.Chapter1Level1;
import core.map.GameMap;
import javafx.scene.canvas.GraphicsContext;

public class World {

    private ArrayList<Sprite> m_entities = new ArrayList<Sprite>();
    private Hero hero;
    private GameMap level;

    public World() {
        level = new Chapter1Level1();
        m_entities = level.getSprites();
        setHero();
    }

    public void createEntity() {}

    public void destroyEntity(Sprite actor) {
        level.removeSprite(actor);
    }

    public void addComponent() {}

    public void removeComponent() {}

    public void getComponent() {}

    public void addSystem() {}

    public void updateSystems() {}
    
    public void removeSystem() {}

    public Hero getHero() {
        return hero;
    }

    private void setHero() {
        for (Sprite s : m_entities) {
            if (s instanceof Hero) {
                hero = (Hero)s;
            }
        }
    }

    public ArrayList<Sprite> getEntities() {
        return m_entities;
    }

    public void update(GraphicsContext gc) {
        m_entities = level.getSprites();
        for (Sprite s : m_entities) {
            s.update(this, gc);
        }
    }

}
