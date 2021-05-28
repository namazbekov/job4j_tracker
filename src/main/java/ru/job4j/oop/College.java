package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student stu = freshman;
        Object obj = freshman;
        Object Stu = new Student();
        Student stuFromObject = (Student) Stu;
    }
}
