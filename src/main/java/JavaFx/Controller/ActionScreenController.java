package JavaFx.Controller;

import Clickers.Clicker;
import Clickers.MouseClicker;
import Static.Variables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.awt.event.InputEvent;
import java.util.List;


import static Controller.ClickerContainer.getClickerActions;

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
    public void openCreationActionWindow() throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddMouseActionScreen.fxml"));
        Pane pane = loader.load();

        AddMouseActionScreenController addMouseActionControllerScreen = loader.getController();
        addMouseActionControllerScreen.setMainController(mainController);
        mainController.setScreen(pane);
    }

    public void getClickers(){

        List<Clicker> clickerList = getClickerActions();
        System.out.println(clickerList.size());
        ObservableList<Clicker> clickerObservableList = FXCollections.observableArrayList();
        clickerObservableList.add(new MouseClicker(800, Variables.X_FIND, Variables.Y_FIND, InputEvent.BUTTON1_MASK,"findPlayer"));

        copyArrayToObservableList(clickerList, clickerObservableList);
        System.out.println(clickerObservableList.size());


        setTableFromObservableList(clickerObservableList);
    }

    private void setTableFromObservableList(ObservableList<Clicker> clickerObservableList) {
        clickerTable.setItems(clickerObservableList);
    }

    private void copyArrayToObservableList(List<Clicker> clickerList, ObservableList<Clicker> clickerObservableList) {
        clickerObservableList.addAll(clickerList);
    }


    private void setUpColumns(){
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcX.setCellValueFactory(new PropertyValueFactory<>("x"));
        tcY.setCellValueFactory(new PropertyValueFactory<>("y"));
        tcDelay.setCellValueFactory(new PropertyValueFactory<>("delayAfterAction"));
        tcKey.setCellValueFactory(new PropertyValueFactory<>("key"));
    }

    public void initializeActionsTable(){
        setUpColumns();
        getClickers();
    }
}
