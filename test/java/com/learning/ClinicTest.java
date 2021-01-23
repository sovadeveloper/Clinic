package com.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClinicTest {
    Clinic cl = new Clinic();
    String first = "First";
    String second = "Second";

    @Test
    void addClient() {
        Client client = new Client(first);
        Animal animal = new Animal(second);
        cl.clients.add(client);
        cl.pets.add(animal);
        Assertions.assertEquals(client, cl.clients.get(0));
        Assertions.assertEquals(animal, cl.pets.get(0));
    }

    @Test
    void deleteClient() {

    }
}