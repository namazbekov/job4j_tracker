package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] regex1 = left.split("\\. ");
        String[] regex2 = right.split("\\. ");
        int i = Integer.parseInt(regex1[0]);
        int j = Integer.parseInt(regex2[0]);
        return Integer.compare(i, j);
    }
}