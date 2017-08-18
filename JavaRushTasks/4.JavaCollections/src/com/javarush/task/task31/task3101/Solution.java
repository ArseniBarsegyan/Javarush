package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
Проход по дереву файлов
*/
public class Solution {

    public static TreeSet<File> lessThan50Files = new TreeSet<>();
    public static void main(String[] args) {

        File directory = new File(args[0]);
        File resultFile = new File(args[1]);
        File allFilesContent = new File(resultFile.getParent() + "\\allFilesContent.txt");
        FileUtils.renameFile(resultFile, allFilesContent);

        try(FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)){
            deepSearch(directory);
            TreeMap<String, File> fileAndPath =  new TreeMap<>();
            for (File f : lessThan50Files) {
                fileAndPath.put(f.getName(), f);
            }
            for (Map.Entry<String, File> pair : fileAndPath.entrySet()) {
                BufferedReader reader = new BufferedReader(new FileReader(pair.getValue()));
                String s = "";
                while ((s = reader.readLine()) != null) {
                    fileOutputStream.write((s + "\n").getBytes());
                }
                reader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void deepSearch(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deepSearch(f);
            }
        } else if (file.isFile()) {
            if (file.length() > 50)
                FileUtils.deleteFile(file);
            else
                lessThan50Files.add(file);
        }
    }
}
