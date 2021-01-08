package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void addressList() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(new Address("Москва", "Профсоюзная", 4, 54)));
        profiles.add(new Profile(new Address("Харьков", "Героев Труда", 5, 333)));
        profiles.add(new Profile(new Address("Харьков", "Героев Труда", 5, 333)));
        profiles.add(new Profile(new Address("Москва", "Профсоюзная", 3, 54)));
        profiles.add(new Profile(new Address("Одесса", "Профсоюзная", 3, 54)));
        profiles.add(new Profile(new Address("Одесса", "Профсоюзная", 3, 54)));
        List<Address> expected = Arrays.asList(
                new Address("Москва", "Профсоюзная", 3, 54),
                new Address("Москва", "Профсоюзная", 4, 54),
                new Address("Одесса", "Профсоюзная", 3, 54),
                new Address("Харьков", "Героев Труда", 5, 333));
        assertThat(Profiles.collect(profiles), is(expected));
    }

}