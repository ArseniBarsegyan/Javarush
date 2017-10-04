package com.javarush.task.task25.task2515;

import java.util.ArrayList;

/**
 * Created by Administrator on 04.10.2017.
 */
public class Space {
    private int width;
    private int height;
    private SpaceShip ship;
    private ArrayList<Ufo> ufos;
    private ArrayList<Rocket> rockets;
    private ArrayList<Bomb> bombs;

    public Space(int width, int height){
        this.width = width;
        this.height = height;
        ufos = new ArrayList<>();
        rockets = new ArrayList<>();
        bombs = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public ArrayList<Ufo> getUfos() {
        return ufos;
    }

    public ArrayList<Rocket> getRockets() {
        return rockets;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public static void main(String[] args){

    }
}