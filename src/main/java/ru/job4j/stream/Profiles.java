package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .sorted(Comparator.comparing(Address::getCity)
                        .thenComparing(Address::getStreet)
                        .thenComparing(Address::getHome)
                        .thenComparing(Address::getApartment))
                .distinct()
                .collect(Collectors.toList());
    }
}
