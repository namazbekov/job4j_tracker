package ru.job4j.Profession;

public class Builder extends Engineer {
    private int build;

    public void toBuild (int house) {
        this.build = house;
    }
    public String name() {
        return super.getName();
    }

    public int getBuild() {
        return this.build;
    }
}
