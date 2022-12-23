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

    @FXML
    protected void sendMail(){
        client.sendMail(client.createMail("prova", "prima prova mail"));
    }

    @FXML
    protected void startConnection(){
        System.out.println("insert port number (default is 7003): ");
        do{
            port = scanner.nextInt();
        }while(port<0 || port>9999);
            client.connection(7003);
    }

    protected void changeText(String text){
        area.setText(text);
    }
}