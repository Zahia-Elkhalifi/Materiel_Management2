package com.ensa.gi4.modele;

public abstract class Materiel {
    private static int count = 0;
    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
