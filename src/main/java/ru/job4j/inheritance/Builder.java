package ru.job4j.inheritance;

public class Builder extends Engineer {

    private boolean tunnels;

    public Builder(String name, String surname, String education, String birthday, int grade, boolean tunnels) {
        super(name, surname, education, birthday, grade);
        this.tunnels = tunnels;
    }

    public String build() {
        String build = null;
        return build;
    }
}
