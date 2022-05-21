package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class ViewController {

    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");

    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Customer", "Engineer");
    }

    @FXML
    private Label invalidLoginCredentials;
    @FXML
    private Label invalidSignupCredentials;
    @FXML
    private TextField loginUsernameTextField;
    @FXML
    private TextField loginPasswordPasswordField;
    @FXML
    private TextField signUpUsernameTextField;
    @FXML
    private TextField signUpEmailTextField;
    @FXML
    private TextField signUpPasswordPasswordField;
    @FXML
    private TextField signUpRepeatPasswordPasswordField;

    @FXML
    protected void onLoginButtonClick() throws IOException {
        if (loginUsernameTextField.getText().isBlank() || loginPasswordPasswordField.getText().isBlank()) {
            invalidLoginCredentials.setText("The Login fields are required!");
            invalidLoginCredentials.setStyle(errorMessage);
            invalidSignupCredentials.setText("");

            if (loginUsernameTextField.getText().isBlank()) {
                loginUsernameTextField.setStyle(errorStyle);
            } else if (loginPasswordPasswordField.getText().isBlank()) {
                loginPasswordPasswordField.setStyle(errorStyle);
            }
        } else {
            if (!UserService.checkIfAccountIsValid(loginUsernameTextField.getText(), loginPasswordPasswordField.getText())) {
                invalidLoginCredentials.setText("Username or password are incorrect");
                invalidLoginCredentials.setStyle(errorMessage);
                loginUsernameTextField.setStyle(errorStyle);
                loginPasswordPasswordField.setStyle(errorStyle);
                invalidSignupCredentials.setText("");
            } else {
                invalidLoginCredentials.setText("Login Successful!");
                invalidLoginCredentials.setStyle(successMessage);
                loginUsernameTextField.setStyle(successStyle);
                loginPasswordPasswordField.setStyle(successStyle);
                invalidSignupCredentials.setText("");
                if (role.getValue().equals("Customer")) {
                    Stage registerWindow = new Stage();
                    Parent secondRoot = FXMLLoader.load(getClass().getClassLoader().getResource("viewservices.fxml"));
                    registerWindow.setTitle("Login or Sign-Up Form!");
                    registerWindow.setScene(new Scene(secondRoot, 1000, 700));
                    registerWindow.show();
                }
            }
        }
    }

        @FXML
        protected void onSignUpButtonClick() throws UsernameAlreadyExistsException {

            if (signUpUsernameTextField.getText().isBlank() || signUpEmailTextField.getText().isBlank() || signUpPasswordPasswordField.getText().isBlank() || signUpRepeatPasswordPasswordField.getText().isBlank()) {
                invalidSignupCredentials.setText("Please fill in all fields!");
                invalidSignupCredentials.setStyle(errorMessage);
                invalidLoginCredentials.setText("");

                if (signUpUsernameTextField.getText().isBlank()) {
                    signUpUsernameTextField.setStyle(errorStyle);
                } else if (signUpEmailTextField.getText().isBlank()) {
                    signUpEmailTextField.setStyle(errorStyle);
                } else if (signUpPasswordPasswordField.getText().isBlank()) {
                    signUpPasswordPasswordField.setStyle(errorStyle);
                } else if (signUpRepeatPasswordPasswordField.getText().isBlank()) {
                    signUpRepeatPasswordPasswordField.setStyle(errorStyle);
                }
            } else if (signUpRepeatPasswordPasswordField.getText().equals(signUpPasswordPasswordField.getText())) {
                invalidSignupCredentials.setText("You are set!");
                invalidSignupCredentials.setStyle(successMessage);
                signUpUsernameTextField.setStyle(successStyle);
                signUpEmailTextField.setStyle(successStyle);
                signUpPasswordPasswordField.setStyle(successStyle);
                signUpRepeatPasswordPasswordField.setStyle(successStyle);
                invalidLoginCredentials.setText("");
                try {
                    if (role.getValue() == null) {
                        invalidSignupCredentials.setText("Role field can't be empty!");
                        invalidSignupCredentials.setStyle(errorMessage);
                        role.setStyle(errorStyle);
                        invalidLoginCredentials.setText("");
                    }
                    UserService.addUser(signUpUsernameTextField.getText(), signUpPasswordPasswordField.getText(), role.getValue().toString());
                } catch (UsernameAlreadyExistsException uaee) {
                    invalidSignupCredentials.setText("An account with the username already exists!");
                    invalidSignupCredentials.setStyle(errorMessage);
                    signUpPasswordPasswordField.setStyle(errorStyle);
                    signUpRepeatPasswordPasswordField.setStyle(errorStyle);
                    invalidLoginCredentials.setText("");
                }

            } else {
                invalidSignupCredentials.setText("The Passwords don't match!");
                invalidSignupCredentials.setStyle(errorMessage);
                signUpPasswordPasswordField.setStyle(errorStyle);
                signUpRepeatPasswordPasswordField.setStyle(errorStyle);
                invalidLoginCredentials.setText("");
            }
        }
    }