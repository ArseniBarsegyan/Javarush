package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        Map<Integer, String> map = new TreeMap<>();
        String outputFileName = "";


        for (;;) {
            fileName = reader.readLine();
            if (fileName.equals("end")) {
                break;
            }
            int partNumber = Integer.parseInt(fileName.substring(fileName.lastIndexOf('t')+1,fileName.length()));
            outputFileName = fileName.substring(0, fileName.lastIndexOf('.'));
            map.put(partNumber, fileName);
        }

        FileInputStream inputStream = null;
        FileOutputStream outputStream = new FileOutputStream(outputFileName);
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            String value = pair.getValue();
            inputStream = new FileInputStream(value);
            System.out.println(value);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            outputStream.write(buffer);
        }
        outputStream.close();
        reader.close();
    }
}
