package com.example.pizzashop.controller;

import com.example.pizzashop.models.Address;
import com.example.pizzashop.utils.AddressService;
import com.example.pizzashop.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddressPageController {
    @FXML
    private Button cancelButton;

    @FXML
    private TextField cityField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField streetField;

    @FXML
    private TextField zipField;

    private AddressService addressService = AddressService.getInstance();

    @FXML
    void cancelAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    void saveAddress(ActionEvent event) {
        String street = streetField.getText();
        String zip = zipField.getText();
        String city = cityField.getText();
        try {
            if(!validateFields(street, zip, city)) {
                throw new RuntimeException("Empty fields");
            }
            else {
                Address address = new Address(streetField.getText(), zipField.getText(), cityField.getText());
                addressService.setAddress(address);
                Utils.showAlertConfirmation("Successfully changed", "Your address has been changed successfully");
                //Save to database
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        } catch (Exception ex) {
            Utils.showAlertError("Empty Fields", "You must fill all the fields");
        }
    }

    private boolean validateFields(String street, String zip, String city) {
        return !street.isEmpty() && !zip.isEmpty() && !city.isEmpty();
    }
}
