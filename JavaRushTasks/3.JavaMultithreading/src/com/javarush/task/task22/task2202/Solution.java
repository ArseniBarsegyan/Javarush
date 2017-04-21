package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            int countSpaceIndex = 0;
            int fistSpaceIndex = 0;
            boolean firstFlag = true;
            int fifthSpaceIndex = 0;
            boolean fifthFlag = true;

            for (int i = 0; i < string.length(); i++) {

                if (string.charAt(i) == ' ') {
                    countSpaceIndex++;
                }

                if (countSpaceIndex == 1 && firstFlag) {
                    fistSpaceIndex = i;
                    firstFlag = false;
                }

                if (countSpaceIndex == 5 && fifthFlag) {
                    fifthSpaceIndex = i;
                    fifthFlag = false;
                }

                if (string.charAt(i) == '.' && countSpaceIndex == 4) {
                    fifthSpaceIndex = i;
                    fifthFlag = false;
                }
            }
            return string.substring(fistSpaceIndex + 1, fifthSpaceIndex);
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
