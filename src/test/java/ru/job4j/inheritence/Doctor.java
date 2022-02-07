package ru.job4j.inheritence;

public class Doctor extends Profession {

    private String univercity;

    public Doctor(String name, String surname, String education, String birthday, String univercity) {
        super(name, surname, education, birthday);
        this.univercity = univercity;
    }

    public String heal() {
        String heal = null;
        return heal;
    }
}
