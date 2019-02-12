package com.rps.core;

public class Player {

    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public Player() {
    }

    public Player(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
