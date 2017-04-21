package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> fileContent = new ArrayList<>();
        TreeMap<String, Double> map = new TreeMap<>();
        ArrayList<Double> values = new ArrayList<>();

        while (reader.ready()) {
            String line = reader.readLine();
            if (!line.isEmpty()) {
                fileContent.add(line);
            }
        }

        for (int i = 0; i < fileContent.size(); i++) {
            String[] splitted = fileContent.get(i).split(" ");
            double value = Double.parseDouble(splitted[1]);

            if (map.containsKey(splitted[0])) {
                for (Map.Entry<String, Double> pair : map.entrySet()) {
                    String mapKey = pair.getKey();
                    Double mapValue = pair.getValue();
                    if (splitted[0].equals(mapKey)) {
                        mapValue += value;
                        pair.setValue(mapValue);
                    }
                }
            } else {
                map.put(splitted[0], value);
            }
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            values.add(pair.getValue());
        }

        double maxValue = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > maxValue) maxValue = values.get(i);
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue().equals(maxValue)) System.out.println(pair.getKey());
        }

        reader.close();
    }
}
