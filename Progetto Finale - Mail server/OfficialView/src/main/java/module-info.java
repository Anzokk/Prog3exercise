module com.example.officialview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.desktop;


    opens com.example.officialview to javafx.fxml;
    exports com.example.officialview;
}