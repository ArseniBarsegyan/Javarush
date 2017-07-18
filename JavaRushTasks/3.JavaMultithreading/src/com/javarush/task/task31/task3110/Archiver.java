package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by arseniy.barsegyan on 18.07.2017.
 */
public class Archiver {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter full source file path");
            Path sourceFilePath = Paths.get(reader.readLine()).toAbsolutePath();
            ZipFileManager manager = new ZipFileManager(sourceFilePath);

            System.out.println("Enter output file path");
            manager.createZip(Paths.get(reader.readLine()).toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
