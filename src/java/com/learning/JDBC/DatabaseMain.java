package com.learning.JDBC;

import com.learning.Animal;
import com.learning.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DatabaseMain {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String login = "postgres";
    String password = "developer2001";
    List<Client> clientsRS = new ArrayList<>();
    List<Animal> petsRS = new ArrayList<>();

    public void setClientInDB(String name) throws ClassNotFoundException {
        String query = "insert into clientbase(name) VALUES ('" + name + "')";
        Class.forName("org.postgresql.Driver");
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {

            preStat.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPetInDB(String petName, String name) throws ClassNotFoundException {
        String query = "insert into petsbase(clientid, petName) VALUES (?, ?)";
        Class.forName("org.postgresql.Driver");
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

    public int getClientId(String name) throws ClassNotFoundException {
        String query = "SELECT clientid FROM clientbase WHERE name = ?";
        Class.forName("org.postgresql.Driver");
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

    public void deleteClientFromDB(int clientid) throws ClassNotFoundException {
        String query = "DELETE FROM petsbase WHERE clientid = ?; DELETE FROM clientbase WHERE clientid = ?";
        Class.forName("org.postgresql.Driver");
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

    public void deletePetFromDB(int petid) throws ClassNotFoundException {
        String query = "DELETE FROM petsbase WHERE petid = ?;";
        Class.forName("org.postgresql.Driver");
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

    public void renameClientInDB(int clientid, String name) throws ClassNotFoundException {
        String query = "UPDATE clientbase SET name = ? WHERE clientid = ?";
        Class.forName("org.postgresql.Driver");
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

    public void renamePetInDB(int petid, String petName) throws ClassNotFoundException {
        String query = "UPDATE petsbase SET petName = ? WHERE petid = ?";
        Class.forName("org.postgresql.Driver");
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

    public void searchClientInDB(int clientid) throws ClassNotFoundException {
        String query = "SELECT * FROM clientbase WHERE clientid = ?";
        Class.forName("org.postgresql.Driver");
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            preStat.setInt(1, clientid);
            ResultSet rs = preStat.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                int clientID = rs.getInt("clientid");

                Client obj = new Client();
                obj.setClientID(clientID);
                obj.setClientName(name);
                clientsRS.add(obj);
            }
            clientsRS.forEach(x -> System.out.println(x));
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchPetInDB(int petid) throws ClassNotFoundException {
        String query = "SELECT * FROM petsbase WHERE petid = ?";
        Class.forName("org.postgresql.Driver");
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            preStat.setInt(1, petid);
            ResultSet rs = preStat.executeQuery();
            while(rs.next()) {
                int petID = rs.getInt("petid");
                int clientID = rs.getInt("clientid");
                String petName = rs.getString("petname");

                Animal obj = new Animal();
                obj.setPetId(petID);
                obj.setClientId(clientID);
                obj.setPetName(petName);
                petsRS.add(obj);
            }
            petsRS.forEach(x -> System.out.println(x));
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropBase() throws ClassNotFoundException {
        String query = "TRUNCATE clientbase CASCADE";
        Class.forName("org.postgresql.Driver");
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {

            preStat.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<Client> getAllClients() throws ClassNotFoundException {
        String query = "SELECT * FROM clientbase";
        Class.forName("org.postgresql.Driver");
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            Set<Client> arr = new HashSet<>();
            ResultSet rs = preStat.executeQuery();

            while (rs.next()){
                arr.add(new Client(rs.getString("name"), rs.getInt("clientid")));
            }

            return arr;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}