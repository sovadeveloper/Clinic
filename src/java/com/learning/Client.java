package com.learning;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String clientName;
    private Long clientID;
    public List<Animal> anim;

    public Client()   {

    }

    public Client(String clientName) {
        this.clientName = clientName;
        anim = new ArrayList<>();
    }

    public List<Animal> getAnim() {
        return anim;
    }

    public void setAnim(List<Animal> anim) {
        this.anim = anim;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
