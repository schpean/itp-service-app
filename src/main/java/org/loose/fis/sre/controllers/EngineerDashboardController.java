package org.loose.fis.sre.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Appointment;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EngineerDashboardController implements Initializable {

    @FXML private  Tab appointment;

    @FXML private TableView<Appointment> appointmentsTableView;  //this

    @FXML private TableColumn<Appointment, String> appointmentsNameCol; // this

    @FXML private TableColumn<Appointment,String> appointmentsDateCol; // this

    @FXML private TableColumn<Appointment,String> statusCol; // this

    @FXML private  Tab appointmentsHistory;

    @FXML private TableView<Appointment> appointmentsHistoryTableView;

    @FXML private TableColumn<Appointment,String> appointmentsNameHistoryCol;

    @FXML private TableColumn<Appointment,String> appointmentsDateHistoryCol;

    @FXML private  Tab profile;

    @FXML private TableView<Appointment> profileTableView;

    @FXML private TableColumn<Appointment,String> profileNameCol;

    @FXML private Label usernameLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointmentsDateCol.setCellValueFactory(new PropertyValueFactory<>("availability"));
        appointmentsNameCol.setCellValueFactory(new PropertyValueFactory<>("customerUserName"));
        //statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        ObservableList<Appointment> appointments = appointmentsHistoryTableView.getItems();
        appointments.add(new Appointment(1245, "Service Name", LocalDate.now(), "George", "Engineer", "Pending"));
        appointments.add(new Appointment(124, "Service Name", LocalDate.now(), "Vasile", "Engineer", "Pending"));

        appointmentsTableView.setItems(appointments);
    }

    public void acceptButton(){}

    public void denyButton(){}

    public void removeButton(){}

    public void handleHomeButton(ActionEvent event) throws IOException {
        Parent register = FXMLLoader.load(getClass().getResource("FXMLs/login.fxml"));
        Scene registerScene = new Scene(register);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registerScene);
        window.show();
    }

    public void denyButton(ActionEvent actionEvent) {
        int selectedID = appointmentsTableView.getSelectionModel().getSelectedIndex();
        appointmentsTableView.getItems().remove(selectedID);
    }
}