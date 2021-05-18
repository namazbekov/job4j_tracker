package ru.job4j.Profession;

public class Builder extends Engineer {
    private int build;

    public int getBuild() {
        return this.build;
    }

    @Override
    public String getBirthday() {
        return super.getBirthday();
    }
}
