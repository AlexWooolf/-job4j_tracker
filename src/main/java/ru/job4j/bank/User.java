package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает поля, конструктор, геттеры и сеттеры,
 * переопределяет equals и hashCode для шаблона пользователя банковской системы
 * @author Vovk
 * @version 1.0
 */
public class User {
    /**
     * поля класса, сохраняют имя и паспортные данные
     */
    private String passport;
    private String username;

    /**
     * конструктор, принимающий поля
     * @param passport паспортные данные
     * @param username имя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * геттер паспортных данных
     * @return паспортные данные
     */
    public String getPassport() {
        return passport;
    }

    /**
     * сеттер паспортных данных
     * @param passport паспортные данные
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * геттер для имени
     * @return имя
     */
    public String getUsername() {
        return username;
    }

    /**
     * сеттер имени
     * @param username имя
     */
    public void setUsername(String username) {
        this.username = username;
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }
    /**
     * переопределение hashCode
     * @return hashCode
     */

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}