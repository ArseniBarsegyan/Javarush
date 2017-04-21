package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String name = "";
        String birthDate = "";

        while (reader.ready()){
            String line = reader.readLine();
            String[] split = line.split(" ");

            for (int i = 0; i < split.length; i++){
                if (!isNumber(split[i])){
                    name += split[i] + " ";
                } else {
                    birthDate += split[i] + " ";
                }
            }
            name = name.trim();
            birthDate = birthDate.trim();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd M yyyy");
            Date date = simpleDateFormat.parse(birthDate);
            PEOPLE.add(new Person(name, date));
            name = "";
            birthDate = "";
        }

        for (Person p : PEOPLE){
            System.out.println(p.getName().toString() + " " + p.getBirthday().toString());
        }
        reader.close();
    }

    public static boolean isNumber(String s){
        try{
            int number = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }
}
