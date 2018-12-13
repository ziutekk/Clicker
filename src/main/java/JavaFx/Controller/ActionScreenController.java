package JavaFx.Controller;

import Clickers.Clicker;
import Clickers.MouseClicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;

import java.util.List;


import static Controller.ClickerContainer.getClickerActions;
import static JavaFx.Validation.TextFieldValidation.isValidInteger;
import static JavaFx.Validation.TextFieldValidation.toInt;

public class ActionScreenController {

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private TableView<Clicker> clickerTable;
    @FXML
    private TableColumn<Clicker, String> tcName;
    @FXML
    private TableColumn<Clicker, Integer> tcX;
    @FXML
    private TableColumn<Clicker, Integer> tcY;
    @FXML
    private TableColumn<Clicker, Integer> tcDelay;
    @FXML
    private TableColumn<Clicker, Integer> tcKey;

    @FXML
    private TextField txtRepeatCount;

    @FXML
    private TextField txtExecutionDelay;


    @FXML
    public void openCreationMouseActionWindow() throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddMouseActionScreen.fxml"));
        Pane pane = loader.load();

        AddMouseActionScreenController controller = loader.getController();
        controller.setMainController(mainController);
        mainController.setScreen(pane);
    }

    @FXML
    public void openCreationKeyboardActionWindow() throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddKeyboardActionScreen.fxml"));
        Pane pane = loader.load();

        AddKeyboardActionScreenController controller = loader.getController();
        controller.setMainController(mainController);
        mainController.setScreen(pane);
    }

    @FXML
    public void deleteAction() throws Exception{
        Clicker selectedClicker = clickerTable.getSelectionModel().getSelectedItem();
        mainController.getClickerContainer().deleteAction(selectedClicker);
        mainController.loadMainScreen();
    }

    @FXML
    public void executeActions(){
        if(isValidInteger(txtRepeatCount) && isValidInteger(txtExecutionDelay)){
            mainController.getClickerContainer().executeList(toInt(txtRepeatCount), toInt(txtExecutionDelay));
        }
    }

    @FXML
    public void insertSnipingFifaScript() throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BuyingFifaScriptScreen.fxml"));
        Pane pane = loader.load();

        BuyingFifaScriptScreenController controller = loader.getController();
        controller.setMainController(mainController);
        mainController.setScreen(pane);
    }

    private void setTableFromObservableList(ObservableList<Clicker> clickerObservableList) {
        clickerTable.setItems(clickerObservableList);
    }

    private void copyArrayToObservableList(List<Clicker> clickerList, ObservableList<Clicker> clickerObservableList) {
        clickerObservableList.addAll(clickerList);
    }

    private void fulfillTable(){
        List<Clicker> clickerList = getClickerActions();
        ObservableList<Clicker> clickerObservableList = FXCollections.observableArrayList();
        copyArrayToObservableList(clickerList, clickerObservableList);
        setTableFromObservableList(clickerObservableList);
    }

    private void setUpColumns(){
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcX.setCellValueFactory(new PropertyValueFactory<>("x"));
        tcY.setCellValueFactory(new PropertyValueFactory<>("y"));
        tcDelay.setCellValueFactory(new PropertyValueFactory<>("delayAfterAction"));
        tcKey.setCellValueFactory(new PropertyValueFactory<>("key"));
    }

    public void initializeActionsTable(){
        clickerTable.setEditable(true);
        tcName.setCellFactory(TextFieldTableCell.forTableColumn());
        tcDelay.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tcX.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tcY.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        setUpColumns();
        fulfillTable();
    }


    public void changeNameCellEvent(TableColumn.CellEditEvent c) {
        Clicker clickerSelected =  clickerTable.getSelectionModel().getSelectedItem();
        clickerSelected.setName(c.getNewValue().toString());
    }

    public void changeDelayCellEvent(TableColumn.CellEditEvent c) {
        Clicker clickerSelected =  clickerTable.getSelectionModel().getSelectedItem();
        clickerSelected.setDelayAfterAction((int)c.getNewValue());
    }

    public void changeXCellEvent(TableColumn.CellEditEvent c) {
        Clicker clickerSelected = clickerTable.getSelectionModel().getSelectedItem();
        ((MouseClicker) clickerSelected).setX((int)c.getNewValue());
    }

    public void changeYCellEvent(TableColumn.CellEditEvent c) {
        Clicker clickerSelected = clickerTable.getSelectionModel().getSelectedItem();
        ((MouseClicker) clickerSelected).setY((int)c.getNewValue());
    }
}
