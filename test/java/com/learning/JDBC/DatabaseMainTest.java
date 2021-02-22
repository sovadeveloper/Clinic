package com.learning.JDBC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseMainTest {

    @Test
    void setClientInDB() throws ClassNotFoundException {
        DatabaseMain db = new DatabaseMain();
        db.setClientInDB("Вася");
    }

    @Test
    void setPetInDB() throws ClassNotFoundException {
        DatabaseMain db = new DatabaseMain();
        db.setPetInDB("Бобик2", "Вася");
    }



    @Test
    void getClientId() throws ClassNotFoundException {
        DatabaseMain db = new DatabaseMain();
        Assertions.assertEquals(2, db.getClientId("Женя"));
    }

    @Test
    void deleteClientFromDB() throws ClassNotFoundException {
        DatabaseMain db = new DatabaseMain();
        db.deleteClientFromDB(1);
    }

    @Test
    void deletePetFromDB() throws ClassNotFoundException {
        DatabaseMain db = new DatabaseMain();
        db.deletePetFromDB(2);
    }

    @Test
    void renameClientInDB() throws ClassNotFoundException {
        DatabaseMain db = new DatabaseMain();
        db.renameClientInDB(9, "Гоша");
    }

    @Test
    void renamePetInDB() throws ClassNotFoundException {
        DatabaseMain db = new DatabaseMain();
        db.renamePetInDB(3, "Туз");
    }

    @Test
    void dropBase() throws ClassNotFoundException {
        DatabaseMain db = new DatabaseMain();
        db.dropBase();
    }

    @Test
    void searchClientInDB() throws ClassNotFoundException {
        DatabaseMain db = new DatabaseMain();
        db.searchClientInDB(10);
    }

    @Test
    void searchPetInDB() throws ClassNotFoundException {
        DatabaseMain db = new DatabaseMain();
        db.searchPetInDB(8);
    }

    @Test
    void getAllClients() throws ClassNotFoundException {
        DatabaseMain db = new DatabaseMain();
        System.out.println(db.getAllClients());
    }
}




