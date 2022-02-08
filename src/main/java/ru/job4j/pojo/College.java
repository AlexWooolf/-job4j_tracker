package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student first = new Student();
        first.setName("vasya");
        first.setGroup("100500");
        first.setDateOfEntry("08.02.2022");
        System.out.println(first.getName() + " " + first.getGroup() + " " + first.getDateOfEntry());
    }
}
