package com.learning.JDBC;

public class PetTable {
    private int petID;
    private String petName;
    private String name;

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PetTable{" +
                "petID=" + petID +
                ", petName='" + petName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
