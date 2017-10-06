package com.javarush.task.task25.task2515;

/**
 * Created by Administrator on 04.10.2017.
 */
public class SpaceShip extends BaseObject {
    private double dx;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }

    public void moveLeft() {
        dx = -1;
    }

    public void moveRight() {
        dx = 1;
    }

    public void move() {
        x += dx;
        checkBorders(x, Space.game.getWidth(), 0,0);
    }

    public void draw(Canvas canvas) {
    }

    public void fire() {
        Rocket rocket1 = new Rocket(this.x - 2, this.y);
        Rocket rocket2 = new Rocket(this.x + 2,this.y);
        Space.game.getRockets().add(rocket1);
        Space.game.getRockets().add(rocket2);
    }
}
