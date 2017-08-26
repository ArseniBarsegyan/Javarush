package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];
        byte[] buffer = new byte[text.length()];

        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            file.seek(number);
            file.read(buffer, 0, buffer.length);
            String line = convertByteToString(buffer);
            String appended = line.equals(text) ? "true" : "false";
            file.seek(file.length());
            file.write(appended.getBytes());
        }
    }

    static String convertByteToString(byte readBytes[]) {
        return new String(readBytes);
    }
}
