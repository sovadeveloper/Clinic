package com.learning.JDBC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseMainTest {

    @Test
    void setClientInDB() {
        DatabaseMain db = new DatabaseMain();
        db.setClientInDB("Вася");
    }

    @Test
    void setPetInDB() {
        DatabaseMain db = new DatabaseMain();
        db.setPetInDB("Бобик2", "Вася");
    }

    @Test
    void getClientId() {
        DatabaseMain db = new DatabaseMain();
        Assertions.assertEquals(2, db.getClientId("Женя"));
    }

    @Test
    void deleteClientFromDB() {
        DatabaseMain db = new DatabaseMain();
        db.deleteClientFromDB(1);
    }

    @Test
    void deletePetFromDB() {
        DatabaseMain db = new DatabaseMain();
        db.deletePetFromDB(2);
    }

    @Test
    void renameClientInDB() {
        DatabaseMain db = new DatabaseMain();
        db.renameClientInDB(9, "Гоша");
    }

    @Test
    void renamePetInDB() {
        DatabaseMain db = new DatabaseMain();
        db.renamePetInDB(3, "Туз");
    }

    @Test
    void dropBase() {
        DatabaseMain db = new DatabaseMain();
        db.dropBase();
    }
}




