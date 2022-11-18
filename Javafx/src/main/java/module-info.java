module com.example.esercizio {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.esercizio to javafx.fxml;
    exports com.example.esercizio;
}