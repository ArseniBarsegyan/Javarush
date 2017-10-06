package com.javarush.task.task25.task2515;

/**
 * Created by Administrator on 04.10.2017.
 */
public class Rocket extends BaseObject {
    public Rocket(double x, double y) {
        super(x, y, 1);
    }

    public void draw(Canvas canvas) {
        canvas.setPoint(x,y,'R');
    }

    public void move() {
        y--;
    }
}
