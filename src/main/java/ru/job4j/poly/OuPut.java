package ru.job4j.poly;

public class OuPut {
    public static void main(String[] args) {
        Vehicle plane = new Aircraft();
        Vehicle locomotive = new Train();
        Vehicle bus = new Omnibus();
        Vehicle[] vehicles = new Vehicle[]{plane, locomotive, bus};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
