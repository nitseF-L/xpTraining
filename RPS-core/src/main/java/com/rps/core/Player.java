package com.rps.core;

import java.util.Objects;

public class Player {

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public Player() {
    }

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName()) &&
                Objects.equals(getId(), player.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }
}
