package com.example.pizzashop.controller;

import com.example.pizzashop.HelloApplication;
import com.example.pizzashop.models.Product;
import com.example.pizzashop.utils.AddressService;
import com.example.pizzashop.utils.CartService;
import com.example.pizzashop.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import lombok.Getter;

import java.io.IOException;
import java.util.*;

public class CartPageController {

    @FXML
    private Button addMoreItemsButton;

    @FXML
    private VBox cartRoot;

    private String PATH_PREFIX = "images/";

    @FXML
    private Button checkoutButton;

    @FXML
    private VBox firstAfterRootCart;

    @FXML
    private ScrollPane productWrap;

    @FXML
    private Label totalPriceLabel;

    @FXML
    private StackPane anchorRoot;

    @FXML
    private ScrollPane scroll;

    @Getter
    private HomePageController homePageController;

    private AddressService addressService = AddressService.getInstance();

    private double totalPrice;




    public void setHomePageController(HomePageController homePageController) {
        this.homePageController = homePageController;
    }



    @FXML
    void backToMenu(ActionEvent event) throws IOException {
        homePageController.loadMenu(event);

    }

    @FXML
    void goCheckout(ActionEvent event) throws IOException {
        try {
            if(addressService.getAddress().isEmpty()) {
                throw new RuntimeException("Update you delivery address");
            }
            homePageController.loadCheckout(event);
        } catch (RuntimeException exception) {
            Utils.showAlertError("Empty Location", "You must enter your address before you checkout");
        }

    }

    // Method to populate the holdCartItems GridPane
    public void populateCart(List<Product> cart) {
        totalPrice = 0;

        if(anchorRoot != null) {
            anchorRoot.getChildren().clear();// Clear existing items
        }
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        //ScrollPane scrollPane = new ScrollPane(gridPane);

        HashSet<Product> visited = new HashSet<>();

        for (int i = 0; i < cart.size(); i++) {
            if (!(visited.contains(cart.get(i)))) {
                visited.add(cart.get(i));
                GridPane component = (GridPane) createProductComponent(cart.get(i), cart).get(0);
                double price = (Double) createProductComponent(cart.get(i), cart).get(1);
                totalPrice += price;
                Label priceLabel = new Label("Price: $" + String.format("%.2f", price));
                priceLabel.setPadding(new Insets(50, 0, 0, 0));
                //component.setPadding(new Insets(30, 0, 20, 50));

                HBox hBox = new HBox(100);
                hBox.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10;");

                // Align the component  to the right
                HBox.setMargin(component, javafx.geometry.Insets.EMPTY); // Reset margin
                HBox.setHgrow(component, javafx.scene.layout.Priority.ALWAYS);

                // Align the priceLabel element to the right
                HBox.setMargin(priceLabel, new javafx.geometry.Insets(0, 0, 0, 10)); // 10 pixels right margin
                HBox.setHgrow(priceLabel, javafx.scene.layout.Priority.ALWAYS);

                hBox.getChildren().addAll(component, priceLabel);
                //Label space = new Label("                       ");
                //space.setPadding(new Insets(0, 0, 0, 30));
                // Create column constraints
                ColumnConstraints columnConstraints = new ColumnConstraints();

                // Set the percent width of the column to 100%
                columnConstraints.setPercentWidth(70);

                // Apply the column constraints to the grid pane
                gridPane.getColumnConstraints().add(columnConstraints);

                //gridPane.add(space, 0, i, 3, 1);
                gridPane.add(hBox,0, i, 2, 1);


            }

        }
        //scrollPane.setFitToHeight(true);
        //scrollPane.setFitToWidth(true);
        anchorRoot.getChildren().add(gridPane);


        totalPriceLabel.setText(String.format("$%.2f", totalPrice));
    }

    private List<Object> createProductComponent(Product product, List<Product> cart) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.TOP_CENTER);

        // Set up constraints to shape the product component
        ColumnConstraints colConstraints = new ColumnConstraints();
        RowConstraints rowConstraints = new RowConstraints();

        // Set percent widths and heights to ensure a nice component
        colConstraints.setPercentWidth(70);
        rowConstraints.setPercentHeight(60);

        // Apply constraints
        gridPane.getColumnConstraints().add(colConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        //gridPane.setPadding(new Insets(0, -130, 0, 50));

        gridPane.setStyle("/*-fx-background-color: #ffffff;  Light gray background color */\n" +
                "    /*-fx-border-color: #ccc;  Light border color */\n" +
                "    -fx-border-width: 0;");

        // Add columns for the grid
//        ColumnConstraints column1 = new ColumnConstraints(100);
//        ColumnConstraints column2 = new ColumnConstraints(100);
//        //ColumnConstraints column3 = new ColumnConstraints(100);
//        gridPane.getColumnConstraints().addAll(column1, column2);

        // Load product image
        //replace path in getResource by: PATH_PREFIX + product.getProduct_name
        //fill the image directory for each product
        Image image = new Image(String.valueOf(HelloApplication.class.getResource("images/specialty.jpg")) );
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);


        // Add product name label
        Label nameLabel = new Label(product.getProduct_name());
        nameLabel.setPadding(new Insets(-7, 0, 0, 5));

        int quantity = getQuantity(product, cart) ;

        // Add product quantity label
        Label quantityLabel = new Label("Quantity: " + String.valueOf(quantity));
        quantityLabel.setPadding(new Insets(-7, 0, 0, 5));

        // Add "Remove" button
        Button removeButton = new Button("Remove");
        removeButton.setPadding(new Insets(3, 0, -3, 0));

        removeButton.setOnAction(e -> removeFromCart(product, cart));

        // Add price label
        //Label priceLabel = new Label("Price: $" + product.getPrice()*quantity);
        //totalPrice += product.getPrice()*quantity;
//
        AnchorPane pane1 = new AnchorPane(imageView);
        //pane1.setPadding(new Insets(5, 5, 5, 50));
        gridPane.add(imageView, 0, 0, 1, 1); // span 3 columns

        // Add product name label
        AnchorPane pane2 = new AnchorPane(nameLabel);
        //pane2.setPadding(new Insets(5, 5, 5, 50));
        gridPane.add(nameLabel, 0, 1, 1, 1); // span 3 columns

        // Add product qty label
        AnchorPane pane3 = new AnchorPane(quantityLabel);
        //pane3.setPadding(new Insets(5, 5, 5, 50));
        gridPane.add(quantityLabel, 0, 2, 1, 1); // span 3 columns

        // Add product price label
//        AnchorPane pane4 = new AnchorPane(priceLabel);
//        pane4.setPadding(new Insets(0, -90, 0, 0));
//        gridPane.add(priceLabel, 0, 3, 1, 1); // span 3 columns




        gridPane.add(removeButton, 0, 3, 1, 4); // span 3 columns

        return List.of(gridPane, product.getPrice()*quantity);
    }

    // Method to get the quantity of a product in the cart
    private int getQuantity(Product product, List<Product> cart) {
        Map<Product, Integer> cartMap = getCartMap(cart);
        return cartMap.getOrDefault(product, 0);
    }

    // Method to remove a product from the cart
    private void removeFromCart(Product product, List<Product> cart) {
        cart.remove(product);
        populateCart(cart);
    }

    // Method to convert the cart list to a map of product to quantity
    private Map<Product, Integer> getCartMap(List<Product> cart) {
        HashMap<Product, Integer> map = new HashMap<>();

        cart.forEach(p ->{
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + 1);
            }
            else {
                map.put(p, 1);
            }
        });



        return map;
    }


}
