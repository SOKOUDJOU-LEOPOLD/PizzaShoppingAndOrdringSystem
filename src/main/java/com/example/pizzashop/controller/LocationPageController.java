package com.example.pizzashop.controller;

import com.example.pizzashop.HelloApplication;
import com.example.pizzashop.utils.AddressService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LocationPageController {

    @FXML
    private Label addressLabel;

    @FXML
    private Hyperlink changeHyperLink;

    @FXML
    private Label deliveryMethodLabel;

    @FXML
    private StackPane locationroot;

    private AddressService addressService = AddressService.getInstance();

    @FXML
    void changeLocation(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/pizzashop/address page.fxml"));
//        Parent parent = fxmlLoader.load();
//        // Create a new stage for the Change Address window
//        Stage changeAddressStage = new Stage();
//        changeAddressStage.initModality(Modality.APPLICATION_MODAL);
//        changeAddressStage.setTitle("Change Address");
//        changeAddressStage.setScene(new Scene(parent, 1000, 800));
//        stage.show();
//        stage.getIcons().add(new Image(String.valueOf(HelloApplication.class.getResource("images/pizzalogo.jpg"))));
        if (addressService.getAddress() != null) {
            addressLabel.setText(addressService.getAddress());
        }
        Scene scene = new Scene(fxmlLoader.load(), 620, 250);
        stage.setTitle("PizzaShopApp");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Change Address");
        stage.show();
        stage.getIcons().add(new Image(String.valueOf(HelloApplication.class.getResource("images/pizzalogo.jpg"))));

    }
}
