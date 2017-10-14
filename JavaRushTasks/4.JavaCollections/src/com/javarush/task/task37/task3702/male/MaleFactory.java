package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

public class MaleFactory {
    public Human getPerson(int age) {
        if (age > TeenBoy.MAX_AGE) {
            return new Man();
        } else if (age > KidBoy.MAX_AGE && age < 20) {
            return new TeenBoy();
        } else {
            return new KidBoy();
        }
    }
}