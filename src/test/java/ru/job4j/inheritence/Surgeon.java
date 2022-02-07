package ru.job4j.inheritence;

public class Surgeon extends Doctor {

    private boolean vet;

    public Surgeon(String name, String surname, String education, String birthday, String univercity, boolean vet) {
        super(name, surname, education, birthday, univercity);
        this.vet = vet;
    }

    public String surgery() {
        String surgery = null;
        return surgery;
    }
}
