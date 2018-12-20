package Controller;

import Clickers.Clicker;
import Static.Script;
import com.sun.webkit.dom.KeyboardEventImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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

    public void deleteAction(Clicker toDelete, int indexToDelete){

        for (int i =0; i < clickerActions.size(); i++) {
            if(toDelete.equals(clickerActions.get(i)) && indexToDelete == i){
                clickerActions.remove(i);
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
           System.out.println(i+1);
       }
    }

    public void moveClicker(int clickerIndex, String direction){
        Clicker save;
        int indexToMove;
        if(clickerActions.size() > 0){
            if(direction.equals("down") && clickerIndex != clickerActions.size()-1){
                save = clickerActions.get(clickerIndex+1);
                clickerActions.set(clickerIndex + 1, clickerActions.get(clickerIndex));
                clickerActions.set(clickerIndex, save);

            }
            else if(direction.equals("up") && clickerIndex != 0){
                save = clickerActions.get(clickerIndex-1);
                clickerActions.set(clickerIndex - 1, clickerActions.get(clickerIndex));
                clickerActions.set(clickerIndex, save);
            }
        }
    }
}
