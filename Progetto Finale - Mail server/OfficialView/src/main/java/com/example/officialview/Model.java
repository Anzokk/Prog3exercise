package com.example.officialview;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Model {

    public void sendMail(String id, String mittente, String destinatario, String oggetto, String testo){

    }

    public ArrayList<Email> outputCasella(String nomeAccount){
        ArrayList<Email> casella=new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("/home/anzo/Prog3/Prog3exercise/Progetto Finale - Mail server/provaLettura.xml"));
            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            NodeList list = doc.getElementsByTagName("Email");
            for (int temp=0; temp<list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String ID = element.getAttribute("id");

                    if(ID.equals(nomeAccount)){
                        String mittenteTemp = element.getElementsByTagName("mittente").item(0).getTextContent();
                        String destTemp = element.getElementsByTagName("destinatario").item(0).getTextContent();
                        String oggettoTemp=element.getElementsByTagName("oggetto").item(0).getTextContent();
                        String testoTemp=element.getElementsByTagName("testo").item(0).getTextContent();
                        String timeTemp=element.getElementsByTagName("dataSpedizione").item(0).getTextContent();
                        Email emailTemp = new Email("0", mittenteTemp, destTemp, oggettoTemp, testoTemp, timeTemp);
                        casella.add(emailTemp);
                    }
                }
            }
        } catch (ParserConfigurationException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (SAXException ex) {
            throw new RuntimeException(ex);
        }
        return casella;
    }

    public void initialSetup(){
        Utente utente1 = new Utente ("Banana33", "Stinson", "Barney", "barney.stinson@email.com");
        Utente utente2 = new Utente ("Shooter", "Curry", "Stephen", "stephen.curry@email.com");
        Utente utente3 = new Utente ("DJDiesel", "O'neal", "Shaquille", "shaquille.oneal@email.com");

        Utente [] utenti = {utente1, utente2, utente3} ;

        //Qui facciamo la Scrittura nel file XML

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
            StreamResult streamResult = new StreamResult(new File("/home/anzo/Prog3/Prog3exercise/Progetto Finale - Mail server/provaScrittura.xml"));

            transformer.transform(domSource, streamResult);
            System.out.println("Hai costruito un minchia di fila, bravo picciotto");

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Hai sbagliato coglione");
        }
    }

    public ArrayList<HBox> boxCreation(String nomeAccount) {
        ArrayList<Email> fileMailbox= this.outputCasella(nomeAccount);
        ArrayList<HBox> finalGrid=new ArrayList<>();
        int cont = 0;

        do {
            HBox box = new HBox();
            box.setSpacing(20);
            box.setPrefHeight(50);
            box.setAlignment(Pos.CENTER);
            box.setPadding(new Insets(5, 5, 5, 5));
            box.setBorder(new Border(new BorderStroke(Paint.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


            Label labelMitt = new Label();
            labelMitt.setPrefWidth(150);

            Label labelDest = new Label();
            labelDest.setPrefWidth(150);

            Label labelOgg = new Label();
            labelOgg.setPrefWidth(125);
            labelOgg.setWrapText(true);

            Label labelTxt = new Label();
            labelTxt.setPrefWidth(160);
            labelTxt.setWrapText(true);


            box.getChildren().add(new Label(fileMailbox.get(cont).getID()));
            labelMitt.setText(fileMailbox.get(cont).getMittente());
            box.getChildren().add(labelMitt);
            labelDest.setText(fileMailbox.get(cont).getDestinatario());
            box.getChildren().add(labelDest);
            labelOgg.setText(fileMailbox.get(cont).getOggetto());
            box.getChildren().add(labelOgg);
            labelTxt.setText(fileMailbox.get(cont).getTesto());
            box.getChildren().add(labelTxt);
            box.getChildren().add(new Label(fileMailbox.get(cont).getDataSpedizione()));

            cont++;
            finalGrid.add(box);
        }while(cont< fileMailbox.size());
        return finalGrid;
    }




    public static void main(String[] args) {

        Model m = new Model();
        m.initialSetup();

        /*qua sotto facciamo la lettura del file XML
        *modificare in base a come formatteremo il file XML dello storico delle email
        *modificare anche la classe CasellaPostaElettronica e aggiungere i controlli sul metodo di lettura di XML
        *in modo tale che da aggiungere le email all'interno della lista da noi contenuta
        * vedere se dobbiamo mettere nello storico la lista delle email sia quando siamo mittenti che destinatari
         */

    }
}