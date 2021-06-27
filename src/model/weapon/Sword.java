package model.weapon;

import model.Pacman;
import utils.Coordinate;
import utils.CoordinateUtils;
import utils.Direction;

public class Sword extends Weapon {
    private double range;
    private int damage;

    public Sword(Coordinate coord) {
        super(coord);
        this.range = getDefaultRange();
        this.damage = getDefaultDamage();
    }

    public Sword(Weapon weapon, Coordinate coord) {
        super(weapon, coord);
        this.range = getDefaultRange();
        this.damage = getDefaultDamage();
    }

    @Override
    public Weapon copy(Coordinate coord) {
        return new Sword(this, coord);
    }

    @Override
    public String getName() {
        return "sword";
    }

    @Override
    public void onAttackSuccess(Pacman target) {
        target.takeDamage(this.getDamage());
    }

    @Override
    public int getDefaultCoolDown() {
        return 60;
    }

    @Override
    public int getDefaultPreAttackCoolDown() {
        return 5;
    }

    @Override
    public int getDefaultPostAttackCoolDown() {
        return 5;
    }

    public double getDefaultRange() {
        return 1;
    }

    public double getRange() {
        return this.range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public int getDefaultDamage() {
        return 30;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public boolean inRange(Coordinate coord) {
        // The circle with radius 1 units by default.
        Coordinate center = this.owner.getCoordinate();
        // Coordinate facing = this.owner.getFacing().getCoord();
        Coordinate delta = CoordinateUtils.minus(coord, center);
        return CoordinateUtils.length(delta) <= this.getRange();
    }

    @Override
    public void calculateAnimate() {
        Direction facing = this.owner.getFacing();
        double originDegree = facing == Direction.RIGHT ? 0
                : facing == Direction.DOWN ? 90 : facing == Direction.LEFT ? 180 : 270;

        double progress = 0;

        if (this.getWeaponState() == WeaponState.preAttack) {
            progress = Math.min(this.preAttackCd.getPercent() * 3, 1);
        } else if (this.getWeaponState() == WeaponState.realAttack) {
            progress = 1;
        } else if (this.getWeaponState() == WeaponState.postAttack) {
            progress = Math.min((1 - this.postAttackCd.getPercent()) * 3, 1);
        }

        this.zoom = progress;

        double turning = this.animateCd.getPercent();

        this.degree = 450 * turning + originDegree + 45; // It looks better on turning 450 degrees.
        this.animateCoordinate = CoordinateUtils.fromPolar(this.range * progress, this.degree - 90);

        // System.out.printf("%f %f %f %s\n", progress, turning, this.degree,
        // CoordinateUtils.fromPolar(1, this.degree - 45));
    }
}
