package ru.job4j.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(20, "Ivanov"),
                new Student(10, "Zaicev"),
                new Student(13, "Stepanov"),
                new Student(11, "Alekseev")
        );

        Map<String, Student> map = students.stream()
                .distinct()
                .collect(Collectors.toMap(Student::getSurname, e -> e));

        System.out.println(map.keySet().stream()
                            .map(key -> key + " = " + map.get(key))
                             .collect(Collectors.joining(", " + System.lineSeparator(), "{", "}")));
    }
}
