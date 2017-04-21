package com.javarush.task.task20.task2010;

import java.io.*;

/*
Как сериализовать что-то свое?
*/
public class Solution {
    public static class Object implements Serializable, Externalizable{
        public String string1;
        public String string2;

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(string1);
            out.writeObject(string2);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            string1 = (String)in.readObject();
            string2 = (String)in.readObject();
        }
    }

    public static int countStrings;

    public static class String implements Serializable, Externalizable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {

        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        }
    }

    public static void main(String[] args) {

    }
}
