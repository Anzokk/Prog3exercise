package com.example.progetto;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    Socket s=null;
    ObjectOutputStream out=null;

    public void connection(int port){
        System.out.println("Client inizio connessione");
        try {
            s=new Socket("127.0.0.1", port);
            out=new ObjectOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMail(Mail mail){
        try {
            out.writeObject(mail);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Mail createMail(String argomento, String text){
        int id=0, timestramp=0;
        Mail mail = new Mail(id, timestramp, argomento, text);
        return mail;
    }


}