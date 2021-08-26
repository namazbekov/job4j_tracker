package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String left1 = null;
        String right1 = null;
        for (int i = 0; i < left.length() && i < right.length(); i++) {
            if (left.charAt(i) > 0 || right.charAt(i) > 0) {
                left1 = String.valueOf(left.charAt(i));
                right1 = String.valueOf(right.charAt(i));
            }
        }
        return left1.compareTo(right1);
    }
}