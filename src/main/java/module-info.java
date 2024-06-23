module com.example.pizzashop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.pizzashop to javafx.fxml;
    exports com.example.pizzashop;
    exports com.example.pizzashop.controller;
    opens com.example.pizzashop.controller to javafx.fxml;
    requires javafx.graphicsEmpty;
    requires java.logging;
    requires java.sql;
    requires mail;
    requires lombok;
}
