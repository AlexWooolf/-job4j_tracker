package ru.job4j.bank;

import java.util.*;

/**
 * класс, описывающий логику банковского приложения.
 * @author Vovk
 * @version 1.0
 */
public class BankService {
    /**
     * поле содержит коллекцию со списком пользователей и аккаунтов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляет нового пользователя
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод добавляет аккаунт пользователю, пользователя находит по паспортным данным
     * @param passport паспортные данные
     * @param account аккаунт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * метод ищет пользователя по паспортным данным
     * @param passport паспортные данные
     * @return пользователь
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * метод осуществляет поиск аккаунта по паспортным данным и реквизитам
     * @param passport паспортные данные
     * @param requisite реквизиты
     * @return аккаунт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * метод осуществляет перевод средств между аккаунтами,аккаунты ищутся
     * по паспортным данным и реквизитам, выполняется проверка на наличие средств
     * @param srcPassport паспортные данные отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport паспортные данные получателя
     * @param destRequisite реквизиты получателя
     * @param amount сумма перевода
     * @return true в случае успешной операции или false в случае не найденных
     * входящих данных или недостатка средств
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (destAccount != null && srcAccount != null && (srcAccount.getBalance() >= amount)) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}