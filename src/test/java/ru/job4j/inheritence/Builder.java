package ru.job4j.inheritence;

public class Builder extends Engineer {

    private boolean tunnels;

    public Builder(String name, String surname, String education, String birthday, int grade, boolean tunnels) {
        super();
        this.tunnels = tunnels;
    }

    public Construction build(Plan plan) {
    }
}
