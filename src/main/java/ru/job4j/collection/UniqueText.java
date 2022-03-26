package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String orig: origin) {
            check.add(orig);
        }
        for (String test : text) {
            if (check.contains(test)) {
                rsl = true;
            } else {
                rsl = false;
                break;
            }
        }
        /* for-each origin -> new HashSet. */
        /* for-each text -> hashSet.contains */
        return rsl;
    }
}