package ru.job4j.oop;

public class Error {

    boolean active;

    int status;

    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void PrintInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error first = new Error(true, 2, "Pipetz");
        Error second = new Error(false, 0, "Ok");
        first.PrintInfo();
        second.PrintInfo();
    }
}

