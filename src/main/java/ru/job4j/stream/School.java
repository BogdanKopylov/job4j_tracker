package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    static Map<String, Student> collectToMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname,
                        student -> student,
                        (e1, e2) -> e1.getScore() > (e2.getScore()) ? e1 : e2));
    }
}