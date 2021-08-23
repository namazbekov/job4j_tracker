package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Item implements Comparable<Item> {
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
        this.name = name;
        this.id = id;
    }

    public void Item(LocalDateTime created) {
        this.created = created;
    }

    public void Item(String name) {
        this.name = name;
    }

    public void Item(int id, String name) {
        this.id = id;
        this.name = name;
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
        return "Item{" +
                "id=" + id +
                "," + "name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.getName());
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item(1,"own");
        Item item2 = new Item(4,"two");
        Item item3 = new Item(2,"three");
        Item item4 = new Item(3,"thor");
        items.add(item4);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Collections.sort(items);
        List<Item> item = new ArrayList<>();
        System.out.println(items);
    }
}