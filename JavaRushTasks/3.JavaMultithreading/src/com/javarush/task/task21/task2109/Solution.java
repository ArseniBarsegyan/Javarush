package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public int hashCode() {
            int res1 = super.getI() + super.getJ();
            int res2 = super.getName() == null ? 12 : 0;
            return res1 + res2;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof C)) return false;
            C c = (C) obj;

            if (this.getName() == null) {
                if (c.getName() != null)
                    return false;
            } else if (!this.getName().equals(c.getName()))
                return false;
            return true;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            A object = new C(getI(), getJ(), getName());
            return object;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        C c = new C(1,2,"superClass");
        C a = (C)c.clone();
        System.out.println(c.equals(a));
    }
}
