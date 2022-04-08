package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapason {

    public static List<Double> diapason(int start, int finish, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (double i = start; i < finish; i++) {
            double rsl = func.apply(i);
            result.add(rsl);
        }
        return result;
    }
}

