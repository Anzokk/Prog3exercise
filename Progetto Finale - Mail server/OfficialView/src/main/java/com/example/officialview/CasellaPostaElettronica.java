package com.example.officialview;

import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CasellaPostaElettronica implements Callable<ArrayList<HBox>> {
    private String IDUtente;
    private List<Email> emailPersonali;


    /*si andrà a chiamare un metodo che leggera tutte le possibili email designate per quell'utente
    * creare metodi toString e altri metodi per gestire gli elemnti presenti nella lista
    */

    public CasellaPostaElettronica(String idUtente) {
        IDUtente = idUtente;
        this.emailPersonali = new ArrayList<>();
    }

    public String getIDUtente() {
        return IDUtente;
    }

    public void setIDUtente(String IDUtente) {
        this.IDUtente = IDUtente;
    }

    public List<Email> getEmailPersonali() {
        return emailPersonali;
    }

    public void setEmailPersonali(List<Email> emailPersonali) {
        this.emailPersonali = emailPersonali;
    }


    @Override
    public ArrayList<HBox> call(){
        Model m=new Model();
        return m.boxCreation(getIDUtente());
    }
}
