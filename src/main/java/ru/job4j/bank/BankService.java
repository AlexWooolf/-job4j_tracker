package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
               rsl = user;
               break;
            }
        }
        return rsl;
    }

    /**
     * метод осуществляет поиск аккаунта по паспортным данным и реквизитам
     * @param passport паспортные данные
     * @param requisite реквизиты
     * @return аккаунт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account rsl = null;
            if (user != null) {
                for (Account account : users.get(user)) {
                    if (account.getRequisite().equals(requisite)) {
                        rsl = account;
                        break;
                    }
                }
            }
            return rsl;
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