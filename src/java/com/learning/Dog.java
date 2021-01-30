package com.learning;

public class Dog extends Animal{
    private String voice = "Собака";
    private DiseaseType diseaseType;

    public Dog() {
    }

    public Dog(String petName) {
        super(petName);
    }

    @Override
    public DiseaseType getDiseaseType() {
        return diseaseType;
    }

    @Override
    public void setDiseaseType(DiseaseType diseaseType) {
        this.diseaseType = diseaseType;
    }

    @Override
    public String getVoice() {
        return voice;
    }
}
