package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] regex1 = left.split("\\. ");
        String[] regex2 = right.split("\\. ");
        int i = Integer.parseInt(String.valueOf(regex1.length));
        int j = Integer.parseInt(String.valueOf(regex2.length));
        return Integer.compare(i,j);
    }
}