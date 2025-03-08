package org.example.dto;

public class Airline {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airline(String name) {
        this.name = name;
    }

    private String name;
}
