package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student("Surname1", 10));
        students.add(new Student("Surname2", 20));
        students.add(new Student("Surname3", 30));
        students.add(new Student("Surname4", 40));
        students.add(new Student("Surname5", 50));
        students.add(new Student("Surname6", 60));
        students.add(new Student("Surname7", 70));
        students.add(new Student("Surname8", 80));
        students.add(new Student("Surname9", 90));
    }

    @Test
    public void whenCollectClassA() {
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() >= 70 && student.getScore() <= 100;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student( "Surname7", 70));
        expected.add(new Student("Surname8", 80));
        expected.add(new Student("Surname9", 90));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() >= 50 && student.getScore() < 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Surname5", 50));
        expected.add(new Student("Surname6", 60));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() > 0 && student.getScore() < 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Surname1", 10));
        expected.add(new Student("Surname2", 20));
        expected.add(new Student("Surname3", 30));
        expected.add(new Student("Surname4", 40));
        assertThat(rsl, is(expected));
    }

    @Test
    public void collectToMap() {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 20),
                new Student("Zaicev", 10),
                new Student("Zaicev", 12),
                new Student("Stepanov", 13),
                new Student("Alekseev", 11)
        );
        Map<String, Student> map = new HashMap<>();
                map.put("Ivanov", new Student("Ivanov", 20));
                map.put("Zaicev", new Student("Zaicev", 12));
                map.put("Stepanov", new Student("Stepanov", 13));
                map.put("Alekseev", new Student("Alekseev", 11));
        assertThat(School.collectToMap(students), is(map));
    }
}