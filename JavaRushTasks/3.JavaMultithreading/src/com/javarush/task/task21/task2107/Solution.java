package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);
            System.out.println(solution.equals(clone));

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;
        if (this.users == null) {
            if (solution.users != null)
                return false;
        } else if (!this.users.equals(solution.users))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (Map.Entry<String, User> pair : users.entrySet()) {
            result += pair.getValue().hashCode();
        }
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        solution.users = this.users;
        return solution;
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;

            User user = (User) o;

            if (age != user.age) return false;

            if (this.name == null) {
                if (user.name != null)
                    return false;
            } else if (!this.name.equals(user.name))
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = age;
            result += name == null ? name.length() : 1;
            result = 4 * result;
            return result;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            User user = new User(this.age, this.name);
            return user;
        }
    }
}
