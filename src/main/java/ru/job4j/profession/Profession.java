package ru.job4j.profession;

public class Profession {

    private String name;
    private String sureName;
    private String education;
    private String birthday;

    public void prof(String name, String sureName, String education, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.education = education;
        this.sureName = sureName;
    }

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
}
