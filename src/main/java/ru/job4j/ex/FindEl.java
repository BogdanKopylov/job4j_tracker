package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("В массиве не найдено совпадений с элементом key");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = new String[] {"a", "b", "c", "d"};
        try {
            FindEl.indexOf(value, "e");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
