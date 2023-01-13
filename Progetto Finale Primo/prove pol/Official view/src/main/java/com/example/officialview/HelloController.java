package com.example.officialview;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label text;
    @FXML
    private Label obj;
    @FXML
    private Label receiver;
    @FXML
    private Label sender;
    @FXML
    private GridPane gridpanel;


    Model coso=new Model();
    ArrayList<Email> casella=new ArrayList<>();
    int cont=0,i=0;




    public void fillGridPanel(String nomeAccount){
        casella=coso.outputCasella(nomeAccount);
        System.out.println(casella.size());
        System.out.println(sender.getText());


        do{
            gridpanel.add(new Label(casella.get(cont).getID()), 0,i);
            gridpanel.add(new Label(casella.get(cont).getMittente()), 1,i);
            gridpanel.add(new Label(casella.get(cont).getDestinatario()), 2,i);
            gridpanel.add(new Label(casella.get(cont).getOggetto()), 3,i);
            gridpanel.add(new TextArea(casella.get(cont).getTesto()),4,i);
            gridpanel.add(new Label(casella.get(cont).getDataSpedizione()), 5,i);
            i++;
            cont++;
        }while(cont< casella.size());
    }

    

    
    @FXML
    public void sendMail(){
        /*Email mail = new Email("0", sender.getText(), receiver.getText(), obj.getText(), text.getText());*/

    }

    @FXML
    private void replyMail(){
        fillGridPanel("let0002");
    }

    @FXML
    private void deleteMail(){

    }

    @FXML
    private void forwardMail(){

    }

}