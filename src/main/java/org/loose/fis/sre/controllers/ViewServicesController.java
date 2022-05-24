package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewServicesController {

    @FXML
    protected void onSoareluiButtonClick() throws IOException {
        Stage registerWindow = new Stage();
        Parent secondRoot = FXMLLoader.load(getClass().getClassLoader().getResource("CustomerDashboard.fxml"));

        registerWindow.setTitle("CustomerDashboard");
        registerWindow.setScene(new Scene(secondRoot, 600, 600));
        registerWindow.show();
    }

    @FXML
    protected void onSaguluiButtonClick() throws IOException {
        Stage registerWindow = new Stage();
        Parent secondRoot = FXMLLoader.load(getClass().getClassLoader().getResource("CustomerDashboard_Sagului.fxml"));
        registerWindow.setTitle("CustomerDashboard");
        registerWindow.setScene(new Scene(secondRoot, 600, 600));
        registerWindow.show();
    }
}
