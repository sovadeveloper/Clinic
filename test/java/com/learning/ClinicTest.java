package com.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicTest {
    Clinic cl = new Clinic();
    String first = "First";
    String second = "Second";
    String third = "Third";

    @Test
    void addClient() {
        cl.addClient(first, second);
        Assertions.assertEquals(cl.clients.get(cl.clients.size() - 1).getClientName(), first);
        Assertions.assertEquals(cl.pets.get(cl.pets.size() - 1).getPetName(), second);
    }

    @Test
    void deleteClient() {
        int startSizeClients = cl.clients.size();
        int startSizePets = cl.pets.size();
        cl.addClient(first, second);
        cl.deleteClient(first);
        Assertions.assertEquals(startSizeClients, cl.clients.size());
        Assertions.assertEquals(startSizePets, cl.pets.size());
    }

    @Test
    void renameClient() {
        cl.addClient(first, second);
        cl.renameClient(first, third);
        Assertions.assertEquals(third, cl.clients.get(cl.clients.size() - 1).getClientName());
    }

    @Test
    void renameAnimal() {
        cl.addClient(first, second);
        cl.renameAnimal(second, third);
        Assertions.assertEquals(third, cl.pets.get(cl.pets.size() - 1).getPetName());
    }
}