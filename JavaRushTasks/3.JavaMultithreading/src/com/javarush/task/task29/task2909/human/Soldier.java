package com.javarush.task.task29.task2909.human;

/**
 * Created by arseniy.barsegyan on 15.05.2017.
 */
public class Soldier extends Human implements Alive {
    private int bloodGroup;

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void setBloodGroup(int code) {
        bloodGroup = code;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }

    public void live() {
        fight();
    }

    public void fight() {
    }
}
