package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = Person -> Person.getName().contains(key);
        Predicate<Person> predicateSurname = Person -> Person.getSurname().contains(key);
        Predicate<Person> predicatePhone = Person -> Person.getPhone().contains(key);
        Predicate<Person> predicateAdress = Person -> Person.getAddress().contains(key);
        var combine = predicateName.or(predicateSurname).
                or(predicatePhone).or(predicateAdress);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}