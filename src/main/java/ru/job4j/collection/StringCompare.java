package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        ArrayList<Character> leftArray = new ArrayList<>();
        ArrayList<Character> rightArray = new ArrayList<>();
        int rsl = 0;
        int size = Math.min(left.length(), right.length());
        for (int i = 0; i < size; i++) {
            leftArray.add(left.charAt(i));
        }
        for (int i = 0; i < size; i++) {
            rightArray.add(right.charAt(i));
        }
        for (int i = 0; i < size; i++) {
            if ((leftArray.get(i).compareTo(rightArray.get(i))) > 0) {
                rsl = 1;
            } else if ((leftArray.get(i).compareTo(rightArray.get(i))) < 0) {
                rsl = -1;
            }
        }
        if (rsl == 0) {
            if (left.length() == right.length()) {
                rsl = 0;
            } else {
                rsl = left.length() > right.length() ? 1 : -1;
            }
        }
        return rsl;
    }
}

