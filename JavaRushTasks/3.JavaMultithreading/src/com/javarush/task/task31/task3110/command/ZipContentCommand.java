package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.FileProperties;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.util.List;

/**
 * Created by arseniy.barsegyan on 18.07.2017.
 */
public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");

        ZipFileManager manager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");

        List<FileProperties> propertiesList = manager.getFilesList();
        for (FileProperties prop : propertiesList) {
            ConsoleHelper.writeMessage(prop.toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
