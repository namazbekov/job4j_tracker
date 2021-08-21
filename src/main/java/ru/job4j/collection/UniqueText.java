package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for(String orig : origin) {
            check.addAll(Collections.singleton(orig));
        }
        for (String tex : text) {
            if(!check.contains(tex)) {
                return false;
            }
        }
        return rsl;
    }
}