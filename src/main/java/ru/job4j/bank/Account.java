package ru.job4j.bank;

import java.util.Objects;

/**
 * В классе описывается тип данных 'Account'.
 * @author Богдан Копылов
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета.
     */
    private String requisite;
    /**
     * Баланс счета.
     */
    private double balance;

    /**
     * Конструктор для создания нового счета.
     * @param requisite реквизиты счета.
     * @param balance баланс счета.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Получить значение поля 'requisite'.
     * @return реквизиты счета.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Установить значение поля 'requisite'.
     * @param requisite реквизиты счета.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Получить значение поля 'balance'.
     * @return баланс счета.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Установить значение поля 'balance'.
     * @param balance баланс счета.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределяется метод equals.
     * Счета равны, если реквизиты счетов равны.
     * @param o аккаунт.
     * @return булево значение равны ли счета.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределяется метод hashCode.
     * @return хэшкод счета.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
