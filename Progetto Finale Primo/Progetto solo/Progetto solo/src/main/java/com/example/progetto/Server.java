package com.example.progetto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{
    private final int port=9876;
    private static ServerSocket server;

    public void enableConnection(){
        try {
            server=new ServerSocket(port);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Mail> mailbox = new ArrayList<>();
        boolean t=true;

        while(t){
            Server s=new Server();
            s.enableConnection();
            System.out.println("Server waiting for clients");
            Socket socket = server.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Mail m=(Mail)in.readObject();
            mailbox.add(m);
            System.out.println("message received: "+m.text);
            in.close();
            socket.close();
            if(m.text=="exit"){
                t=false;
            }
        }
        System.out.println("shutting down");
        server.close();
    }
}
