package Clickers;

import java.awt.*;

public abstract class Clicker {

//    Robot robot;
    int key;
    int delayAfterAction;

    abstract void pressKey(Robot robot);

    public abstract void executeAction(Robot robot);

}
