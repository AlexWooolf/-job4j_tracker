package ru.job4j.poly;

public class Omnibus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ride");
    }
}
