package com.manegerbdcity;

import java.util.UUID;

public class City {

    private final String id;
    private final String name;

    public City(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
