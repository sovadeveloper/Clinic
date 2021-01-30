package com.learning;

public class Rat extends Animal{
    private String voice = "Крыса";
    private DiseaseType diseaseType;

    public Rat() {
    }

    public Rat(String petName) {
        super(petName);
    }

    public DiseaseType getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(DiseaseType diseaseType) {
        this.diseaseType = diseaseType;
    }

    @Override
    public String getVoice() {
        return voice;
    }
}
