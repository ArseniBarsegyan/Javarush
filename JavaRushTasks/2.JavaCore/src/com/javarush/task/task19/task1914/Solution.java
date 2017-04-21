package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String line = outputStream.toString();
        line = line.replace("\r\n","");
        ArrayList<String> list = new ArrayList<String>();

        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(line);
        while (m.find()){
            list.add(m.group());
        }
        int result = 0;

        if (line.contains("+")){
            result = Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(1));
        }

        if (line.contains("-")){
            result = Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(1));
        }

        if (line.contains("*")){
            result = Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(1));
        }


        System.setOut(consoleStream);
        System.out.println(line + String.valueOf(result));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

