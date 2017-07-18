package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arseniy.barsegyan on 18.07.2017.
 */
public class CommandExecutor {
    private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<>();

    static {
        allKnownCommandsMap.put(Operation.ADD, new ZipAddCommand());
        allKnownCommandsMap.put(Operation.CONTENT, new ZipContentCommand());
        allKnownCommandsMap.put(Operation.CREATE, new ZipCreateCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
        allKnownCommandsMap.put(Operation.EXTRACT, new ZipExtractCommand());
        allKnownCommandsMap.put(Operation.REMOVE, new ZipRemoveCommand());
    }

    private CommandExecutor() {

    }

    public static void execute(Operation operation) throws Exception {
        for (Map.Entry<Operation, Command> pair : allKnownCommandsMap.entrySet()) {
            if (operation.equals(pair.getKey())) {
                Command command = pair.getValue();
                command.execute();
            }
        }
    }
}
