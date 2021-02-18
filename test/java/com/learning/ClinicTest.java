package com.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicTest {

    @Test
    void addClient() {
        Clinic cl = new Clinic();
        cl.addClient("name");
        Assertions.assertEquals("name", (cl.clients.get(cl.clients.size() - 1).getClientName()));
    }

    @Test
    void addNewAnimal() {
        Clinic cl = new Clinic();
        Animal animal = new Animal();
        cl.addNewAnimal(animal);
        Assertions.assertEquals(animal, cl.pets.get(cl.pets.size() - 1));
    }


}