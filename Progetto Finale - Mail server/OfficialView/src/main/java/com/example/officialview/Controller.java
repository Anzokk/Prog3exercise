package com.example.officialview;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class Controller {
    @FXML
    private TextArea text = new TextArea();
    @FXML
    private TextField obj = new TextField();
    @FXML
    private TextField receiver = new TextField();
    @FXML
    private TextField sender = new TextField();
    @FXML
    private VBox grid;
    Model m =new Model();

    public void mailboxView(HBox box){
        box.setOnMouseClicked( ( e ) -> fillForm(box));
        grid.getChildren().add(box);
    }


    public void mailDisplay(ArrayList<String> mailDatas){
        sender.setText(mailDatas.get(1));
        receiver.setText(mailDatas.get(2));
        obj.setText(mailDatas.get(3));
        text.setText(mailDatas.get(4));
    }


    public void fillForm(HBox box){
        ArrayList<String> datas=new ArrayList<>();
        for(int m=0; m<box.getChildren().size();m++){
            String newString = box.getChildren().get(m).toString();
            newString= box.getChildren().get(m).toString().substring(newString.indexOf("'")+1, box.getChildren().get(m).toString().length()-1);
            datas.add(newString);
        }
        mailDisplay(datas);
    }


    public void metodociclicodicontrollomail(){
        ArrayList<HBox> grid=m.boxCreation("let0002");
        for (int i=0; i<m.boxCreation("let0002").size(); i++){
            mailboxView(grid.get(i));
        }
    }



    
    @FXML
    public void sendMail(){
        /*Email mail = new Email("0", sender.getText(), receiver.getText(), obj.getText(), text.getText());*/

    }

    @FXML
    private void replyMail(){

    }

    @FXML
    private void deleteMail(){

    }

    @FXML
    private void forwardMail(){

    }
}