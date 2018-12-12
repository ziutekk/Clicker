package Controller;

import Clickers.Clicker;
import Clickers.KeyboardClicker;
import Clickers.MouseClicker;
import Static.Variables;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AutoClickerMain {

    public static void main(String[] args){
        ClickerContainer algorithm = new ClickerContainer();

        Clicker findPlayer = new MouseClicker(800, Variables.X_FIND, Variables.Y_FIND, InputEvent.BUTTON1_MASK,"findPlayer");
        Clicker buyPlayer = new MouseClicker(500, Variables.X_BUYNOW, Variables.Y_BUYNOW, InputEvent.BUTTON1_MASK,"findPlayer");
        Clicker confirmBuy = new MouseClicker(700, Variables.X_CONFIRM_BUYNOW, Variables.Y_CONFIRM_BUYNOW, InputEvent.BUTTON1_MASK,"findPlayer");
        Clicker back = new MouseClicker(1000, Variables.X_BACK, Variables.Y_BACK, InputEvent.BUTTON1_MASK,"findPlayer");
        Clicker prizeUp = new MouseClicker(400, Variables.X_PRIZEUP, Variables.Y_PRIZEUP, InputEvent.BUTTON1_MASK,"findPlayer");
        Clicker prizeDown = new MouseClicker(400, Variables.X_PRIZEDOWN, Variables.Y_PRIZEDOWN, InputEvent.BUTTON1_MASK,"findPlayer");
        Clicker send = new MouseClicker(800, Variables.X_SEND, Variables.Y_SEND, InputEvent.BUTTON1_MASK,"findPlayer");

        Clicker markPrize = new MouseClicker(400, Variables.X_PRIZE_PLACEHOLDER, Variables.Y_PRIZE_PLACEHOLDER, InputEvent.BUTTON1_MASK,"findPlayer");

        Clicker keyZero = new KeyboardClicker(200, KeyEvent.VK_0,"findPlayer");
        Clicker keyOne = new KeyboardClicker(200, KeyEvent.VK_1,"findPlayer");
        Clicker keyTwo = new KeyboardClicker(200,KeyEvent.VK_2,"findPlayer");
        Clicker keyThree = new KeyboardClicker(200,KeyEvent.VK_3,"findPlayer");
        Clicker keyFour = new KeyboardClicker(200,KeyEvent.VK_4,"findPlayer");
        Clicker keyFive = new KeyboardClicker(200,KeyEvent.VK_5,"findPlayer");
        Clicker keySix = new KeyboardClicker(200,KeyEvent.VK_6,"findPlayer");
        Clicker keySeven = new KeyboardClicker(200, KeyEvent.VK_7,"findPlayer");
        Clicker keyEight = new KeyboardClicker(200, KeyEvent.VK_8,"findPlayer");
        Clicker keyNine = new KeyboardClicker(200, KeyEvent.VK_9,"findPlayer");

        addBasicActions(algorithm, findPlayer, buyPlayer, confirmBuy, send, back);
        algorithm.addAction(prizeUp);
        algorithm.addAction(prizeUp);
        addBasicActions(algorithm, findPlayer, buyPlayer, confirmBuy ,send, back);
        algorithm.addAction(prizeDown);
        addBasicActions(algorithm, findPlayer, buyPlayer ,confirmBuy, send, back);

        algorithm.addAction(markPrize);
        addChangingPrice(algorithm, keyZero, keyZero, keyOne);
        addChangingPrice(algorithm, keyZero, keyZero, keyZero);

        algorithm.executeList(1000);
    }

    public static void addBasicActions(ClickerContainer algorithm,
                                       Clicker findPlayer,
                                       Clicker buyPlayer,
                                       Clicker confirmBuy,
                                       Clicker send,
                                       Clicker back){
        algorithm.addAction(findPlayer);
        algorithm.addAction(buyPlayer);
        algorithm.addAction(confirmBuy);
        algorithm.addAction(send);
        algorithm.addAction(back);
    }

    public static void addChangingPrice(ClickerContainer algorithm,
                                        Clicker firstDigit,
                                        Clicker secondDigit,
                                        Clicker thirdDigit){

        algorithm.addAction(firstDigit);
        algorithm.addAction(secondDigit);
        algorithm.addAction(thirdDigit);

    }
}