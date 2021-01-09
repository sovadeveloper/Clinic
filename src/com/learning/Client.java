package com.learning;

import javafx.scene.AmbientLight;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String clientName;
    private Animal animal;

    public Client() {

    }

    public Client(String clientName) {
        this.clientName = clientName;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
