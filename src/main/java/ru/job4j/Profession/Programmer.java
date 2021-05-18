package ru.job4j.Profession;

public class Programmer extends Engineer {
    private String toDoProg;

    public void tooDevelop(String programme) {
        this.toDoProg = programme;
    }
    public String name() {
        return super.getName();
    }

    public String getToDoProg() {
        return this.toDoProg;
    }
}
