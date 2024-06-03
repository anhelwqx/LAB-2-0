module com.example.lab2distancecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab2distancecalculator to javafx.fxml;
    exports com.example.lab2distancecalculator;
}