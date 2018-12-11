package Static;

public class Variables {

    public static Integer X_FIND = 1182;
    public static Integer Y_FIND = 935;

    public static Integer X_BUYNOW = 1700;
    public static Integer Y_BUYNOW = 657;

    public static Integer X_CONFIRM_BUYNOW = 1006;
    public static Integer Y_CONFIRM_BUYNOW = 636;

    public static Integer X_BACK = 92;
    public static Integer Y_BACK = 159;

    public static Integer X_PRIZEUP = 1302;
    public static Integer Y_PRIZEUP = 684;

    public static Integer X_PRIZEDOWN = 1023;
    public static Integer Y_PRIZEDOWN = 684;

    public static Integer X_SEND = 1698;
    public static Integer Y_SEND = 712;

    public static Integer X_PRIZE_PLACEHOLDER = 1160;
    public static Integer Y_PRIZE_PLACEHOLDER = 685;

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
}
