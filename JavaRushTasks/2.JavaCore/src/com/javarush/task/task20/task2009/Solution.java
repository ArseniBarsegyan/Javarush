package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Externalizable, Serializable{
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeChars(staticString);
            out.writeInt(i);
            out.writeInt(j);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            staticString = in.readUTF();
            i = in.readInt();
            j = in.readInt();
        }
    }

    public static void main(String[] args) {

    }
}
