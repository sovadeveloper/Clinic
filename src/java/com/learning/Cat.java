package com.learning;

public class Cat extends Animal {
    private String voice = "Кот";
    private DiseaseType diseaseType;

    public Cat() {
    }

    public Cat(String petName) {
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
