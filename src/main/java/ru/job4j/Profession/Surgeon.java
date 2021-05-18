package ru.job4j.Profession;

public class Surgeon extends Doctor {
    private String patient;

    public void toSurge (String patient) {
        this.patient = patient;
    }
    public String name() {
        return super.getName();
    }
    public String getPatient () {
        return this.patient;
    }
}
