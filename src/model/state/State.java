package model.state;

import model.Pacman;
import model.interfaces.Tickable;
import utils.Active;

public abstract class State implements Tickable, Active {
    public String name;
    protected Pacman target;
    private int turn = 1;

    public State(String name, Pacman target) {
        this.name = name;
        this.target = target;
    }

    public State(String name, Pacman target, int turn) {
        this.name = name;
        this.target = target;
        this.turn = turn;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void onTurnBegin() {
    }

    @Override
    public void onTurnEnd() {
        this.turn--;
    }

    @Override
    public void onRoundBegin() {
    }

    @Override
    public void onRoundEnd() {
    }

    public void onStateWillChange() {
    }

    @Override
    public boolean isActive() {
        return this.turn > 0;
    }

    public boolean needToRender() {
        return true;
    }
}
