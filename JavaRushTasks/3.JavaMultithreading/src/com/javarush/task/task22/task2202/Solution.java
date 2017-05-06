package com.javarush.task.task22.task2202;

import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        //System.out.println(getPartOfString("JavaRush-лучший сервис обучения Java."));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java который учит Java."));
        System.out.println(getPartOfString("JavaRush-лучшийсервис обучения Java который учит Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String resultString = "";
        String[] splitted = string.split(" ");
        if (splitted.length < 5) {
            throw new TooShortStringException();
        } else {
            int fifthSpaceCount = 0;
            int spaceCount = 0;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == ' ') {
                    spaceCount++;
                    if (spaceCount == 5) {
                        fifthSpaceCount = i;
                        resultString = string.substring(string.indexOf(" ") + 1, fifthSpaceCount);
                    }
                }
            }
            if (spaceCount < 5) {
                resultString = string.substring(string.indexOf(" ") + 1);
            }
        }
        return resultString;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
