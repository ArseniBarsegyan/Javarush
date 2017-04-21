package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("D:\\1.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
          /*  User user = new User();
            user.setFirstName("Vasya");
            user.setLastName("Vasilyev");
            user.setCountry(User.Country.OTHER);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = simpleDateFormat.parse("23-08-2006");
            user.setBirthDate(date);
            user.setMale(true);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();*/

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            /*User user1 = loadedObject.users.get(0);
            System.out.println(user1.getFirstName() + " " + user1.getLastName() + " " + user1.getCountry().toString() + " " +
            user1.getBirthDate().toString() + " " + " " + user1.isMale());*/
            if (loadedObject.equals(javaRush)) System.out.println("yes"); else System.out.println("no");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isListNull = "";
            if (!users.isEmpty() || users.size() != 0) {
                printWriter.println(isListNull = "no");
                for (User u : users) {
                    printWriter.println(u.getFirstName());
                    printWriter.println(u.getLastName());
                    printWriter.println(u.getCountry());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String birthDay = dateFormat.format(u.getBirthDate());
                    printWriter.println(birthDay);
                    printWriter.println(u.isMale());
                }
            } else printWriter.println(isListNull = "yes");
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            User user;
            users = new ArrayList<>();
            if (reader.readLine().equals("yes")) {

            } else {
                while (reader.ready()) {
                    user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    String country = reader.readLine();
                    if (country.equals(User.Country.UKRAINE.toString())) user.setCountry(User.Country.UKRAINE);
                    else if (country.equals(User.Country.RUSSIA.toString())) user.setCountry(User.Country.RUSSIA);
                    else user.setCountry(User.Country.OTHER);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    user.setBirthDate(dateFormat.parse(reader.readLine()));
                    boolean isMale = Boolean.parseBoolean(reader.readLine());
                    user.setMale(isMale);
                    users.add(user);
                }
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
