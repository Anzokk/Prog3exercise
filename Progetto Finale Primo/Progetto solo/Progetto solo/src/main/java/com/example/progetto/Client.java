package com.example.progetto;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    Socket s = null;
    ObjectOutputStream out = null;
    private static int cont = 0;


    public void connection(int port) {
        System.out.println("Client inizio connessione");
        try {
            s = new Socket("127.0.0.1", port);
            out = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void sendMail(Mail mail) {
        try {
            out.writeObject(mail);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Mail createMail(String argomento, String text) {
        int id = cont, timestramp = 0;
        cont++;
        return new Mail(id, timestramp, argomento, text);
    }

    public Mail reply() {
        return null;
    }

    public void forward() {

    }


        public static void main(String[] args){
            Scanner scanner=new Scanner(System.in);
            String argomento, testo;
            Client c = new Client();
            c.connection(9876);
            argomento=scanner.next();
            testo=scanner.next();
            c.sendMail(c.createMail(argomento,testo));
            c.disconnect();
        }
    }