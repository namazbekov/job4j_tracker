package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private final ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine1 = (person) -> person.getName().contains(key);
        Predicate<Person> combine2 = (person) -> person.getSurname().contains(key);
        Predicate<Person> combine3 = (person) -> person.getAddress().contains(key);
        Predicate<Person> combine4 = (person) -> person.getPhone().contains(key);
        Predicate<Person> combine = combine1.or(person -> combine2.test(person)
                && combine3.test(person) && combine4.test(person));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person: persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
            return result;
    }
}
