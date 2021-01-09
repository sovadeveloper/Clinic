package com.learning;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String petName;
    private Client client;

    public Animal(){

    }

    public Animal(String petName) {
        this.petName = petName;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
