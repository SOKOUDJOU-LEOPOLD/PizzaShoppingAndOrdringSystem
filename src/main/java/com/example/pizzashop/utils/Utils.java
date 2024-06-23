package com.example.pizzashop.utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Utils {
    //usage: page.loadPage("path: /directory1/views/floorPage.fxml"); where page is a Utils instance.
    public void loadPage(String FXMLPath) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(FXMLPath));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.getIcons().add(new Image("src/main/java/com/pacha/pizzaorderdeliverysystem/utils/images/logo.jpg"));
    }

    public static void closePage(Node source){
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public static void showAlertError(String header, String context){
        Alert forgot = new Alert(Alert.AlertType.ERROR);
        forgot.setHeaderText(header);
        forgot.setContentText(context);
        forgot.initModality(Modality.APPLICATION_MODAL);
        forgot.showAndWait();
    }

    public static void showAlertInformation(String header, String context){
        Alert forgot = new Alert(Alert.AlertType.INFORMATION);
        forgot.setHeaderText(header);
        forgot.setContentText(context);
        forgot.initModality(Modality.APPLICATION_MODAL);
        forgot.showAndWait();
    }

    /**
     *
     * @param header
     * @param context
     * @return a Boolean value depending on the answer of the alert
     */
    //usage: PageUtils.showAlertInformation("CREDENTIALS FORGOTTEN", "MESSAGE AN ADMIN TO RECOVER YOUR CREDENTIALS");
    public static boolean showAlertConfirmation(String header, String context){
        Alert forgot = new Alert(Alert.AlertType.CONFIRMATION);
        forgot.setHeaderText(header);
        forgot.setContentText(context);
        forgot.initModality(Modality.APPLICATION_MODAL);
        forgot.showAndWait();

        return forgot.getResult() != ButtonType.CANCEL;
    }
}
