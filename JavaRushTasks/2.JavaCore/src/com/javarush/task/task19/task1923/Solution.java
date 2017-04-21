package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader(args[0]));
        String fileContent = "";
        while (sc.hasNext()) {
            fileContent += sc.nextLine() + "\n";
        }
        System.out.println(fileContent);
        sc.close();
        String resultString = "";
        String[] splitted = fileContent.split(" ");

        for (int i = 0; i < splitted.length; i++) {
            if (hasPatternDigits(splitted[i])) {
                resultString += splitted[i] + " ";
            }
        }
        System.out.println(resultString);
        FileWriter writer = new FileWriter(args[1]);
        writer.write(resultString);
        writer.close();
    }

    private static Pattern patternLetters = Pattern.compile("[A-za-z]+");

    public static boolean hasPatternLetters(String string) {
        Matcher m = patternLetters.matcher(string);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    private static Pattern patternDigits = Pattern.compile("[0-9]+");

    public static boolean hasPatternDigits(String string) {
        Matcher m = patternDigits.matcher(string);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
