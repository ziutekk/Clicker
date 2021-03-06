package Static;

import java.util.HashMap;


import static java.awt.event.KeyEvent.*;

public class Variables {

    public static Integer X_FIND = 1182;
    public static Integer Y_FIND = 920;

    public static Integer X_BUY_NOW = 1700;
    public static Integer Y_BUY_NOW = 685;

    public static Integer X_CONFIRM_BUY_NOW = 1006;
    public static Integer Y_CONFIRM_BUY_NOW = 637;

    public static Integer X_BACK = 92;
    public static Integer Y_BACK = 180;

    public static Integer X_PRIZE_UP = 1301;
    public static Integer Y_PRIZE_UP = 700;

    public static Integer X_PRIZE_DOWN = 1023;
    public static Integer Y_PRIZE_DOWN = 700;

    public static Integer X_SEND = 1698;
    public static Integer Y_SEND = 728;

    public static Integer X_PRIZE_PLACEHOLDER = 1160;
    public static Integer Y_PRIZE_PLACEHOLDER = 700;

    private static int getRandomNumber(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return (int)x;
    }

    public static int getRandomDelay(){
        return getRandomNumber(-50, 50);
    }

    public static int getRandomCoordinate(){
        return getRandomNumber(-5, 5);
    }


    public static HashMap<String, Integer> fulfillKeyboardKeysMap(){
        HashMap<String, Integer> keys = new HashMap<>();
        keys.put("0", VK_0);
        keys.put("1", VK_1);
        keys.put("2", VK_2);
        keys.put("3", VK_3);
        keys.put("4", VK_4);
        keys.put("5", VK_5);
        keys.put("6", VK_6);
        keys.put("7", VK_7);
        keys.put("8", VK_8);
        keys.put("9", VK_9);
        return keys;
    }

    public static HashMap<String, Integer> fulfillMouseKeysMap(){
        HashMap<String, Integer> keys = new HashMap<>();
        keys.put("Left Click", BUTTON1_MASK);
        keys.put("Right Click", BUTTON2_MASK);
        return keys;
    }
}
