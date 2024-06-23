package com.example.pizzashop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home Page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1532, 800);
        stage.setTitle("PizzaShopApp");
        stage.setScene(scene);
        stage.show();
        stage.getIcons().add(new Image(String.valueOf(HelloApplication.class.getResource("images/pizzalogo.jpg"))));
    }

    public static void main(String[] args) {
        launch();
    }
}