package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        inputStream.close();
        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            String forSaveString = pair.getKey() + "=" + pair.getValue() + ";";
            outputStream.write(forSaveString.getBytes());
        }
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        byte[] array = new byte[inputStream.available()];
        inputStream.read(array);

        char [] chars = new char[array.length];
        String forLoadString = "";
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) array[i];
            forLoadString += chars[i];
        }

        String [] stringArray = forLoadString.split(";");
        for (int i = 0; i < stringArray.length; i++) {
            String [] divided = stringArray[i].split("=");
            properties.put(divided[0], divided[1]);
        }
        inputStream.close();
    }

    public static void main(String[] args) throws Exception {
        properties = new HashMap<>();
        properties.put("5","7");
        Solution solution = new Solution();
        solution.save(new FileOutputStream("D:\\1.txt"));
        solution.fillInPropertiesMap();
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
