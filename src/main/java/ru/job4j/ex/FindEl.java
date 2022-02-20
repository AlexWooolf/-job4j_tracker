package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNoFoundExcepion {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(value[i], key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNoFoundExcepion("Элемент не найден");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"one", "three"};
        String input = "two";
        try {
            System.out.println(indexOf(value, input));
        } catch (ElementNoFoundExcepion e) {
            e.printStackTrace();
        }
    }
}