package com.example.officialview;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.FutureTask;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hboxView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1250, 625);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();

        //da controllare peso
        Vector<FutureTask<ArrayList<HBox>>> tasks = new Vector<>();
        ExecutorService exec= Executors.newSingleThreadExecutor();
        FutureTask<ArrayList<HBox>> lavoro=new FutureTask<>(new CasellaPostaElettronica("let0002"));
        tasks.add(lavoro);
        exec.execute(lavoro);

    }
}