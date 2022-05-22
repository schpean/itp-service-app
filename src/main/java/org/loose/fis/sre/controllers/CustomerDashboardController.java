package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Appointment;
import tornadofx.control.DateTimePicker;

import java.io.IOException;


public class CustomerDashboardController {

    @FXML private  Tab appointments;

    @FXML private TableView<Appointment> appointmentTableView;

    @FXML private TableColumn<Appointment,String> appointmentCol;

    @FXML private  Tab appointmentsHistory;

    @FXML private TableView<Appointment> appointmentsHistoryTableView;

    @FXML private TableColumn<Appointment,String> appointmentsHistoryCol;

    @FXML private  Tab profile;

    @FXML private TableView<Appointment> profileTableView;

    @FXML private TableColumn<Appointment,String> profileCol;

    @FXML
    private DateTimePicker dateTimePicker;
    @FXML
    public void handleBookAppointmentButton(){
        System.out.println("do something");
    }

    @FXML
    public void handleDatePicker() {
        System.out.println("do something");
    }

    public void handleHomeButton(ActionEvent event) throws IOException {
        Parent register = FXMLLoader.load(getClass().getResource("FXMLs/login.fxml"));
        Scene registerScene = new Scene(register);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registerScene);
        window.show();
    }

}