package ru.job4j.tracker;

import javax.swing.*;
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
        List<Item> jobs = Arrays.asList(
                new Item(4,"Impl task"),
                new Item(2,"Fix bugs"),
                new Item(1,"Reboot server")
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
    }

}