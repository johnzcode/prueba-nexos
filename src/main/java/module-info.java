module org.example.pruebanexos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.pruebanexos to javafx.fxml;
    exports org.example.pruebanexos;
}