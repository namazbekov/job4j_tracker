package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) !=  str2.charAt(i)) {
                return Character.compare(str1.charAt(i), str2.charAt(i));
            }
        }
        return Integer.compare(str1.length(), str2.length());
    }
}