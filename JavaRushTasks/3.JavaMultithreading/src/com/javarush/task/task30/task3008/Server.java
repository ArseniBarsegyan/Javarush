package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by arseniy.barsegyan on 14.07.2017.
 */
public class Server {

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
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