package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class JobTest {
    @Test
    public void nameAscending() {
        List<Job> list = Arrays.asList(
                new Job("Bogdan", 44),
                new Job("Andrey", 33),
                new Job("Oleg", 88),
                new Job("Dima", 13)
        );
        Comparator<Job> comp = new JobAscByName();
        list.sort(comp);
        assertThat(list.get(2).getName(), is("Dima"));
    }

    @Test
    public void nameDescending() {
        List<Job> list = Arrays.asList(
                new Job("Bogdan", 44),
                new Job("Andrey", 33),
                new Job("Oleg", 88),
                new Job("Dima", 13)
        );
        Comparator<Job> comp = new JobDescByName();
        list.sort(comp);
        assertThat(list.get(2).getName(), is("Bogdan"));
    }

    @Test
    public void priorityAscending() {
        List<Job> list = Arrays.asList(
                new Job("Bogdan", 44),
                new Job("Andrey", 33),
                new Job("Oleg", 88),
                new Job("Dima", 13)
        );
        Comparator<Job> comp = new JobAscByPriority();
        list.sort(comp);
        assertThat(list.get(2).getPriority(), is(44));
    }

    @Test
    public void priorityDescending() {
        List<Job> list = Arrays.asList(
                new Job("Bogdan", 44),
                new Job("Andrey", 33),
                new Job("Oleg", 88),
                new Job("Dima", 13)
        );
        Comparator<Job> comp = new JobDescByPriority();
        list.sort(comp);
        assertThat(list.get(2).getPriority(), is(33));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        Comparator<Job> cmpPriorityName = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpPriorityName.compare(
                new Job("AAAD", 133),
                new Job("AAAC", 133)
        );
        assertThat(rsl, is(1));
    }
}