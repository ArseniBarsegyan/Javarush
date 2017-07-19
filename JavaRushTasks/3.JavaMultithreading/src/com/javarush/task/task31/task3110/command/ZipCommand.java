package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by arseniy.barsegyan on 18.07.2017.
 */
public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь архива файла");
        String path = ConsoleHelper.readString();
        Path path1 = Paths.get(path);
        return new ZipFileManager(path1);
    }
}
