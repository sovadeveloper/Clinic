package com.learning;

public class Animal {
    private String petName;
    private Client client;
    private String voice;
    private DiseaseType diseaseType;

    public Animal(){

    }

    public Animal(String petName) {
        this.petName = petName;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public DiseaseType getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(DiseaseType diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getVoice() {
        return voice;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
