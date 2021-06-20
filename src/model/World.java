package model;

import java.util.List;

public class World {
    private Game game;
    private Map map;
    private List<Pacman> pacmans;
    private List<Tickable> objects;

    public World(Game game) {
        this.game = game;
    }

    public World(Map map, List<Pacman> pacmans) {
        this.game = game;
        this.map = map;
        this.pacmans = pacmans;
    }

    public void update() {
        for (Pacman pacman : pacmans)
            pacman.onRoundBegin();
        for (Tickable object : objects)
            object.onRoundBegin();
        for (Pacman pacman : pacmans)
            pacman.onRoundEnd();
        for (Tickable object : objects)
            object.onRoundEnd();
    }

    public void addMapRender(Renderable map_renders) {
        this.game.addMapRender(map_renders);
    }

    public void addPacmanRender(List<Renderable> pacman_renders) {
        this.game.addRenderableRender(pacman_renders);
    }

    public void addObjectRender(List<Renderable> object_renders) {
        this.game.addObjectRender(object_renders);
    }
}