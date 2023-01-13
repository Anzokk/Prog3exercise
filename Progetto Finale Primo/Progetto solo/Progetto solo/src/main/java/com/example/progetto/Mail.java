package com.example.progetto;

public class Mail{
    int id, timestamp;
    String argomento, text;

    public Mail(int id, int timestamp, String argomento, String text) {
        this.argomento = argomento;
        this.text=text;
        this.id=id;
        this.timestamp=timestamp;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getArgomento() {
        return argomento;
    }

    public String getText() {
        return text;
    }
}
