package JavaFx.Controller;

        import Controller.ClickerContainer;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.layout.Pane;
        import javafx.scene.layout.StackPane;

public class MainController {

    private ClickerContainer clickerContainer;

    public  ClickerContainer getClickerContainer() {
        return this.clickerContainer;
    }

    public MainController() {
        clickerContainer = new ClickerContainer();
    }

    @FXML
    private StackPane mainStackPane;

    //call right after a Main.class constructor
    @FXML
    public void initialize() throws Exception{
        loadMainScreen();
    }

    void loadMainScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/ActionScreen.fxml"));
        Pane pane = loader.load();

        ActionScreenController actionController = loader.getController();
        actionController.setMainController(this);

        setScreen(pane);
        actionController.initializeActionsTable();
    }

    public void setScreen(Pane pane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }
}
