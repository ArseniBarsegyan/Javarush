package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        double median;
        Arrays.sort(array);

        if (array.length % 2 == 0) {
            median = ((double)array[array.length/2 - 1] + (double) array[array.length/2])/2;
        } else {
            median = array[array.length/2];
        }

        Arrays.sort(array, (o1, o2) -> {
            double value = Math.abs(o1 - median) - Math.abs(o2 - median);
            if (value == 0) {
                value = o1 - o2;
            }
            return (int) value;
        });

        return array;
    }
}
