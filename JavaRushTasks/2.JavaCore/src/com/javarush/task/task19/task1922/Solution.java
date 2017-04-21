package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        String fileString = "";
        while (reader1.ready()) {
            fileString = reader1.readLine();
            int count = 0;

            for (int i = 0; i < words.size(); i++) {
                String[] divided = fileString.split(" ");
                for (int j = 0; j < divided.length; j++) {
                    if (divided[j].equals(words.get(i)))
                        count++;
                }
            }
            if (count == 2) {
                System.out.println(fileString);
            }
        }
        reader1.close();
    }
}
