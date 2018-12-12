package JavaFx.Controller;

import Controller.ClickerContainer;
import Static.Script;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static JavaFx.Validation.TextFieldValidation.isValidInteger;
import static JavaFx.Validation.TextFieldValidation.toInt;

public class BuyingFifaScriptScreenController {

    @FXML
    private TextField txtStartingPrice;


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
        if(isValidInteger(txtStartingPrice)){
            Script buyingScript = new Script("buying", txtStartingPrice.getText());
            container.insertScript(buyingScript);
        }
        mainController.loadMainScreen();
    }

    @FXML
    public void calculateEndingPrice(ActionEvent actionEvent) {
    }
}
