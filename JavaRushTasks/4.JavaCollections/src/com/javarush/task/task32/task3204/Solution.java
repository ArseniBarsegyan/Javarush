package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        StringBuilder builder = new StringBuilder();
        ArrayList<String> collection = new ArrayList<>();
        collection.add("abcdefghijklmnopqrstuvwxyz");
        collection.add("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        collection.add("1234567890");

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < collection.size(); i++) {
                //get string (upperCase, lowerCase or number) from collection
                String element = collection.get(i);
                for (int j = 0; j < element.length(); j++) {
                    //generate random element in string and check, is StringBuilder contains this element?
                    int max = element.length();
                    int randomElement = (int)(Math.random() * max);
                    //if StringBuilder doesn't contains random element in string add this element
                    //to builder
                    if (!builder.toString().contains(String.valueOf(element.charAt(randomElement)))) {
                        builder.append(element.charAt(randomElement));
                        break;
                    }
                }
            }
        }
        String password = builder.toString().substring(0, builder.length() - 1);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        stream.write(password.getBytes());
        return stream;
    }
}