package com.example.pizzashop.controller;

import com.example.pizzashop.database.DatabaseConnectionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class SignInPageController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private AnchorPane signInAnchorPane;

    @FXML
    private Button signInButton;

    private HomePageController homePageController;
    DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();

    @FXML
    void loadRegisterPage(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/com/example/pizzashop/Register Page.fxml"));
        homePageController.centerPane.setPadding(new Insets(50,0,50,400));
        homePageController.centerPane.getChildren().clear();
        homePageController.centerPane.getChildren().add(pane);



    }

    @FXML
    void signIn(ActionEvent event) {


    }

    public void setHomePageController(HomePageController homePageController) {
        this.homePageController = homePageController;
    }
}
