package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.AppointmentAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Appointment;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.AppointmentService;
import tornadofx.control.DateTimePicker;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;


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
    @FXML private DateTimePicker dateTimePicker;
    private String name;
    private String appointmentDate;
    @FXML
    private static int abc=9999;
    public void handleBookAppointmentButton() throws UsernameAlreadyExistsException, AppointmentAlreadyExistsException {

        //AppointmentService.addAppointment(1, "Service Name", LocalDateTime.from(dateTimePicker.getDateTimeValue()), name, "Engineer User Name", "Pending");
        // AppointmentService.addAppointment(1, "Service Name", LocalDateTime.parse(String.valueOf(LocalDateTime.from(dateTimePicker.getDateTimeValue()))), name, "Engineer User Name", "Pending");
      // appointmentDate= String.valueOf(LocalDateTime.from(dateTimePicker.getDateTimeValue()));
        System.out.println(dateTimePicker.getDateTimeValue());
        appointmentDate = String.valueOf(dateTimePicker.getDateTimeValue());
        System.out.println(appointmentDate);

        AppointmentService.addAppointment(abc++, "Service Name", LocalDate.from(dateTimePicker.getDateTimeValue()), name, "Engineer User Name", "Pending");
    }

    @FXML
    private void receiveData(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        User u = (User) stage.getUserData();

        this.name = u.getUsername();
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