package Clickers;

import java.awt.*;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Clicker {

    Integer key;
    Integer delayAfterAction;
    String name;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getDelayAfterAction() {
        return delayAfterAction;
    }

    public void setDelayAfterAction(Integer delayAfterAction) {
        this.delayAfterAction = delayAfterAction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void pressKey(Robot robot);

    public abstract void executeAction(Robot robot);

}
