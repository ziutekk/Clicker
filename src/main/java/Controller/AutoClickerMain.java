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

        Clicker findPlayer = new MouseClicker(1000, Variables.X_FIND, Variables.Y_FIND, InputEvent.BUTTON1_MASK,"findPlayer");
        Clicker buyPlayer = new MouseClicker(600, Variables.X_BUY_NOW, Variables.Y_BUY_NOW, InputEvent.BUTTON1_MASK,"buyPlayer");
        Clicker confirmBuy = new MouseClicker(1000, Variables.X_CONFIRM_BUY_NOW, Variables.Y_CONFIRM_BUY_NOW, InputEvent.BUTTON1_MASK,"confirmBuy");
        Clicker back = new MouseClicker(2000, Variables.X_BACK, Variables.Y_BACK, InputEvent.BUTTON1_MASK,"back");
        Clicker prizeUp = new MouseClicker(500, Variables.X_PRIZE_UP, Variables.Y_PRIZE_UP, InputEvent.BUTTON1_MASK,"prizeUp");
        Clicker prizeDown = new MouseClicker(500, Variables.X_PRIZE_DOWN, Variables.Y_PRIZE_DOWN, InputEvent.BUTTON1_MASK,"prizeDown");
        Clicker send = new MouseClicker(900, Variables.X_SEND, Variables.Y_SEND, InputEvent.BUTTON1_MASK,"send");

        Clicker markPrize = new MouseClicker(500, Variables.X_PRIZE_PLACEHOLDER, Variables.Y_PRIZE_PLACEHOLDER, InputEvent.BUTTON1_MASK,"markPrize");

        Clicker keyZero = new KeyboardClicker(250, KeyEvent.VK_0,"Press 0");
        Clicker keyOne = new KeyboardClicker(200, KeyEvent.VK_1,"Press 1");
        Clicker keyTwo = new KeyboardClicker(250,KeyEvent.VK_2,"Press 2");
        Clicker keyThree = new KeyboardClicker( 200,KeyEvent.VK_3,"Press 3");
        Clicker keyFour = new KeyboardClicker(200,KeyEvent.VK_4,"Press 4");
        Clicker keyFive = new KeyboardClicker(200,KeyEvent.VK_5,"Press 5");
        Clicker keySix = new KeyboardClicker(200,KeyEvent.VK_6,"Press 6");
        Clicker keySeven = new KeyboardClicker(200, KeyEvent.VK_7,"Press 7");
        Clicker keyEight = new KeyboardClicker(250, KeyEvent.VK_8,"Press 8");
        Clicker keyNine = new KeyboardClicker(200, KeyEvent.VK_9,"Press 9");

        addBasicActions(algorithm, findPlayer, buyPlayer, confirmBuy, send, back);
        algorithm.addAction(prizeUp);
        algorithm.addAction(prizeUp);
        addBasicActions(algorithm, findPlayer, buyPlayer, confirmBuy ,send, back);
        algorithm.addAction(prizeDown);
        addBasicActions(algorithm, findPlayer, buyPlayer ,confirmBuy, send, back);

        algorithm.addAction(markPrize);
        addChangingPrice(algorithm, keyZero, keyZero, keyThree);
        addChangingPrice(algorithm, keyZero, keyZero, keyZero);

        algorithm.executeList(1000,3000);


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