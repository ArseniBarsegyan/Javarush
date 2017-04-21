package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public int hashCode() {
            int hash1 = super.getName() == null ? 2 * super.getName().length() : 1;
            int sumLenOfBran = 0;
            for (String s : getBranches()) {
                sumLenOfBran += s.hashCode();
            }
            int hash2 = getBranches() == null ? sumLenOfBran : 0;
            return hash1 + hash2;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Plant)) return false;

            Tree tree = (Tree) obj;
            if (this.getName() == null) {
                if (tree.getName() != null)
                    return false;
            } else if (!this.getName().equals(tree.getName()))
                return false;

            if (this.getBranches() == null) {
                if (tree.getBranches() != null)
                    return false;
            } else if (!this.getBranches().equals(tree.getBranches()))
                return false;
            return true;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Tree tree = new Tree(this.getName(), this.getBranches());
            return tree;
        }
    }
}
