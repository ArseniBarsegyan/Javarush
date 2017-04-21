package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arseniy.barsegyan on 05.04.2017.
 */
public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses = new ArrayList<>();

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main (String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());
        game.getHorses().add(new Horse("Lucky", 3, 0));
        game.getHorses().add(new Horse("Sleven", 3, 0));
        game.getHorses().add(new Horse("Homer", 3, 0));
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse h : horses) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (Horse h : horses) {
            if (h.getDistance() > winner.getDistance())
                winner = h;
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
