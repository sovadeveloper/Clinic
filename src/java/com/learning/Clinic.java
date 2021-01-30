package com.learning;

import java.util.*;

public class Clinic{
    Scanner scn = new Scanner(System.in);
    public List<Client> clients = new ArrayList<Client>();
    public List<Animal> pets = new ArrayList<Animal>();

    public void start(){
        while (true){
            preview();
            String choice = scn.nextLine();
            switch (choice.toLowerCase()){
                case "add":
                    System.out.println("Введите имя клиента: ");
                    addClient(scn.nextLine());
                    break;
                case "adda":
                    System.out.println("Введите имя питомца и болезнь: broke, temperature, poisoning, rabies, cystitis; После введите тип: cat, dog, rat, hamster");
                    addNewAnimal(scn.nextLine(), scn.nextLine());
                    break;
                case "delete":
                    System.out.println("Введите имя клиента, которого хотите удалить из списка");
                    deleteClient(scn.nextLine());
                    break;
                case "deletep":
                    System.out.println("Введите имя питомца, котрого хотите удалить");
                    deletePet(scn.nextLine());
                    break;
                case "conc":
                    System.out.println("Введите имя клиента, которому хотите добавить питомца и имя питомца");
                    concatenate(scn.nextLine(), scn.nextLine());
                    break;
                case "output":
                    databaseOutput();
                    break;
                case "outputp":
                    petsOutput();
                    break;
                case "searchc":
                    System.out.println("Введите имя питомца, что-бы найти хозяина");
                    searchClient(scn.nextLine());
                    break;
                case "searcha":
                    System.out.println("Введите имя хозяина, что-бы найти питомца");
                    searchAnimal(scn.nextLine());
                    break;
                case "renamec":
                    System.out.println("Введите имя клиента для редактирования");
                    renameClient(scn.nextLine(), scn.nextLine());
                    break;
                case "renamea":
                    System.out.println("Введите имя питомца для редактирования");
                    renameAnimal(scn.nextLine(), scn.nextLine());
                    break;
                case "exit":
                    return;
            }
        }
    }

    public void preview(){
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
    }

    public void addClient(String name){
        Client client = new Client(name);
        clients.add(client);
    }

    public DiseaseType detectDisease(String type){
        DiseaseType dis;
        switch (type){
            case "broke":
                dis = DiseaseType.BROKE;
                break;
            case "temperature":
                dis = DiseaseType.TEMPERATURE;
                break;
            case "poisoning":
                dis = DiseaseType.POISONING;
                break;
            case "rabies":
                dis = DiseaseType.RABIES;
                break;
            case "cystits":
                dis = DiseaseType.CYSTITIS;
                break;
            default:
                dis = null;
        }
        return dis;
    }

    public void addNewAnimal(String animalName, String type){
        Animal animal;
        String choice = scn.nextLine();
        switch (choice.toLowerCase()){
            case "cat":
                animal = new Cat(animalName);
                animal.setDiseaseType(detectDisease(type));
                pets.add(animal);
                break;
            case "dog":
                animal = new Dog(animalName);
                animal.setDiseaseType(detectDisease(type));
                pets.add(animal);
                break;
            case "rat":
                animal = new Rat(animalName);
                animal.setDiseaseType(detectDisease(type));
                pets.add(animal);
                break;
            case "hamster":
                animal = new Hamster(animalName);
                animal.setDiseaseType(detectDisease(type));
                pets.add(animal);
                break;
        }
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
            System.out.println(i + ": " + item.getPetName() + " - " + item.getVoice() + "; Болезнь: " + item.getDiseaseType());
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

}