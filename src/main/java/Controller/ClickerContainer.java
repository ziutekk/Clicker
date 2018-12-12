package Controller;

import Clickers.Clicker;
import Static.Script;

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

    public void insertScript(Script script){
        clickerActions.clear();
        clickerActions.addAll(script.getClickerActions());
    }

    public void addAction(Clicker clicker){
        clickerActions.add(clicker);
    }

    public void deleteAction(Clicker toDelete){
        for (Clicker c: clickerActions) {
            if(toDelete.equals(c)){
                clickerActions.remove(toDelete);
                break;
            }
        }
    }

    public void executeList(int timesOfExecution, int delay){
        robot.delay(delay);
       for(int i = 0; i < timesOfExecution; i++){
           for(Clicker action: clickerActions){
               action.executeAction(robot);
           }
       }
    }
}
