package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public void Idem(LocalDateTime created) {
        this.created = created;
    }

    public void Idem(String name) {
        this.name = name ;
    }

    public void Idem(int id, String name) {
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
                ", name='" + name + '\'' +
                ", created=" + created +
                '}';
    }
}
