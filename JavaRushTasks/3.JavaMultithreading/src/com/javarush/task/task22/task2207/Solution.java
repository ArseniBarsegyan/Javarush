package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        StringBuilder builder = new StringBuilder();
        Pair pair;

        while (reader1.ready()) {
            builder.append(reader1.readLine() + " ");
        }

        String[] splitted = builder.toString().split(" ");
        for (int i = 0; i < splitted.length; i++) {
            String temp = splitted[i];
            for (int j = 1; j < splitted.length; j++) {
                builder = new StringBuilder(splitted[j]);
                String reversedString = builder.reverse().toString();
                if (reversedString.equals(temp)) {
                    pair = new Pair();
                    pair.first = temp;
                    pair.second = builder.toString();
                    result.add(pair);
                }
            }
        }

        System.out.println(builder.toString());
        for (Pair p : result) {
            System.out.println(p.toString());
        }
        reader.close();
        reader1.close();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
