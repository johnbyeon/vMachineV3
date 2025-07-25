package view;

import java.util.Scanner;
import view.consoleControl.ConsoleColor;
import Enum.UserType;
import view.consoleControl.ScreenCleaner;
import view.consoleControl.ScreenControl;

public class MachineUserView {
    private static Scanner sc = new Scanner(System.in);
    private  ConsoleColor cc = new ConsoleColor(ConsoleColor.FONT_PURPLE,ConsoleColor.BACKGROUND_BLACK);
    public void viewMain() {

        boolean validInput = true;
        SignUserView suv = new SignUserView();
        AdminView adminView = new AdminView();
        UserType machineMenu = UserType.UNINIT;
        while (true) {
            ScreenControl.CLR();
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|      자판기 프로그램에 오신 것을 환영합니다.        |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|          1. 회원가입            2.로그인            |");
            System.out.println("+-----------------------------------------------------+");
            System.out.printf("     원하시는 메뉴를 입력하세요 : ");
            cc.ConReset();
            int menu = ScanInput.scanInt();
            switch (menu) {
                case 1:
                    suv.createUserView("회원 가입 양식을 입력하세요");
                    break;
                case 2:
                    ScreenControl.OpenScreen(ConsoleColor.FONT_YELLOW);
                    machineMenu = suv.LOGIN();
//                    System.out.println(machineMenu.toString());
                break;
                default:
            }
            if (machineMenu == UserType.ADMIN){
                System.out.println("관리자");
                adminView.adminMain();
            }else if (machineMenu == UserType.CUSTOMER){
                System.out.println("사용자");
                viewProduct();
            }
        }

    }
    public void viewProduct(){
        while (true){
            int money = 1000000;
            int price = 4000;
            int conut = 0;
            ScreenControl.OpenScreen(ConsoleColor.FONT_GREEN);
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|               판매 상품 리스트 입니다.              |");
            System.out.println("+-----------------------------------------------------+");
            System.out.printf("회원님의 현재 보유 금액 :" + String.format("%d\n",money));
            System.out.printf("구매를 원하시면 번호를 눌러주세요 : ");
            int num = ScanInput.scanInt();
            if(num == 3)
            {
                money -= price;
                System.out.println("현재 잔액은 : "+ money);
                System.out.println("구매가 완료 되었습니다.");
                return;
            }
            ScreenControl.ColorReset();
        }
    }
    public void Read() {
        ScreenControl.OpenScreen(ConsoleColor.FONT_RED,ConsoleColor.BACKGROUND_GREEN);
        System.out.println("제품을 읽어 옵니다.");
        ScreenControl.ColorReset();
    }

    public void Update() {
        ScreenControl.OpenScreen(ConsoleColor.FONT_RED,ConsoleColor.BACKGROUND_GREEN);
        System.out.println("제품을 수정합니다.");

        ScreenControl.ColorReset();
    }
}
