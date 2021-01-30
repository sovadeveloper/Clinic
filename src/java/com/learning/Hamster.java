package com.learning;

public class Hamster extends Animal{
    private String voice = "Хомяк";
    private DiseaseType diseaseType;

    public Hamster() {
    }

    public Hamster(String petName) {
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
