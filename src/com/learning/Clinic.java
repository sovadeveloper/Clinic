package com.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clinic{
    Scanner scn = new Scanner(System.in);
    private List<Client> clients = new ArrayList<Client>();
    private List<Animal> pets = new ArrayList<Animal>();

    public void start(){
        boolean i = true;

        while (i){
            System.out.println("1: ADD - добавить клиента");
            System.out.println("2: DELETE - удалить клиента");
            System.out.println("3: OUTPUT - вывести всех клиентов");
            System.out.println("4: OUTPUTPets - вывести всех клиентов");
            System.out.println("5: searchClient - поиск клиента по питомцу");
            System.out.println("6: searchAnimal - поиск питомца по клиенту");
            System.out.println("7: renameClient - редактирование клиента");
            System.out.println("8: renameAnimal - редактирование питомца");
            System.out.println("9: EXIT - выйти из программы");
            String choice = scn.nextLine();
            switch (choice.toLowerCase()){
                case "add":

                    System.out.println("Введите имя клиента: ");
                    String name = scn.nextLine();
                    System.out.println("Введите имя питомца: ");
                    String petName = scn.nextLine();
                    addClient(name, petName);
                    i = true;
                    break;
                case "delete":
                    System.out.println("Введите имя клиента, которого хотите удалить из списка");
                    deleteClient(scn.nextLine());
                    i = true;
                    break;
                case "output":
                    databaseOutput();
                    i = true;
                    break;
                case "outputpets":
                    petsOutput();
                    i = true;
                    break;
                case "searchclient":
                    System.out.println("Введите имя питомца, что-бы найти хозяина");
                    searchClient(scn.nextLine());
                    i = true;
                    break;
                case "searchanimal":
                    System.out.println("Введите имя хозяина, что-бы найти питомца");
                    searchAnimal(scn.nextLine());
                    i = true;
                    break;
                case "renameclient":
                    System.out.println("Введите имя клиента для редактирования");
                    renameClient(scn.nextLine(), scn.nextLine());
                    i = true;
                    break;
                case "renameanimal":
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

    private void addClient(String name, String petName){
        Client client = new Client(name);
        Animal animal = new Animal(petName);
        client.setAnimal(animal);
        animal.setClient(client);
        clients.add(client);
        pets.add(animal);
    }

    private void deleteClient(String name){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getClientName().equals(name)){
                for(int j = 0; j < pets.size(); j++){
                    if(pets.get(j) == clients.get(i).getAnimal()){
                        pets.remove(j);
                    }
                }
                clients.remove(i);
            }
        }
    }

    private void databaseOutput(){
        int i = 1;
        for(Client item : clients){
            System.out.println(i + ": " + item.getClientName() + " - " + item.getAnimal().getPetName());
            i++;
        }
    }

    private void petsOutput(){
        for(Animal item: pets){
            System.out.println(item.getPetName());
        }
    }

    private void searchAnimal(String name){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getClientName().equals(name)){
                System.out.println(clients.get(i).getAnimal().getPetName());
            }
        }
    }

    private void searchClient(String namePet){
        for(int i = 0; i < pets.size(); i++){
            if(pets.get(i).getPetName().equals(namePet)){
                System.out.println(pets.get(i).getClient().getClientName());
            }
        }
    }

    private void renameClient(String name, String newName){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getClientName().equals(name)){
                clients.get(i).setClientName(newName);
            }
        }
    }

    private void renameAnimal(String namePet, String newNamePet){
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
