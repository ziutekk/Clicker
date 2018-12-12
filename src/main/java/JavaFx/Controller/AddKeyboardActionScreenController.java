package JavaFx.Controller;

import Clickers.KeyboardClicker;
import Clickers.MouseClicker;
import Static.Variables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.util.HashMap;

import static JavaFx.Validation.ChoiceBoxValidation.setMouseButton;
import static JavaFx.Validation.TextFieldValidation.isFilled;
import static JavaFx.Validation.TextFieldValidation.isValidInteger;
import static JavaFx.Validation.TextFieldValidation.toInt;

public class AddKeyboardActionScreenController {

    private MainController mainController;

    private HashMap<String, Integer> keys = Variables.fulfillKeysMap();

    private ObservableList<String> typeKeys = FXCollections.observableArrayList();

    @FXML
    private TextField txtKeyboardActionName;

    @FXML
    private TextField txtDelay;

    @FXML
    private ChoiceBox<String> btnKeyboardButton;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void cancelAddKeyboardAction() throws Exception{
        mainController.loadMainScreen();
    }

    @FXML
    public void submitKeyboardAction() throws Exception {
        if(isValidInteger(txtDelay) && isFilled(txtKeyboardActionName) ){
            KeyboardClicker kc = new KeyboardClicker(toInt(txtDelay), keys.get(btnKeyboardButton.getValue()), txtKeyboardActionName.getText());
            mainController.getClickerContainer().addAction(kc);
        }
        mainController.loadMainScreen();
    }

    @FXML
    public void initialize(){
        typeKeys.addAll(keys.keySet());
        btnKeyboardButton.setItems(typeKeys);
    }
}
