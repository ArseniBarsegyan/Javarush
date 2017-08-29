package com.javarush.task.task22.task2213;

/**
 * Created by arseniy.barsegyan on 29.08.2017.
 */
public class Tetris {
    private Field field;
    private Figure figure;
    public static Tetris game;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        game = tetris;
        game.run();
    }

    public void run() {

    }

    public void step() {

    }
}
