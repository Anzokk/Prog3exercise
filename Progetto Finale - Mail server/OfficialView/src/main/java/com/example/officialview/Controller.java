package com.example.officialview;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Controller implements MouseListener {
    @FXML
    private TextArea text = new TextArea();
    @FXML
    private TextField obj = new TextField();
    @FXML
    private TextField receiver = new TextField();
    @FXML
    private TextField sender = new TextField();
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
            box.setSpacing(20);
            box.setPrefHeight(50);
            box.setAlignment(Pos.CENTER);
            box.setPadding(new Insets(5,5,5,5));
            box.setBorder(new Border(new BorderStroke(Paint.valueOf("#9E9E9E"),
             BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            box.setBackground(new Background(new BackgroundFill(Paint.valueOf("#F5F5F5"),
             CornerRadii.EMPTY,Insets.EMPTY)));


            Label labelMitt=new Label();
            labelMitt.setPrefWidth(150);

            Label labelDest=new Label();
            labelDest.setPrefWidth(150);

            Label labelOgg=new Label();
            labelOgg.setPrefWidth(125);
            labelOgg.setWrapText(true);

            Label labelTxt=new Label();
            labelTxt.setPrefWidth(160);
            labelTxt.setWrapText(true);




            box.getChildren().add(new Label(casella.get(cont).getID()));
            labelMitt.setText(casella.get(cont).getMittente());
            box.getChildren().add(labelMitt);
            labelDest.setText(casella.get(cont).getDestinatario());
            box.getChildren().add(labelDest);
            labelOgg.setText(casella.get(cont).getOggetto());
            box.getChildren().add(labelOgg);
            labelTxt.setText(casella.get(cont).getTesto());
            box.getChildren().add(labelTxt);
            /*box.getChildren().add(new Label(casella.get(cont).getOggetto()));
            box.getChildren().add(new Label(casella.get(cont).getTesto()));*/
            box.getChildren().add(new Label(casella.get(cont).getDataSpedizione()));



            griglia.getChildren().add(box);

            box.setOnMouseClicked( ( e ) ->
            {


                ArrayList<String> aaa=new ArrayList<>();
                Node p;

                for(int m=0; m<box.getChildren().size();m++){
                    String newString = box.getChildren().get(m).toString().substring(33, box.getChildren().get(m).toString().length()-1);
                    aaa.add(newString);
                }

                sender.setText(aaa.get(1));
                receiver.setText(aaa.get(2));
                obj.setText(aaa.get(3));
                text.setText(aaa.get(4));

                for (int n=0; n<aaa.size(); n++){
                    System.out.println(aaa.get(n));
                }


            } );

            cont++;
        }while(cont< casella.size());
    }

    public void inserimentoDati(HBox box){
        /*Node sen=box.getChildren().get(1);
        sender.setText(sen.getAccessibleText());
        Node rec=box.getChildren().get(2);
        receiver.setText(rec.getAccessibleText());
        Node ogg=box.getChildren().get(3);
        obj.setText(ogg.getAccessibleText());
        Node txt=box.getChildren().get(4);
        text.setText(txt.getAccessibleText());*/
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
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}