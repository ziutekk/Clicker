package JavaFx.Controller;

import Clickers.MouseClicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.awt.event.InputEvent;

import static JavaFx.Validation.ChoiceBoxValidation.setMouseButton;
import static JavaFx.Validation.TextFieldValidation.*;
import static java.awt.event.InputEvent.BUTTON1_MASK;
import static java.awt.event.InputEvent.BUTTON2_MASK;

public class AddMouseActionScreenController {

    private MainController mainController;

    private ObservableList<String> typeClicks = FXCollections.observableArrayList("Left click", "Right click");

    @FXML
    private TextField txtMouseActionName;

    @FXML
    private TextField txtX;

    @FXML
    private TextField txtY;

    @FXML
    private TextField txtDelay;

    @FXML
    private ChoiceBox<String> btnMouseButton;

    @FXML
    public void initialize(){

        btnMouseButton.setValue("Left click");
        btnMouseButton.setItems(typeClicks);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void submitMouseAction() throws Exception{
        if(isValidInteger(txtX) && isValidInteger(txtY) && isValidInteger(txtDelay) && isFilled(txtMouseActionName) ){
            MouseClicker mc = new MouseClicker(toInt(txtDelay),
                                                toInt(txtX),
                                                toInt(txtY),
                                                setMouseButton(btnMouseButton.getValue()),
                                                txtMouseActionName.getText());
            mainController.getClickerContainer().addAction(mc);
        }
        mainController.loadMainScreen();
    }

    @FXML
    public void cancelAddMouseAction() throws Exception{
        mainController.loadMainScreen();
    }
}


