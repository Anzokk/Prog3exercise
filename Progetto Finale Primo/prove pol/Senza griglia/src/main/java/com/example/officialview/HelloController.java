package com.example.officialview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class HelloController implements ActionListener{
    @FXML
    private TextArea text;
    @FXML
    private TextField obj;
    @FXML
    private TextField receiver;
    @FXML
    private TextField sender;
    @FXML
    private Label id;
    @FXML
    private Label time;

    @FXML
    private VBox griglia;


    Model coso=new Model();
    ArrayList<Email> casella=new ArrayList<>();
    int cont=0,i=0;




    public void fillGridPanel(String nomeAccount){
        casella=coso.outputCasella(nomeAccount);
        System.out.println(casella.size());
        do{
            HBox box=new HBox();
            System.out.println(box.onMouseClickedProperty());
            box.getChildren().add(new TextField(casella.get(cont).getID()));
            box.getChildren().add(new TextField(casella.get(cont).getMittente()));
            box.getChildren().add(new TextField(casella.get(cont).getDestinatario()));
            box.getChildren().add(new TextField(casella.get(cont).getOggetto()));
            box.getChildren().add(new TextField(casella.get(cont).getTesto()));
            box.getChildren().add(new TextField(casella.get(cont).getDataSpedizione()));

            griglia.getChildren().add(box);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        sender.setText("aaaaaa");
    }
}