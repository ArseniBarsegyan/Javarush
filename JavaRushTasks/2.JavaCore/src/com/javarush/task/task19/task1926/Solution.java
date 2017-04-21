package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import com.sun.javafx.collections.MappingChange;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Map<String, String> map = new HashMap<>();
        String fileContent = "";

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        while (reader1.ready()) {
            fileContent = reader1.readLine();
            StringBuilder builder = new StringBuilder(fileContent);
            builder.reverse().toString();
            System.out.println(builder);
        }
        reader1.close();
        reader.close();
    }
}
