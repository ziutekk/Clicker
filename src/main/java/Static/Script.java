package Static;

import Clickers.Clicker;
import Clickers.KeyboardClicker;
import Clickers.MouseClicker;

import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Script {

    private List<Clicker> clickerActions;

    public List<Clicker> getClickerActions() {
        return this.clickerActions;
    }

    public Script(String script, String price){
        if(script.equals("buying")){
            clickerActions = createBuyingScript(price);
        }
    }

    public List<Clicker> createBuyingScript(String price) {
        clickerActions = new ArrayList<>();

        Clicker findPlayer = new MouseClicker(800, Variables.X_FIND, Variables.Y_FIND, InputEvent.BUTTON1_MASK, "find player");
        Clicker buyPlayer = new MouseClicker(500, Variables.X_BUY_NOW, Variables.Y_BUY_NOW, InputEvent.BUTTON1_MASK, "buy player");
        Clicker confirmBuy = new MouseClicker(700, Variables.X_CONFIRM_BUY_NOW, Variables.Y_CONFIRM_BUY_NOW, InputEvent.BUTTON1_MASK, "confirm buy");
        Clicker back = new MouseClicker(1000, Variables.X_BACK, Variables.Y_BACK, InputEvent.BUTTON1_MASK, "back");
        Clicker prizeUp = new MouseClicker(400, Variables.X_PRIZE_UP, Variables.Y_PRIZE_UP, InputEvent.BUTTON1_MASK, "prize up");
        Clicker send = new MouseClicker(800, Variables.X_SEND, Variables.Y_SEND, InputEvent.BUTTON1_MASK, "send to transfer list");
        Clicker markPrize = new MouseClicker(400, Variables.X_PRIZE_PLACEHOLDER, Variables.Y_PRIZE_PLACEHOLDER, InputEvent.BUTTON1_MASK, "mark prize");

        clickerActions.add(markPrize);
        clickerActions.addAll(returnPriceClickers(price));
        addSnipeActions(clickerActions, findPlayer, buyPlayer, confirmBuy, send, back);
        clickerActions.add(prizeUp);
        addSnipeActions(clickerActions, findPlayer, buyPlayer, confirmBuy ,send, back);
        clickerActions.add(prizeUp);
        addSnipeActions(clickerActions, findPlayer, buyPlayer, confirmBuy ,send, back);

        return clickerActions;
    }

    public void addSnipeActions(List<Clicker> algorithm,
                                       Clicker findPlayer,
                                       Clicker buyPlayer,
                                       Clicker confirmBuy,
                                       Clicker send,
                                       Clicker back){
        algorithm.add(findPlayer);
        algorithm.add(buyPlayer);
        algorithm.add(confirmBuy);
        algorithm.add(send);
        algorithm.add(back);
    }

    private List<Clicker> returnPriceClickers(String price){
        HashMap<String, Integer> keys = Variables.fulfillKeyboardKeysMap();
        List<Clicker> priceList = new ArrayList<>();

        String digit;
        Clicker clicker;
        for(int i = 0; i < price.length(); i++){
            digit = price.substring(i,i+1);
            clicker = new KeyboardClicker(200, keys.get(digit),"press " + digit);
            priceList.add(clicker);
        }
        return priceList;
    }
}
