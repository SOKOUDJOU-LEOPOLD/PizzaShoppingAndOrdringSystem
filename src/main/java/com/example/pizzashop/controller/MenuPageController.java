package com.example.pizzashop.controller;

import com.example.pizzashop.HelloApplication;
import com.example.pizzashop.models.Product;
import com.example.pizzashop.repository.ProductRepository;
import com.example.pizzashop.utils.CartService;
import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class MenuPageController {

    @FXML
    private Hyperlink buildButton;

    @FXML
    private Hyperlink chickenButton;

    @FXML
    private Hyperlink drinksButton;

    @FXML
    private Hyperlink extrasButton;

    @FXML
    private VBox vboxPane;

    @FXML
    private ScrollPane menuPane;

    @FXML
    private Hyperlink specialityButton;


    private final ProductRepository productRepository = new ProductRepository();

    @Getter
    private final CartService cartService = CartService.getInstance();

    private HomePageController homePageController;

    public void setHomePageController(HomePageController homePageController) {
        this.homePageController = homePageController;
    }

    @FXML
    void buildPizza(ActionEvent event) {
        //load the create pizza page

    }

    @FXML
    void showChicken(ActionEvent event) {
        VBox vbox = showProducts("Chicken", "", "");
        StackPane homeCenter = this.homePageController.centerPane;
        homeCenter.setPadding(new Insets(100, 180, 40, 180));
        homeCenter.getChildren().clear();
        homeCenter.getChildren().add(vbox);

    }

    @FXML
    void showSpeciality(ActionEvent event) {
        VBox vbox = showProducts("Pizza", "PIZZA SHOP’S " +
                "SPECIALTY PIZZA", "Specialty pizzas are our most valuable pizzas and " +
                "All our specialty pizza come in large size.");
        StackPane homeCenter = this.homePageController.centerPane;
        homeCenter.setPadding(new Insets(100, 180, 40, 180));
        homeCenter.getChildren().clear();
        homeCenter.getChildren().add(vbox);

    }

    @FXML
    void viewDrinks(ActionEvent event) {
        VBox vbox = showProducts("Drinks", "PIZZA SHOP’S DRINKS & BEVERAGES", "Complete your order with drinks " +
                "for delivery, including your favorite soda or bottled water.");
        StackPane homeCenter = this.homePageController.centerPane;
        homeCenter.setPadding(new Insets(100, 180, 40, 180));
        homeCenter.getChildren().clear();
        homeCenter.getChildren().add(vbox);

    }

    @FXML
    void viewExtras(ActionEvent event) {
        VBox vbox = showProducts("Sauce", "PIZZA SHOP’S SAUCE", "Complete your order " +
                "with our famous dipping sauces!");
        StackPane homeCenter = this.homePageController.centerPane;
        homeCenter.setPadding(new Insets(100, 180, 40, 180));
        //homeCenter.setPadding(new Insets(0,0,0,400));
        homeCenter.getChildren().clear();
        homeCenter.getChildren().add(vbox);

    }

    VBox showProducts(String category, String title, String desc) {
        List<Product> products = productRepository.getProducts(category);
        // Create a label
        Label tit = new Label(title);
        Label des = new Label(desc);

        // Apply inline styles directly
        tit.setStyle("-fx-font-size: 20px; -fx-text-fill: #000000; -fx-font-weight: bold;");
        des.setStyle("-fx-text-fill: #0073e6");


        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        // Apply styles directly to the ScrollPane
        root.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10;");
        root.getChildren().addAll(tit, des);

        //ScrollPane scrollPane = new ScrollPane();
        VBox scrollContent = new VBox(10);
        //scrollPane.setContent(scrollContent);

        //create gridpane to hold at most 3 product components.
        GridPane g1 = new GridPane();
        g1.setHgap(20);
        g1.setVgap(20);
        g1.setAlignment(Pos.CENTER);
        g1.setPadding(new Insets(10, 0, 10, 40));

        // Iterate through the products and create a grid pane for each
        for (int i = 0; i < products.size(); i++) {
            GridPane gridPane = createProductGridPane(products.get(i));
            ///////////////////////////////
            gridPane.setPadding(new Insets(10, 0, 10, 40));

            int row = i/3;
            int col = i %3;
            g1.add(gridPane, col, row);
        }
        scrollContent.getChildren().add(g1);


        //root.getChildren().add(scrollPane);
        root.getChildren().add(scrollContent);






        return root;
    }

    private GridPane createProductGridPane(Product product) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(0, -130, 0, 50));

        gridPane.setStyle("-fx-background-color: #f4f4f4; /* Light gray background color */\n" +
                "    -fx-padding: 10;\n" +
                "    -fx-border-color: #ccc; /* Light border color */\n" +
                "    -fx-border-width: 1;");

        // Add columns for the grid
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(100);
        ColumnConstraints column3 = new ColumnConstraints(100);
        gridPane.getColumnConstraints().addAll(column1, column2, column3);


        // Load product image
        Image image = new Image(String.valueOf(HelloApplication.class.getResource("images/specialty.jpg")) ); // Assuming imagePath is a property in your Product class
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        AnchorPane pane1 = new AnchorPane(imageView);
        pane1.setPadding(new Insets(5, 5, 5, 50));
        gridPane.add(pane1, 0, 0, 3, 1); // span 3 columns

        // Add product name label
        Label nameLabel = new Label(product.getProduct_name());
        AnchorPane pane2 = new AnchorPane(nameLabel);
        pane2.setPadding(new Insets(5, 5, 5, 50));
        gridPane.add(pane2, 0, 1, 3, 1); // span 3 columns

        // Add product name label
        Label dscLabel = new Label(product.getProduct_desc());
        AnchorPane pane3 = new AnchorPane(dscLabel);
        pane3.setPadding(new Insets(5, 5, 5, 50));
        gridPane.add(pane3, 0, 2, 3, 1); // span 3 columns

        // Add product price label
        Label priceLabel = new Label("$" + product.getPrice());
        AnchorPane pane4 = new AnchorPane(priceLabel);
        pane4.setPadding(new Insets(0, -90, 0, 0));
        gridPane.add(pane4, 0, 3, 3, 1); // span 3 columns



        // Add "Add to Cart" button
        Button addToCartButton = new Button("Add to Cart");
        // Apply styles directly to the Button
        addToCartButton.setStyle("-fx-background-color: #4caf50; -fx-text-fill: white; -fx-padding: 5 10; -fx-font-size: 14; -fx-cursor: hand;");

        // Add hover styles
        addToCartButton.setOnMouseEntered(e -> {
            addToCartButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-padding: 5 10; -fx-font-size: 14; -fx-cursor: hand;");
        });

        addToCartButton.setOnMouseExited(e -> {
            addToCartButton.setStyle("-fx-background-color: #4caf50; -fx-text-fill: white; -fx-padding: 5 10; -fx-font-size: 14; -fx-cursor: hand;");
        });

        addToCartButton.setOnAction(event -> {
            // Add the corresponding product to the cart
            cartService.addToCart(product);
            System.out.println("Product added to cart: " + product);
        });

        gridPane.add(addToCartButton, 0, 3, 3, 1); // span 3 columns

        return gridPane;
    }

}