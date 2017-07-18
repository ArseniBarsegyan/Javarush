package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by arseniy.barsegyan on 18.07.2017.
 */
public class Archiver {
    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(String.valueOf(Operation.CREATE.ordinal()) + " - упаковать файлы в архив");
        ConsoleHelper.writeMessage(String.valueOf(Operation.ADD.ordinal()) + " - добавить файл в архив");
        ConsoleHelper.writeMessage(String.valueOf(Operation.REMOVE.ordinal()) + " - удалить файл из архива");
        ConsoleHelper.writeMessage(String.valueOf(Operation.EXTRACT.ordinal()) + " - распаковать архив");
        ConsoleHelper.writeMessage(String.valueOf(Operation.CONTENT.ordinal()) + " - просмотреть содержимое архива");
        ConsoleHelper.writeMessage(String.valueOf(Operation.EXIT.ordinal()) + " – выход");
        int number = ConsoleHelper.readInt();
        Operation operation = null;
        for (Operation op: Operation.values()) {
            if (op.ordinal() == number) {
                operation = op;
            }
        }
        return operation;
    }

    public static void main(String[] args) {
        Operation operation = null;
        while (true) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
                break;
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
                break;
            }
            if (operation == Operation.EXIT) {
                break;
            }
        }


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter full source file path");
            Path sourceFilePath = Paths.get(reader.readLine()).toAbsolutePath();
            ZipFileManager manager = new ZipFileManager(sourceFilePath);

            System.out.println("Enter output file path");
            manager.createZip(Paths.get(reader.readLine()).toAbsolutePath());

            ExitCommand exitCommand = new ExitCommand();
            exitCommand.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
