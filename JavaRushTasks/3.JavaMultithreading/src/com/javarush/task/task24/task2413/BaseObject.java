package com.javarush.task.task24.task2413;

/**
 * Created by arseniy.barsegyan on 21.04.2017.
 */
public abstract class BaseObject {
    protected double x;
    protected double y;
    protected double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public abstract void draw(Canvas canvas);

    public abstract void move();

    boolean isIntersec(BaseObject o) {
        double distanceBetweenObjects = Math.sqrt((o.getX()-this.getX())*(o.getX()-this.getX()) +
                (o.getY() - this.getY())*(o.getY() - this.getY()));
        return distanceBetweenObjects <= Math.max(o.getRadius(), this.getRadius());
    }
}
