package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Замена чисел
*/

public class Solution {

    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner sc = new Scanner(new FileReader(fileName));
        String fileContent = "";
        while (sc.hasNext()) {
            fileContent += sc.nextLine();
        }

        //closing buffers
        reader.close();
        sc.close();

        //if number is between words change it
        String[] splitted = fileContent.split(" ");
        for (int i = 0; i < splitted.length; i++) {
            if (isValidNumber(splitted[i])) {
                int number = Integer.parseInt(splitted[i]);
                for (Map.Entry<Integer, String> pair : map.entrySet()) {
                    if (pair.getKey().equals(number))
                        splitted[i] = pair.getValue();
                }
            }
        }

        //join words again
        String forOutputString = "";
        for (int i = 0; i < splitted.length; i++) {
            forOutputString += splitted[i] + " ";
        }
        System.out.println(forOutputString);
    }

    //Check if number is in range
    public static boolean isValidNumber(String line) {
        if (isNumber(line)) {
            int number = Integer.parseInt(line);
            if (number >= 0 && number < 13) {
                return true;
            } else return false;
        }
        return false;
    }

    //Check if String is a number
    private static boolean isNumber(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
