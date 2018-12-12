package JavaFx.Validation;

import javafx.scene.control.TextField;

public class TextFieldValidation {

    private static boolean isInt(TextField input){
        String str = input.getText();
        try{
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isFilled(TextField input){
        return !input.getText().equals("");
    }

    public static boolean isValidInteger(TextField input){
        return isInt(input) && isFilled(input);
    }

    public static int toInt(TextField input){
        return Integer.parseInt(input.getText());
    }
}
