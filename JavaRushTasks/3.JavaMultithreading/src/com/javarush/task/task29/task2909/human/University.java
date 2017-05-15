package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double value) {
        //TODO:
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() == value) {
                return students.get(i);
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student student = students.get(0);
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > student.getAverageGrade()) {
                student = students.get(i);
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        Student student = students.get(0);
        for (Student student1 : students) {
            if (student1.getAverageGrade() < student.getAverageGrade()) {
                student = student1;
            }
        }
        return student;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}