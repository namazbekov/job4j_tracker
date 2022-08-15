package ru.job4j.tracker;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Item implements Comparable<Item> {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item(String name) {
        this.name = name;
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(LocalDateTime created) {
        this.created = created;
    }


    public LocalDateTime getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, created: %s", id, name, FORMATTER.format(created));
    }

    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.getName());
    }

    public static void main(String[] args) {
        List<Item> jobs = Arrays.asList(
                new Item(4, "Impl task"),
                new Item(2, "Fix bugs"),
                new Item(1, "Reboot server")
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
    }

}