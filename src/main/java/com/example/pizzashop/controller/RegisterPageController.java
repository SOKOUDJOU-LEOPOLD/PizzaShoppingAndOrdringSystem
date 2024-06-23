package com.example.pizzashop.controller;

import com.example.pizzashop.dao.RegisterDAO;
import com.example.pizzashop.repository.LoginRegisterRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterPageController {

    @FXML
    private TextField confirmPasswordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button registerButton;


    @FXML
    private AnchorPane registerAnchorPane;



    @FXML
    void register(ActionEvent event) {
        String person_type = "customer";

        RegisterDAO registerDAO = new RegisterDAO(firstNameField.getText(),passwordField.getText(),
                person_type, firstNameField.getText(), lastNameField.getText(), emailField.getText(),
                phoneNumberField.getText());

        LoginRegisterRepository loginRegisterRepository = new LoginRegisterRepository();
        loginRegisterRepository.registerCustomer(registerDAO);
        System.out.println(firstNameField.getText()+" was registered");

        // close window
//        Stage stage = (Stage)firstNameField.getScene().getWindow();
//        stage.close();

        // to close the window you can also use the event to obtain the window
        // Stage stage = event.getSource().getScene().getWindow();
        // stage.close()
    }

}
