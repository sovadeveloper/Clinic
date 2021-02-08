package com.learning;

import java.util.*;

public class Clinic{
    public List<Client> clients = new ArrayList<Client>();
    public List<Animal> pets = new ArrayList<Animal>();

    public void addClient(String name){
        Client client = new Client(name);
        clients.add(client);
    }

    public void addNewAnimal(Animal animal){
        pets.add(animal);
    }

    public void concatenate(String name, String animalName){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getClientName().equals(name)){
                for(int j = 0; j < pets.size(); j++){
                    if(pets.get(j).getPetName().equals(animalName)){
                        clients.get(i).anim.add(pets.get(j));
                        pets.get(j).setClient(clients.get(i));
                        return;
                    }
                }
            }
        }
    }

    public void deleteClient(String name){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getClientName().equals(name)){
                for(int j = 0; j < pets.size(); j++){
                    if(pets.get(j) == clients.get(i).getAnim().get(j)){
                        pets.remove(j);
                    }
                }
                clients.remove(i);
            }
        }
    }

    public void deletePet(String animalName){
        for(int i = 0; i < pets.size(); i++){
            if(pets.get(i).getPetName().equals(animalName)){
                pets.remove(i);
            }
        }
        for(int j = 0; j < clients.size(); j++){
            for(int k = 0; k < clients.get(k).anim.size(); k++){
                if(clients.get(j).anim.get(k).getPetName().equals(animalName)){
                    clients.get(j).anim.remove(k);
                }
            }
        }
    }

    public String searchAnimal(String name){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getClientName().equals(name)){
                for(int j = 0; j < clients.get(i).anim.size(); j++){
                    return clients.get(i).anim.get(j).getPetName();
                }
            }
        }
        return "";
    }

    public String searchClient(String namePet){
        for(int i = 0; i < pets.size(); i++){
            if(pets.get(i).getPetName().equals(namePet)){
                System.out.println(pets.get(i).getClient().getClientName());
                return pets.get(i).getClient().getClientName();
            }
        }
        return "";
    }

    public void renameClient(String name, String newName){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getClientName().equals(name)){
                clients.get(i).setClientName(newName);
            }
        }
    }

    public void renameAnimal(String namePet, String newNamePet){
        for(int i = 0; i < pets.size(); i++){
            if(pets.get(i).getPetName().equals(namePet)){
                pets.get(i).setPetName(newNamePet);
            }
        }
    }

    public List<Animal> getPets() {
        return pets;
    }

    public List<Client> getClients() {
        return clients;
    }
}