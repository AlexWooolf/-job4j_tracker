package ru.job4j.inheritence;

public class Programmer extends Engineer {

    private String lang;

    public Programmer(String name, String surname, String education, String birthday, int grade, String lang) {
        super(name, surname, education, birthday, grade);
        this.lang = lang;
    }

    public String code() {
        String code = null;
        return code;
    }
}
