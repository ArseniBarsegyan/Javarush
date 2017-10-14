package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> classObject;

    public Generator(Class<T> classObject) {
        this.classObject = classObject;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return classObject.newInstance();
    }
}
