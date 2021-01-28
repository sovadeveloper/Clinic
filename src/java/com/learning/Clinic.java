package com.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clinic{
    Scanner scn = new Scanner(System.in);
    public List<Client> clients = new ArrayList<Client>();
    public List<Animal> pets = new ArrayList<Animal>();

    public void start(){
        boolean i = true;

        while (i){
            System.out.println("1: ADD - добавить клиента");
            System.out.println("2: ADDA - добавить питомца");
            System.out.println("3: DELETE - удалить клиента");
            System.out.println("4: DELETEP - удалить питомца");
            System.out.println("5: CONC - добавить нового питомца клиенту");
            System.out.println("6: OUTPUT - вывести всех клиентов");
            System.out.println("7: OUTPUTP - вывести всех клиентов");
            System.out.println("8: SEARCHC - поиск клиента по питомцу");
            System.out.println("9: SEARCHA - поиск питомца по клиенту");
            System.out.println("10: RENAMEC - редактирование клиента");
            System.out.println("11: RENAMEA - редактирование питомца");
            System.out.println("12: EXIT - выйти из программы");
            String choice = scn.nextLine();
            switch (choice.toLowerCase()){
                case "add":
                    System.out.println("Введите имя клиента: ");
                    addClient(scn.nextLine());
                    i = true;
                    break;
                case "adda":
                    System.out.println("Введите имя питомца");
                    addNewAnimal(scn.nextLine());
                    i = true;
                    break;
                case "delete":
                    System.out.println("Введите имя клиента, которого хотите удалить из списка");
                    deleteClient(scn.nextLine());
                    i = true;
                    break;
                case "deletep":
                    System.out.println("Введите имя питомца, котрого хотите удалить");
                    deletePet(scn.nextLine());
                    i = true;
                    break;
                case "conc":
                    System.out.println("Введите имя клиента, которому хотите добавить питомца и имя питомца");
                    concatenate(scn.nextLine(), scn.nextLine());
                    i = true;
                    break;
                case "output":
                    databaseOutput();
                    i = true;
                    break;
                case "outputp":
                    petsOutput();
                    i = true;
                    break;
                case "searchc":
                    System.out.println("Введите имя питомца, что-бы найти хозяина");
                    searchClient(scn.nextLine());
                    i = true;
                    break;
                case "searcha":
                    System.out.println("Введите имя хозяина, что-бы найти питомца");
                    searchAnimal(scn.nextLine());
                    i = true;
                    break;
                case "renamec":
                    System.out.println("Введите имя клиента для редактирования");
                    renameClient(scn.nextLine(), scn.nextLine());
                    i = true;
                    break;
                case "renamea":
                    System.out.println("Введите имя питомца для редактирования");
                    renameAnimal(scn.nextLine(), scn.nextLine());
                    i = true;
                    break;
                case "exit":
                    i = false;
                    break;
            }
        }
    }

    public void addClient(String name){
        Client client = new Client(name);
        clients.add(client);
    }

    public void addNewAnimal(String animalName){
        Animal animal = new Animal(animalName);
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

    public void databaseOutput() {
        for (int i = 0; i < clients.size(); i++) {
            System.out.print((i + 1) + ": " + clients.get(i).getClientName() + " - ");
            for (int j = 0; j < clients.get(i).anim.size(); j++) {
                System.out.print(clients.get(i).anim.get(j).getPetName());
                if (clients.get(i).anim.size() - 1 != j) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public void petsOutput(){
        int i = 1;
        for(Animal item: pets){
            System.out.println(i + ": " + item.getPetName());
            i++;
        }
    }

    private void searchAnimal(String name){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getClientName().equals(name)){
                for(int j = 0; j < clients.get(i).anim.size(); j++){
                    System.out.println(clients.get(i).anim.get(j).getPetName());
                }
            }
        }
    }

    public void searchClient(String namePet){
        for(int i = 0; i < pets.size(); i++){
            if(pets.get(i).getPetName().equals(namePet)){
                System.out.println(pets.get(i).getClient().getClientName());
            }
        }
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












    public List<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
}
