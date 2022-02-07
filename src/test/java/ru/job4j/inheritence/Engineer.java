package ru.job4j.inheritence;

public class Engineer extends Profession {

    private int grade;

    public Engineer(String name, String surname, String education, String birthday, int grade) {
        super(name, surname, education, birthday);
        this.grade = grade;
    }

    public String plan() {
        String plan = null;
        return plan;
    }
}
