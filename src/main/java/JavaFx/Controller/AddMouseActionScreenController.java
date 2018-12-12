package JavaFx.Controller;

import Clickers.MouseClicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.awt.event.InputEvent;

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
    private Button btnSubmitMouseAction;

    @FXML
    public void initialize(){
        btnMouseButton.setValue("Left click");
        btnMouseButton.setItems(typeClicks);
//        btnSubmitMouseAction.setOnAction();

    }


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void submitMouseAction() throws Exception{
        if(isInt(txtX) && isInt(txtY) && isInt(txtDelay) && areFieldFilled()){
            MouseClicker mc = new MouseClicker(toInt(txtDelay),
                                                toInt(txtX),
                                                toInt(txtY),
                                                setMouseButton(btnMouseButton),
                                                txtMouseActionName.getText());
            mainController.getClickerContainer().addAction(mc);
        }
        mainController.loadMainScreen();
    }

    @FXML
    public void cancelAddMouseAction() throws Exception{
        mainController.loadMainScreen();
    }

    private int setMouseButton(ChoiceBox input){
        if(input.getValue().equals("Left click")){
            return InputEvent.BUTTON1_MASK;
        }
        return InputEvent.BUTTON2_MASK;
    }

    private boolean isInt(TextField input){
        String str = input.getText();
        try{
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    private int toInt(TextField input){
        return Integer.parseInt(input.getText());
    }

    private boolean areFieldFilled(){
        return !this.txtMouseActionName.getText().equals("")
                && !this.txtX.getText().equals("")
                && !this.txtY.getText().equals("")
                && !this.txtDelay.getText().equals("");
    }
}
