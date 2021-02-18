package com.learning.JDBC;

public class ClientTable {
    private int clientID;
    private String name;

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClientTable{" +
                "clientID=" + clientID +
                ", name='" + name + '\'' +
                '}';
    }
}
