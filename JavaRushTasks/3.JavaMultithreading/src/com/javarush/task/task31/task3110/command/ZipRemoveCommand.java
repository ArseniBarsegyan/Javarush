package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Paths;

/**
 * Created by arseniy.barsegyan on 18.07.2017.
 */
public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Укажите имя архива");
            String archName = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("Укажите имя файла");
            String fileName = ConsoleHelper.readString();
            ZipFileManager fileManager = new ZipFileManager(Paths.get(archName));
            fileManager.removeFile(Paths.get(fileName));
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Неверный путь для удаления.");
        }
    }
}
