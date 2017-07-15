package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by arseniy.barsegyan on 14.07.2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message answer = connection.receive();

            while (!answer.getType().equals(MessageType.USER_NAME) || answer.getData().isEmpty() || connectionMap.containsKey(answer.getData())) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                answer = connection.receive();
            }

            connectionMap.put(answer.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return answer.getData();
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                if (!pair.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;
            for (;;) {
                message = connection.receive();
                if (message.getType() == (MessageType.TEXT)) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, String.format("%s: %s", userName, message.getData())));
                } else {
                    ConsoleHelper.writeMessage("Error!");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection: connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка при отправке сообщения");
            }
        }
    }

    public static void main (String[] args) {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(ConsoleHelper.readInt());
            System.out.println("Сервер запущен");
            for (;;) {
                Socket socket1 = socket.accept();
                Handler handler = new Handler(socket1);
                handler.start();
            }
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
