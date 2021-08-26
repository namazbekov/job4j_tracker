package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if ((int) str1.charAt(i) != (int) str2.charAt(i)) {
                return Character.compare(str1.charAt(i), str2.charAt(i));
            }
        }
        return Integer.compare(str1.length(), str2.length());
    }
}