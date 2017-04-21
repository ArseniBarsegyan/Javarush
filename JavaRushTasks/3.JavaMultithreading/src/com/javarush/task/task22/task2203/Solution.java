package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            int tabCount = 0;
            boolean isFirstTime = true;
            boolean isSecondTime = true;
            int firstTabCount = 0;
            int secondTabCount = 0;

            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '\t') {
                    tabCount++;
                }

                if (tabCount == 1 && isFirstTime) {
                    isFirstTime = false;
                    firstTabCount = i;
                }

                if (tabCount == 2 && isSecondTime) {
                    isSecondTime = false;
                    secondTabCount = i;
                }
            }
            String resultString = string.substring(firstTabCount + 1, secondTabCount);
            return resultString;
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString("\tJavaRush"));
    }
}
