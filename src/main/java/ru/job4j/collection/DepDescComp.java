package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int minimal = Math.min(o1.length(), o2.length());
        for (int index = 0; index < minimal; index++) {
            Character leftChar = o1.charAt(index);
            Character rightChar = o2.charAt(index);
            if (rightChar.compareTo(leftChar) != 0) {
                return leftChar.compareTo(rightChar);
            }
        }
        return o1.length() - o2.length();
    }
}