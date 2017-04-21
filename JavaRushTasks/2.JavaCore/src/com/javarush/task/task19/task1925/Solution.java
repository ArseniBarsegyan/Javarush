package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String fileContent = "";
        String forWriteString = "";
        while (reader.ready()) {
            fileContent = reader.readLine();
            String[] divided = fileContent.split(" ");
            for (int i = 0; i < divided.length; i++) {
                if (divided[i].length() > 6) {
                    forWriteString += divided[i] + ",";
                }
            }
        }
        forWriteString = forWriteString.substring(0, forWriteString.length() - 1);
        writer.write(forWriteString);

        reader.close();
        writer.close();
    }
}
