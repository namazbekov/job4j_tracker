package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Arrays.sort(atts, (left, right) -> left.getName().compareTo(right.getName()));
        Arrays.sort(atts, (left, right) -> right.getSize() - left.getSize());
        for ( Attachment att : atts) {
            System.out.println(att);
        }
    }
}