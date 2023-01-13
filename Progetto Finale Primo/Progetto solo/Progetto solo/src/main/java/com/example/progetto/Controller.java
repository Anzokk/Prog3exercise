package com.example.progetto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.Scanner;

public class Controller {
    @FXML
    private TextArea area;
    private Client client;
    Scanner scanner = new Scanner(System.in);
    private int port=0;
    private String argomento, testo;

    @FXML
    protected void sendMail(){
        System.out.println("Argomento: ");
        argomento=scanner.next();
        System.out.println("testo: ");
        testo=scanner.next();
        client.sendMail(client.createMail(argomento, testo));
    }

    @FXML
    protected void startConnection(){
        client.connection(7003);
        changeText("connessione eseguita");
    }

    protected void changeText(String text){
        area.setText(text);
    }
}