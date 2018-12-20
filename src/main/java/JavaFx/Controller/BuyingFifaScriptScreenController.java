package JavaFx.Controller;

import Controller.ClickerContainer;
import Static.Script;
import javafx.beans.binding.When;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import static JavaFx.Validation.TextFieldValidation.isValidInteger;
import static JavaFx.Validation.TextFieldValidation.toInt;

public class BuyingFifaScriptScreenController {

    @FXML
    private TextField txtMinPrice;

    @FXML
    private TextField txtMaxPrice;

    private MainController mainController;

    void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void cancelScriptAction() throws Exception{
        mainController.loadMainScreen();
    }

    @FXML
    public void submitBuyingScript() throws Exception {
        ClickerContainer container = mainController.getClickerContainer();
        if(isValidInteger(txtMinPrice)){
            Script buyingScript = new Script("buying", txtMinPrice.getText());
            container.insertScript(buyingScript);
        }
        mainController.loadMainScreen();
    }

    @FXML
    public void initialize() {
        txtMinPrice.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if(isValidInteger(txtMinPrice)){

                int difference = setDifferenceInPrices(txtMinPrice);
                txtMaxPrice.setText(String.valueOf(Integer.parseInt(txtMinPrice.getText())+difference));
            }
        }));

    }


    public int setDifferenceInPrices(TextField price){
        int maxPrice = Integer.parseInt(price.getText());
        if(maxPrice < 949){
            return 100;
        }
        else if(maxPrice == 950){
            return 150;
        }
        else if(maxPrice < 9900){
            return 200;
        }
        else if(maxPrice == 9900){
            return 350;
        }
        else if(maxPrice < 49750){
            return 500;
        }
        else if(maxPrice == 49750){
            return 750;
        }
        else if(maxPrice < 99500){
            return 1000;
        }
        else if(maxPrice == 99500){
            return 1500;
        }
        else{
            return 2000;
        }
    }
}
