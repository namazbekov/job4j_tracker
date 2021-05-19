package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup(225);
        student.setReceiptDate("28-03-2015");
        System.out.println("ФИО: " + student.getFullName());
        System.out.println("Группа: " + student.getGroup());
        System.out.println("Дата поступления: " + student.getReceiptDate() + "г");
    }
}
