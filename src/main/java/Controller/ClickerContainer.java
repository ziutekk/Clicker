package Controller;

import Clickers.Clicker;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClickerContainer {

    private static List<Clicker> clickerActions;
    private Robot robot;

    public static List<Clicker> getClickerActions() {
        return clickerActions;
    }

    public ClickerContainer(){
        clickerActions = new ArrayList<>();
        try {
            this.robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAction(Clicker clicker){
        clickerActions.add(clicker);
    }

    public void executeList(int timesOfExecution){

       for(int i = 1; i < timesOfExecution; i++){
           for(Clicker action: clickerActions){
               action.executeAction(robot);
           }
           System.out.println(i);
       }
    }
}
