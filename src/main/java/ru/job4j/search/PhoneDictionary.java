package ru.job4j.search;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
        for (Person search: persons) {
            Object key = new Object();
            if (search.contains(key)) {
                System.out.println("Объект найден");
            }
            System.out.println("Объект не найден");
        }
    }
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<Person>();
        return result;
    }
}
