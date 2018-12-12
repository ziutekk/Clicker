package Clickers;

import Static.Variables;
import java.awt.*;

public class KeyboardClicker extends Clicker {

    public KeyboardClicker(int delayAfterAction, int key, String name){
        this.delayAfterAction = delayAfterAction;
        this.key = key;
        this.name = name;
    }

    @Override
    void pressKey(Robot robot) {
        try {
            robot.keyPress(this.key);
            robot.delay(100);
            robot.keyRelease(this.key);
            robot.delay(this.delayAfterAction + Variables.getRandomDelay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeAction(Robot robot) {
        pressKey(robot);
    }
}
