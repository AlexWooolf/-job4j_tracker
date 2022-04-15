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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * метод ищет пользователя по паспортным данным
     * @param passport паспортные данные
     * @return пользователь
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * метод осуществляет поиск аккаунта по паспортным данным и реквизитам
     * @param passport паспортные данные
     * @param requisite реквизиты
     * @return аккаунт
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (destAccount.isPresent() && srcAccount.isPresent() && (srcAccount.get().getBalance() >= amount)) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}