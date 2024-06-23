package com.example.pizzashop.controller;


import com.example.pizzashop.models.Product;
import com.example.pizzashop.utils.CartService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HomePageController {

    @FXML
    private Button cart;

//    @FXML
//    public ScrollPane centerPane;

    @FXML
    private Button homeButton;

    @FXML
    private BorderPane homeContainer;

    @FXML
    private ImageView homeLogo;

//    @FXML
//    public VBox vBoxCenterPane;

    @FXML
    private Button menuButton;

    @FXML
    private Button signIn_RegisterButton;

    @FXML
    private Button trackerButton;

    @FXML
    public StackPane centerPane;

    @FXML
    private StackPane rightPane;

    private VBox menuPane = new VBox();

    private final CartService cartService = CartService.getInstance();

    private static void accept(Product p, Integer q) {
        System.out.println("product is " + p + "qty is " + String.valueOf(q));
    }

    //private boolean viewMenu = false;




    @FXML
    void loadSigninRegisterPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pizzashop/Sign in page.fxml"));
        AnchorPane pane = loader.load();
        SignInPageController signInPageController = loader.getController();
        signInPageController.setHomePageController(this);

        centerPane.setPadding(new Insets(50,0,50,400));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(pane);
    }

    @FXML
    void loadHome(ActionEvent event) {

    }

    @FXML
    void loadMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pizzashop/Menu Page.fxml"));
        ScrollPane pane = loader.load();
        MenuPageController menuPageController = loader.getController();
        menuPageController.setHomePageController(this);

        centerPane.setPadding(new Insets(0,0,0,400));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(pane);
        //viewMenu = true;

    }



    @FXML
    void viewCart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pizzashop/Menu Page.fxml"));
        ScrollPane pane1 = loader.load();
        MenuPageController menuPageController = loader.getController();
        menuPageController.setHomePageController(this);
        //List<Product> cart = menuPageController.getCart();

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/com/example/pizzashop/cart Page.fxml"));
        Parent pane = loader2.load();
        CartPageController cartPageController = loader2.getController();
        cartPageController.setHomePageController(this);
        List<Product> cart = cartService.getCart();
        cartPageController.populateCart(cart);

        //set center pane to hold the cart and its items
        centerPane.setPadding(new Insets(0,0,0,300));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(pane);

        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/com/example/pizzashop/location Page.fxml"));
        Parent pane2 = loader3.load();
        rightPane.setPadding(new Insets(0,5,0,5));
        rightPane.getChildren().clear();
        rightPane.getChildren().add(pane2);

    }

    void fillCart() throws IOException {

    }

    void loadCheckout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pizzashop/check out Page.fxml"));
        Parent pane = loader.load();

        centerPane.setPadding(new Insets(0,0,0,400));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(pane);
        rightPane.getChildren().clear();
        //To avoid nullpointer exception bcz the right pane will be empty
        rightPane.getChildren().add(new Label(""));
    }




}
