package com.javarush.task.task28.task2812;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
ShutdownNow!
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(() -> doExpensiveOperation(localId));
        }

        for (Object x : executor.shutdownNow()) {
            System.out.println(x + " was not completed");
        }
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
