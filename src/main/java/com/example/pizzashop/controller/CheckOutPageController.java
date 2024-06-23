package com.example.pizzashop.controller;

import com.example.pizzashop.models.OrderReceipt;
import com.example.pizzashop.utils.AddressService;
import com.example.pizzashop.utils.CartService;
import com.example.pizzashop.utils.Mail;
import com.example.pizzashop.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CheckOutPageController {
    @FXML
    private TextField CardHolderName;

    @FXML
    private TextField accountNumberField;

    @FXML
    private Label addressLabel;

    @FXML
    private TextField cardNumberField;

    @FXML
    private RadioButton cardPaymentRadio;

    @FXML
    private StackPane checkoutRoot;

    @FXML
    private RadioButton chequePaymentRadio;

    @FXML
    private VBox driverInstructionContainer;

    @FXML
    private TextField driverInstructionField;

    @FXML
    private HBox expirationDateHolder;

    @FXML
    private TextField expirationMonthField;

    @FXML
    private TextField expirationYearField;

    @FXML
    private RadioButton payWithCashRadio;

    @FXML
    private VBox paymentContainer;

    @FXML
    private Button processOrderButton;

    @FXML
    private TextField routingNumberField;

    @FXML
    private TextField securityCodeField;

    @FXML
    private TextField zipCodeField;

    private ToggleGroup toggleGroup;

    private OrderReceipt orderReceipt;

    private AddressService addressService = AddressService.getInstance();

    private final CartService cartService = CartService.getInstance();

    @FXML
    void validatePayment(ActionEvent event) {
        initialize();
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();

        try {
            if(driverInstructionField.getText().isEmpty()) {
                throw new RuntimeException("no driver instruction!!");
            }

            else if (selectedRadioButton != null) {
                switch (selectedRadioButton.getId()) {
                    case "cardPaymentRadio" -> payWithcard();

                    // Your action for RadioButton 1
                    case "chequePaymentRadio" -> payWithCheque();

                    // Your action for RadioButton 2
                    case "payWithCashRadio" -> {
                        try {
                            if(cartService.getCart().isEmpty()) {
                                throw new Exception("Empty cart");
                            }
                            orderReceipt = new OrderReceipt(cartService.getCart());
                            Mail.sendEmail("takoufredy69@gmail.com", "Your balance",
                                    orderReceipt.generateReceipt(""));
                            Utils.showAlertInformation("OrderReview", orderReceipt.generateReceipt("") +
                                    "\n Pay to the driver upon delivery!!");
                        }
                        catch (Exception ex) {
                            Utils.showAlertError("Error", "Can't proceed your payment, because you have an empty cart");
                        }
                    }

                    // Your action for RadioButton 3
                }
            }

            else {
                Utils.showAlertError("Empty selection", "You must make a payment selection");
            }

        } catch (Exception e) {
            Utils.showAlertError("Empty field", "You must enter driver's instructions");
        }


    }

    private void payWithCheque() {
        if (validateCheque()) {
            processPayment(accountNumberField);
        }
    }

    private void processPayment(TextField accountNumberField) {
        try {
            if(cartService.getCart().isEmpty()) {
                throw new Exception("Empty cart");
            }
            orderReceipt = new OrderReceipt(cartService.getCart());
            Utils.showAlertInformation("Order Summary", orderReceipt.generateReceipt(accountNumberField.getText()));
            Mail.sendEmail("takoufredy69@gmail.com", "Payment Received Successfully",
                    orderReceipt.generateReceipt(accountNumberField.getText()));
            Utils.showAlertInformation("Successful Payment", "Your payment has been received, your order" +
                    " confirmation has been sent to your email");
        } catch (Exception ex) {
            Utils.showAlertError("Error", "Can't proceed your payment, because you have an empty cart");
        }
    }

    private boolean validateCheque() {
        if(accountNumberField.getText().length() == 0 || routingNumberField.getText().length() == 0) {
            Utils.showAlertError("Empty input fields", "You must enter all cheque information");
            return false;
        }
        try {
            long accountNumber = Integer.valueOf(accountNumberField.getText());
            long routingNumber = Integer.valueOf(routingNumberField.getText());
        }
        catch (Exception ex) {
            Utils.showAlertError("Wrong Input format", "Wrong Input Format");
            return false;
        }

        return true;
    }

    private void payWithcard() {
        if (validateCard()) {
            //System.out.println("Send Email with payment recap");
            //handle how to get the cart to avoid null pointer exception
            processPayment(cardNumberField);
        }
    }

    private boolean validateCard() {
        String holder = CardHolderName.getText();
        String numbercard = cardNumberField.getText();
        String expMonth = expirationMonthField.getText();
        String expYear = expirationYearField.getText();
        String secCode = securityCodeField.getText();
        String zipCode = zipCodeField.getText();

        if (holder.isEmpty() || numbercard.isEmpty() || expMonth.isEmpty() || expYear.isEmpty()
        || secCode.isEmpty() || zipCode.isEmpty()) {
            Utils.showAlertError("Empty input fields", "You must enter all card information");
        }
        try {
            int card = Integer.parseInt(numbercard);
            int month = Integer.parseInt(expMonth);
            int year = Integer.parseInt(expYear);
            int sec = Integer.parseInt(secCode);
            int zip = Integer.parseInt(zipCode);
        }
        catch (Exception ex) {
            Utils.showAlertError("Wrong Input format", "Wrong Input Format");
            return false;
        }

        return true;
    }

    //@Override
    public void initialize() {
        addressLabel.setText("Deliver to " + addressService.getAddress());
        // Create a ToggleGroup
        toggleGroup = new ToggleGroup();

        // Assign the ToggleGroup to RadioButtons
        cardPaymentRadio.setToggleGroup(toggleGroup);
        chequePaymentRadio.setToggleGroup(toggleGroup);
        payWithCashRadio.setToggleGroup(toggleGroup);

    }

    public void getBody() {
        double totalPrice = 0;
        double tax = 0;
    }
}
