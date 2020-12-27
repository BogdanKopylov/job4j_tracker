package ru.job4j.bank;

import java.util.Objects;

/**
 * В классе описывается тип данных 'User'.
 * @author Богдан Копылов
 * @version 1.0
 */
public class User {
    /**
     * Паспорт пользователя.
     */
    private String passport;
    /**
     * Ник пользователя.
     */
    private String username;

    /**
     * Конструктор для создания нового пользователя.
     * @param passport паспорт пользователя.
     * @param username ник пользователя.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Получить значение поля 'passport'.
     * @return паспорт пользователя.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Установить значение для поля 'passport'.
     * @param passport паспорт пользователя.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Получить значение поля 'username'.
     * @return ник пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Установить значение для поля 'username'.
     * @param username ник пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределяется метод equals.
     * Пользователи равны, если поле 'passport' совпадает.
     * @param o пользователь.
     * @return булево значение равнозначны ли пользователи.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределяется метод hashCode.
     * @return хэшкод по паспорту.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
