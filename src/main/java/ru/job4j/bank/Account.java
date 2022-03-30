package ru.job4j.bank;

import java.util.Objects;
/**
 *Класс описывает поля, конструктор, геттеры и сеттеры,
 *  переопределяет equals и hashCode для шаблона аккаунта для банковской системы.
 * @author Vovk
 * @version 1.0
 */
public class Account {
    /**
     * Поля для хранения реквизитов и баланса
     */
    private String requisite;
    private double balance;
    /**
     * Конструктор принимает значение баланса и реквизитов
     * @param requisite реквизиты аккаунта
     * @param balance баланс аккаунта
     */

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }
    /**
     * геттер дял реквизитов
     * @return реквизиты аккаунта
     */

    public String getRequisite() {
        return requisite;
    }

    /**
     * сеттер для реквизитов
     * @param requisite реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * геттер баланса
     * @return баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * сеттер баланса
     * @param balance баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * переопределение equals
     * @param o для сравнения
     * @return результат сравнения
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
     * переопределение hashCode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}