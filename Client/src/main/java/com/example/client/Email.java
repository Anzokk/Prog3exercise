package com.example.client;
import java.util.List;

public class Email {
    private int id;
    private int sender;
    private List<Integer> receivers;
    private String text;
    private String argomento;

    public Email(int id, String text, String argomento){
        this.id=id;
        this.text=text;
        this.argomento=argomento;
    }

    public int getId() {
        return id;
    }

    public int getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }
}
