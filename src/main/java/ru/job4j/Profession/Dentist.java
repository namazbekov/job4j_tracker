package ru.job4j.Profession;

public class Dentist extends Doctor {
    private String toothHeal;

    public void DiagnosisHeal(String patientName) {
        this.toothHeal = patientName;
    }
    public String name() {
        return super.getName();
    }

    public String getToothHeal() {
        return this.toothHeal;
    }

}
