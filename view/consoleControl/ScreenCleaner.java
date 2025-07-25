package view.consoleControl;

public class ScreenCleaner {
    public static void ClrScreen(){
        for (int i=0; i<80; i++){
            System.out.println();
        }
    }



    public static void SysClrScreen(){
        try {
            String operatingSystem = System.getProperty("os.name"); // Check the current operating system
            //System.out.println(operatingSystem.contains("Windows"));
            if (operatingSystem.contains("Windows")) {

                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
            else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
