package com.javarush.task.task30.task3008.client;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 16.07.2017.
 */
public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {

    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String botName = "date_bot_" + ((int)(Math.random()*100));
        return botName;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
