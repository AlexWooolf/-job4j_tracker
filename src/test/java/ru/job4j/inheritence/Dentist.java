package ru.job4j.inheritence;

public class Dentist extends Doctor {

    private boolean clinicus;

    public Dentist(String name, String surname, String education, String birthday, String univercity, boolean clinicus) {
        super(name, surname, education, birthday, univercity);
        this.clinicus = clinicus;
    }

    public String pullOutTooth() {
        String tooth = null;
        return tooth;
    }
}
