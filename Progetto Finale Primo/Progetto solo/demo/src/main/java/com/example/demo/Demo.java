package com.example.demo;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Demo {
    public static void main(String[] args) {
        Utente utente1 = new Utente ("Banana33", "Stinson", "Barney", "barney.stinson@email.com");
        Utente utente2 = new Utente ("Shooter", "Curry", "Stephen", "stephen.curry@email.com");
        Utente utente3 = new Utente ("DJDiesel", "O'neal", "Shaquille", "shaquille.oneal@email.com");
        Utente[] utenti={utente1, utente2, utente3};

        try{
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("ContactList");
            document.appendChild(root);



            for(int i=0; i<3; i++) {

                Element user = document.createElement("User");
                root.appendChild(user);

                Attr attr = document.createAttribute("nomeAccount");
                attr.setValue(utenti[i].getNomeAccount());
                user.setAttributeNode(attr);

                Element firstName = document.createElement("firstname");
                firstName.appendChild(document.createTextNode(utenti[i].getNome()));
                user.appendChild(firstName);

                Element lastName = document.createElement("lastname");
                lastName.appendChild(document.createTextNode(utenti[i].getCognome()));
                user.appendChild(lastName);

                Element email = document.createElement("email");
                email.appendChild(document.createTextNode(utenti[i].getEmail()));
                user.appendChild(email);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("/Users/anzo/Desktop/prova.xml"));

            transformer.transform(domSource, streamResult);
            System.out.println("Hai costruito un minchia di fila, bravo picciotto");

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Hai sbagliato coglione");
        }
    }
}