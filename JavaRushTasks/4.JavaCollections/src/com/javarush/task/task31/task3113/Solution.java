package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    public static int dirCount = 0;
    public static int fileCount = 0;
    public static long totalSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        if (!Files.isDirectory(Paths.get(path))) {
            System.out.println(path + " - не папка");
        } else {
            countRecurs(path);
        }
        if (dirCount > 0) {
            System.out.println("Всего папок - " + (dirCount - 1));
        } else {
            System.out.println("Всего папок - " + dirCount);
        }
        System.out.println("Всего файлов - " + fileCount);
        System.out.println("Общий размер - " + totalSize);
    }

    static void countRecurs(String fileName) {
        try {
            Files.walkFileTree(Paths.get(fileName), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    fileCount++;
                    totalSize += attrs.size();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    dirCount++;
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
