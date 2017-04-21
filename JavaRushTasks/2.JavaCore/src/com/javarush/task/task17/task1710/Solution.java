package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        try{
            if (args[0].equals("-c")) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date birthDay = format.parse(args[3]);
                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1], birthDay));
                } else if (args[2].equals("ж")) {
                    allPeople.add(Person.createFemale(args[1], birthDay));
                }
                System.out.println(allPeople.size()-1);
            } else if (args[0].equals("-u")) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date birthDay = format.parse(args[4]);
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);
                person.setBirthDay(birthDay);
                if (args[3].equals("м")) {
                    person.setSex(Sex.MALE);
                } else if (args[3].equals("ж")) {
                    person.setSex(Sex.FEMALE);
                }
                allPeople.set(Integer.parseInt(args[1]), person);
            } else if (args[0].equals("-d")) {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
                allPeople.set(Integer.parseInt(args[1]), person);
            } else if (args[0].equals("-i")) {
                String out = "";
                out += allPeople.get(Integer.parseInt(args[1])).getName() + " ";
                out += ((allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.MALE) ? "м" : "ж") + " ";
                out += new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(args[1])).getBirthDay());
                System.out.println(out);
            }
        } catch (Exception e) {}
    }
}
    /*Пример вывода для параметра -і:
        name sex (м/ж) bd (формат 15-Apr-1990)
        Миронов м 15-Apr-1990*/