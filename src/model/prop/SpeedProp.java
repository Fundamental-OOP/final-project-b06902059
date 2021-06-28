package model.prop;

import model.Pacman;
import utils.Coordinate;

public abstract class SpeedProp extends Prop {
    public SpeedProp(String name) {
        super(name);
    }

    public SpeedProp(String name, Coordinate coord) {
        super(name, coord);
    }

    public SpeedProp(Prop prop, Coordinate coord) {
        super(prop, coord);
    }

    @Override
    public void onPickUp(Pacman p) {
        super.onPickUp(p);
    }
}
