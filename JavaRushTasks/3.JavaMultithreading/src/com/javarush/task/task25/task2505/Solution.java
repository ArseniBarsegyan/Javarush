package com.javarush.task.task25.task2505;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
Без дураков
*/
public class Solution {
    private static Logger log = Logger.getLogger(MyThread.class.getName());

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        myThread.interrupt();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
            String message;

            public MyUncaughtExceptionHandler() {

            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {

                }
                message = String.format("%s, %s, ", secretKey, Thread.currentThread().getName());
                System.out.println(message + " " + e.getMessage());
                log.log(Level.ALL, message + " " + e.getMessage());
            }
        }
    }
}

