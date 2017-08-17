package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<String> fileTree = new ArrayList<>();
        File directory = new File(root);
        Stack<File> stack = new Stack<>();
        stack.push(directory);
        while (!stack.isEmpty()) {
            File child = stack.pop();
            if (child.isDirectory()) {
                for (File file : child.listFiles())
                    stack.push(file);
            } else if (child.isFile()) {
                fileTree.add(child.getPath());
            }
        }
        return fileTree;
    }

    public static void main(String[] args) {
        try {
            List<String> fileNames = getFileTree("D:\\1");
            for (String name : fileNames) {
                System.out.println(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
