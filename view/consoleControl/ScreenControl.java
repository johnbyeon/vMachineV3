package view.consoleControl;

public class ScreenControl {
    public static ScreenCleaner scrnClr = new ScreenCleaner();
    public static ConsoleColor scrnCol = new ConsoleColor();

    public static void ColorSetScreen(String fontColor){
        scrnCol.setFontColor(fontColor);
    }
    public static void ColorSetScreen(String fontColor,String backColor){
        scrnCol.setFontColor(fontColor);
        scrnCol.setBackGroundColor(backColor);
    }
    public static void ColorReset(){
        scrnCol.ConReset();
    }
    public static void OpenScreen(String fontColor, String backColor){
        ColorSetScreen(fontColor,backColor);
        CLR();
    }
    public static void OpenScreen(String fontColor) {
        ColorSetScreen(fontColor);
        CLR();
    }
        public static void CLR(){
        scrnClr.ClrScreen();
    }
}
