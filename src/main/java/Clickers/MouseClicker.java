package Clickers;

import Static.Variables;
import java.awt.Robot;

public class MouseClicker extends Clicker {

    private Integer x;
    private Integer y;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public MouseClicker(int delayAfterAction, int x, int y, int key, String name) {
        this.delayAfterAction = delayAfterAction;
        this.x = x;
        this.y = y;
        this.key = key;
        this.name = name;
    }

    @Override
    void pressKey(Robot robot) {
        try {
            robot.mousePress(this.key);
            robot.delay(50);
            robot.mouseRelease(this.key);
            robot.delay(this.delayAfterAction + Variables.getRandomDelay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void moveCursor(Robot robot) {
        robot.mouseMove(this.x + Variables.getRandomCoordinate(), this.y + Variables.getRandomCoordinate());
    }

    @Override
    public void executeAction(Robot robot){
        moveCursor(robot);
        pressKey(robot);
    }
}