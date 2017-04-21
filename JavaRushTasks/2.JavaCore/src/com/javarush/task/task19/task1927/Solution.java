package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String result = outputStream.toString();
        result = result.trim();

        System.setOut(consoleStream);

        String[] divided = result.split("\n");
        result = "";
        int count = 0;
        for (String s : divided) {
            count++;
            if (count == 3) {
                count = 1;
                result += "JavaRush - курсы Java онлайн" + "\n";
            }
            result += s + "\n";
        }
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
