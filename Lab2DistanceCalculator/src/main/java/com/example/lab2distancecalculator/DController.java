package com.example.lab2distancecalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DController {
    @FXML
    private TextField lat1Field, lat2Field, lon1Field, lon2Field;
    @FXML
    private Label resultLabel;
    @FXML
    private Button calculateButton;

    @FXML
    private void initialize() {
        calculateButton.setOnAction(e -> calculateDistance());
    }

    private void calculateDistance() {
        try {
            double lat1 = Math.toRadians(Double.parseDouble(lat1Field.getText()));
            double lon1 = Math.toRadians(Double.parseDouble(lon1Field.getText()));
            double lat2 = Math.toRadians(Double.parseDouble(lat2Field.getText()));
            double lon2 = Math.toRadians(Double.parseDouble(lon2Field.getText()));

            double distance = haversine(lat1, lon1, lat2, lon2);
            resultLabel.setText("Distance: " + distance + " km");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter numeric values.");
        }
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371.01; // Earth's radius in km

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}
