package com.learning.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMain {
    List<ClientTable> clientRes = new ArrayList<>();
    List<PetTable> petRes = new ArrayList<>();
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String login = "postgres";
    String password = "developer2001";

    public void setClientInDB(String name) {
        String query = "insert into clientbase(name) VALUES ('" + name + "')";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {

            preStat.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPetInDB(String petName, String name) {
        String query = "insert into petsbase(clientid, petName) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            preStat.setInt(1, getClientId(name));
            preStat.setString(2, petName);

            preStat.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getClientId(String name) {
        String query = "SELECT clientid FROM clientbase WHERE name = ?";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            preStat.setString(1, name);
            ResultSet rs = preStat.executeQuery();
            if (rs.next()) {
                return rs.getInt("clientid");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void deleteClientFromDB(int clientid) {
        String query = "DELETE FROM petsbase WHERE clientid = ?; DELETE FROM clientbase WHERE clientid = ?";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            preStat.setInt(1, clientid);
            preStat.setInt(2, clientid);

            preStat.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePetFromDB(int petid) {
        String query = "DELETE FROM petsbase WHERE petid = ?;";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            preStat.setInt(1, petid);

            preStat.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renameClientInDB(int clientid, String name) {
        String query = "UPDATE clientbase SET name = ? WHERE clientid = ?";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            preStat.setString(1, name);
            preStat.setInt(2, clientid);

            preStat.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renamePetInDB(int petid, String petName) {
        String query = "UPDATE petsbase SET petName = ? WHERE petid = ?";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            preStat.setString(1, petName);
            preStat.setInt(2, petid);

            preStat.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropBase() {
        String query = "TRUNCATE clientbase CASCADE";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {

            preStat.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
