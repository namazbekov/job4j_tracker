package ru.job4j.oop;

public class Profession {

    private String name;
    private String sureName;
    private String education;
    private String birthday;

    public String getName() {
        return name;
    }
    public String getSureName() {
        return sureName;
    }
    public  String getEducation() {
        return education;
    }
    public String getBirthday() {
        return birthday;
    }

    public class Engineer extends Profession {

    }

    public class Doctor extends Profession {

    }
}
