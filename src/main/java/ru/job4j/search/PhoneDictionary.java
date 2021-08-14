package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {

    private final ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<Person>();
        for(Person person: persons) {
            if (persons.contains(key)) {
                System.out.println("Объект найдне");
            } else {
                System.out.println("Объект не найден");
            }
        }
        return result;
    }
}
