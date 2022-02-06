package ru.job4j.inheritence;

public class Dentist extends Doctor {

    private boolean clinicus;

    public Dentist(String name, String surname, String education, String birthday, String univercity, boolean clinicus) {
        super();
        this.clinicus = clinicus;
    }
}
