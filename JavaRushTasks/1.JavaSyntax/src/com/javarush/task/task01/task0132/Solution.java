package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        String sNumber = String.valueOf(number);
        int result = 0;

        for (int i = 0; i < sNumber.length(); i++) {
            result += Integer.parseInt(String.valueOf(sNumber.charAt(i)));
        }
        return result;
    }
}