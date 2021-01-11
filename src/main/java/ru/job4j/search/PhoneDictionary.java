package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> forName = person -> person.getName().contains(key);
        Predicate<Person> forSurname = person -> person.getSurname().contains(key);
        Predicate<Person> forPhone = person -> person.getPhone().contains(key);
        Predicate<Person> forAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = forName.or(forSurname.or(forPhone.or(forAddress)));

//        Predicate<Person> combine = person -> person.getName().contains(key)
//                                                || person.getSurname().contains(key)
//                                                || person.getPhone().contains(key)
//                                                || person.getAddress().contains(key);

//             Predicate<Person> combine = person -> {
//            Predicate<String> predicate = str -> str.contains(key);
//            boolean forName = predicate.test(person.getName());
//            boolean forSurname = predicate.test(person.getSurname());
//            boolean forPhone = predicate.test(person.getPhone());
//            boolean forAddress = predicate.test(person.getAddress());
//            return forName || forSurname || forPhone || forAddress;
//             };

//             Predicate<Person> combine = person -> {
//            boolean forName = person.getName().contains(key);
//            boolean forSurname = person.getSurname().contains(key);
//            boolean forPhone = person.getPhone().contains(key);
//            boolean forAddress = person.getAddress().contains(key);
//            return forName || forSurname || forPhone || forAddress;
//             };

        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
