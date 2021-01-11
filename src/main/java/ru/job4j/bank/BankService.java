package ru.job4j.bank;

import java.util.*;

/**
 * В классе определены следующие методы:
 * - добавить пользователя;
 * - добавить аккаунт для пользователя;
 * - найти пользователя по паспорту;
 * - найти аккаунт по реквизитам;
 * - перевести деньги с одного счета на другой.
 * @author Богдан Копылов
 * @version 1.0
 */
public class BankService {
    /**
     * В карте типа HashMap ключем является пользователь,
     * значением по ключу является список аккаунтов пользователя.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в список ключей,
     * если такого пользователя еще нет в списке.
     * При добавлении нового пользователя в качестве значения для этого ключа
     * создается новый список типа ArrayList.
     * @param user пользователь, который может быть добавлен в список ключей.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый аккаунт для пользователя,
     * если пользователь найден по пасспорту и у него нет такого аккаунта.
     * @param passport паспорт пользователя.
     * @param account аккаунт, который необходио добавить.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту среди всех пользователей в списке ключей карты.
     * @param passport паспорт, по которому необходимо найти пользователя.
     * @return возвращает пользователя или null, если пользователь не найден.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод сначала ищет пользователя по паспорту.
     * Затем проверяет, есть ли в списке аккаунтов пользователя
     * аккаунт с переданными в метод реквизитами.
     * @param passport паспорт пользователя.
     * @param requisite реквизиты аккаунта пользователя.
     * @return аккаунт пользователя.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.map(value -> users.get(value).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst())
                .orElse(null);
    }

    /**
     * Метод позволяет перевести деньги с одного счета на другой.
     * @param srcPassport паспорт пользователя, который делает перевод.
     * @param srcRequisite реквизиты пользователя, который делает перевод.
     * @param destPassport паспорт пользователя, который получает перевод.
     * @param destRequisite реквизиты пользователя, который получает перевод.
     * @param amount сумма перевода.
     * @return возвращает булево значение "совершен ли перевод".
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            if (srcAccount.get().getBalance() >= amount) {
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
