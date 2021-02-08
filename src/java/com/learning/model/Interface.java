package com.learning.model;

import com.learning.*;

import java.util.Scanner;

public class Interface {
    private Clinic cl = new Clinic();
    private Scanner scn = new Scanner(System.in);

    public void start(){
        while (true){
            preview();
            String choice = scn.nextLine();
            switch (choice.toLowerCase()){
                case "add":
                    System.out.println("Введите имя клиента: ");
                    cl.addClient(scn.nextLine());
                    break;
                case "adda":
                    System.out.println("Введите имя питомца и болезнь: broke, temperature, poisoning, rabies, cystitis; После введите тип: cat, dog, rat, hamster");
                    addNewAnimal(scn.nextLine(), scn.nextLine());
                    break;
                case "delete":
                    System.out.println("Введите имя клиента, которого хотите удалить из списка");
                    cl.deleteClient(scn.nextLine());
                    break;
                case "deletep":
                    System.out.println("Введите имя питомца, котрого хотите удалить");
                    cl.deletePet(scn.nextLine());
                    break;
                case "conc":
                    System.out.println("Введите имя клиента, которому хотите добавить питомца и имя питомца");
                    cl.concatenate(scn.nextLine(), scn.nextLine());
                    break;
                case "output":
                    databaseOutput();
                    break;
                case "outputp":
                    petsOutput();
                    break;
                case "searchc":
                    System.out.println("Введите имя питомца, что-бы найти хозяина");
                    cl.searchClient(scn.nextLine());
                    break;
                case "searcha":
                    System.out.println("Введите имя хозяина, что-бы найти питомца");
                    System.out.println(cl.searchAnimal(scn.nextLine()));
                    break;
                case "renamec":
                    System.out.println("Введите имя клиента для редактирования");
                    cl.renameClient(scn.nextLine(), scn.nextLine());
                    break;
                case "renamea":
                    System.out.println("Введите имя питомца для редактирования");
                    cl.renameAnimal(scn.nextLine(), scn.nextLine());
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

    private void addNewAnimal(String animalName, String type){
        Animal animal = null;
        String choice = scn.nextLine();
        switch (choice.toLowerCase()){
            case "cat":
                animal = new Cat();
                fillDataAnimal(animalName, type, animal);
                break;
            case "dog":
                animal = new Dog();
                fillDataAnimal(animalName, type, animal);
                break;
            case "rat":
                animal = new Rat();
                fillDataAnimal(animalName, type, animal);
                break;
            case "hamster":
                animal = new Hamster();
                fillDataAnimal(animalName, type, animal);
                break;
        }
        cl.addNewAnimal(animal);
    }

    private void fillDataAnimal(String animalName, String type, Animal animal){
        animal.setDiseaseType(detectDisease(type));
        animal.setPetName(animalName);
    }

    private DiseaseType detectDisease(String type){
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

    private void petsOutput(){
        int i = 1;
        for(Animal item: cl.getPets()){
            System.out.println(i + ": " + item.getPetName() + " - " + item.getVoice() + "; Болезнь: " + item.getDiseaseType());
            i++;
        }
    }

    private void databaseOutput(){
        for (int i = 0; i < cl.getClients().size(); i++) {
            System.out.print((i + 1) + ": " + cl.getClients().get(i).getClientName() + " - ");
            for (int j = 0; j < cl.getClients().get(i).anim.size(); j++) {
                System.out.print(cl.getClients().get(i).anim.get(j).getPetName());
                if (cl.getClients().get(i).anim.size() - 1 != j) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

}
