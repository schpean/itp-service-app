package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Appointment;

import java.io.IOException;

public class EngineerDashboardController {

    @FXML private  Tab appointment;

    @FXML private TableView<Appointment> appointmentsTableView;

    @FXML private TableColumn<Appointment, String> appointmentsNameCol;

    @FXML private TableColumn<Appointment,String> appointmentsDateCol;

    @FXML private TableColumn<Appointment,String> statusCol;

    @FXML private  Tab appointmentsHistory;

    @FXML private TableView<Appointment> appointmentsHistoryTableView;

    @FXML private TableColumn<Appointment,String> appointmentsNameHistoryCol;

    @FXML private TableColumn<Appointment,String> appointmentsDateHistoryCol;

    @FXML private  Tab profile;

    @FXML private TableView<Appointment> profileTableView;

    @FXML private TableColumn<Appointment,String> profileNameCol;

    @FXML private Label usernameLabel;

    public void acceptButton(){}

    public void dennyButton(){}

    public void removeButton(){}

    public void handleHomeButton(ActionEvent event) throws IOException {
        Parent register = FXMLLoader.load(getClass().getResource("FXMLs/login.fxml"));
        Scene registerScene = new Scene(register);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registerScene);
        window.show();
    }

}