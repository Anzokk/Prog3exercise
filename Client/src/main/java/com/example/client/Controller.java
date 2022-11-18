package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller {

    public Label welcomeText;
    public TextField input;
    public TextArea area;
    public Label resultText;
    private Model m;


    public void initModel(Model model){
        this.m=model;
    }

    @FXML
    protected void displayMailList() {
        area.setText(m.ritorna());
        welcomeText.setText("Lista:");
    }

    @FXML
    protected void selectMail(){
        try{
            area.setText(m.ritorna(Integer.parseInt(input.getText())));
        }catch(NumberFormatException err){
            resultText.setText("Inserisci un numero.");
        }
        welcomeText.setText("Mail selezionata:");
    }

    @FXML
    protected void removeMail() {
        try{
            m.rimuovi((Integer.parseInt(input.getText())));
            welcomeText.setText("Elemento rimosso");
            area.setText(m.ritorna());
        }catch(NumberFormatException err){
            resultText.setText("Inserisci un numero.");
        }
    }
}