package view;

import DTO.UserDTO;
import Entity.User;
import Entity.Product;
import Service.MachineService;
import view.consoleControl.ConsoleColor;
import Service.AdminService;
import view.consoleControl.ScreenCleaner;
import view.consoleControl.ScreenControl;

import java.io.IOException;
import java.util.List;

import Enum.SearchType;
import Enum.CrudType;

public class AdminView {
    AdminService adminService = new AdminService();

    public int AllUserView(int mode) {
        //System.out.println("관리자가 모든 회원정보를 읽어옵니다.");
        List<User> userList = adminService.allUserFind();
        return printCustomers(userList, mode);
    }
    public int AllProductView(int mode) {
        //System.out.println("관리자가 모든 회원정보를 읽어옵니다.");
        MachineUserView muv = new MachineUserView();
        List<Product> productList = adminService.allProductFined();


        return printProducts(productList, mode);
    }
    public void createProductView(){
        MachineUserView muv = new MachineUserView();
        muv.createProductView("|                 상품 등록 페이지                    |");
    }
    public void createUserView() {
        ScreenControl.ColorSetScreen(ConsoleColor.FONT_BLUE);
        SignUserView suv = new SignUserView();
        suv.createUserView("|                    회원 등록                        |");


    }


    public void readUserView() {
        while (true) {
            ScreenControl.OpenScreen(ConsoleColor.FONT_BLUE);
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|                     회원 관리                       |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.println("|   1. 회원 아이디 검색   |    2.  회원 이름 검색     |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.println("|   3.    돌아가기        |                           |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.printf("회원정보를 검색할 방법을 입력 : ");
            int num = ScanInput.scanInt();
            String name = "";
            switch (num) {
                case SearchType.USER_ID:
                    name = "아이디를";
                    break;
                case SearchType.USER_NAME:
                    name = "이름을";
                    break;
                case 3:
                    return;
                default:
                    continue;
            }
            System.out.printf("검색할 " + name + " 입력하세요 : ");
            String keyword = ScanInput.scanStr();
            List<User> userList = adminService.findKeyWord(num, keyword);
            if (!userList.iterator().hasNext()) {
                System.out.println("데이터가 없습니다.");
                ScreenControl.ColorReset();
                try {
                    Thread.sleep(1500);
                } catch (Exception e) {
                    System.out.println("정지 화면 유지 실패");
                }
                return;
            }
            printCustomers(userList, CrudType.NORMAL);
        }


    }

    public int printProducts(List<Product> productList, int mode) {
        System.out.println("|  제품 번호  |  제품 이름  |  제품 갯수  | \t회원 전화번호\t | \t\t보유금액\t\t | \t\t\t가입 날짜\t\t\t | \t\t마지막 로그인\t\t |");
        for (Product product : productList) {
            if (product.getDisplayCount() > 0)
                ScreenControl.ColorSetScreen(ConsoleColor.FONT_GREEN);
            else
                ScreenControl.ColorSetScreen(ConsoleColor.FONT_RED);
            System.out.printf("|\t\t%4d  \t|" +
                            "\t %s \t|" +
                            "\t %10d \t|" +
                            "\t%s\t|" +
                            "\t%s\t|" +
                            "\t%10d\t|" +
                            "\t%10d\t|\n",
                    product.getNum(),
                    product.getName(),
                    product.getDisplayCount(),
                    product.getAddTime().toString(),
                    product.getUpdateTime().toString(),
                    product.getInventoryCount(),
                    product.getPrice()
            );
            ScreenControl.ColorReset();
        }

        switch (mode) {
            case CrudType.UPDATE:
                System.out.printf("변경할 제품번호를 입력하세요 : ");
                ScreenControl.ColorReset();
                int record = ScanInput.scanInt();
                return record;
            case CrudType.DELETE:
                System.out.printf("삭제할 제품번호를 입력하세요 : ");
                ScreenControl.ColorReset();
                int record1 = ScanInput.scanInt();
                return record1;
            case CrudType.NORMAL:
                System.out.printf("이전메뉴로 돌아가려면 엔터 입력 : ");
                ScreenControl.ColorReset();
                try {
                    System.in.read();
                } catch (IOException e) {
                }
                return 0;
            default:
                return 0;
        }
    }


    public int printCustomers(List<User> userList, int mode) {
        System.out.println("|  회원 번호  |  회원 아이디  |  회원 이름  | \t회원 전화번호\t | \t\t보유금액\t\t | \t\t\t가입 날짜\t\t\t | \t\t마지막 로그인\t\t |");
        for (User user : userList) {
            System.out.printf("|\t\t%3d  \t|" +
                            "\t %s \t|" +
                            "\t %s \t|" +
                            "\t%s\t|" +
                            "\t%15d\t|" +
                            "\t%s\t|" +
                            "\t%s\t|\n",
                    user.getNum(),
                    user.getId(),
                    user.getName(),
                    user.getPhone(),
                    user.getMainCardNum(),
                    user.getFirstDate().toString(),
                    user.getLastDate().toString()
            );
        }
        switch (mode) {
            case CrudType.UPDATE:
                System.out.printf("변경할 회원번호를 입력하세요 : ");
                ScreenControl.ColorReset();
                int record = ScanInput.scanInt();
                return record;
            case CrudType.DELETE:
                System.out.printf("삭제할 회원번호를 입력하세요 : ");
                ScreenControl.ColorReset();
                int record1 = ScanInput.scanInt();
                return record1;
            case CrudType.NORMAL:
                System.out.printf("이전메뉴로 돌아가려면 엔터 입력 : ");
                ScreenControl.ColorReset();
                try {
                    System.in.read();
                } catch (IOException e) {
                }
                return 0;
            default:
                return 0;
        }

    }

    public void updateUserView() {
        ScreenControl.ColorSetScreen(ConsoleColor.FONT_YELLOW);
        int record = AllUserView(CrudType.UPDATE);
        SignUserView suv = new SignUserView();
        User user = adminService.findUserNum(record);
        suv.updateUserView(UserDTO.fromEntity(user));

    }

    public void deletUserView() {
        ScreenControl.ColorSetScreen(ConsoleColor.FONT_CYAN);
        int record = AllUserView(CrudType.DELETE);
        SignUserView suv = new SignUserView();
        User user = adminService.findUserNum(record);
        if (user == null) {
            System.out.println("데이터가 잘못되었습니다.");
            try {
                Thread.sleep(1500);
            } catch (Exception e) {
                System.out.println("정지 화면 유지 실패");
            }
        } else {
            suv.deleteUserView(record);
            try {
                Thread.sleep(1500);
            } catch (Exception e) {
                System.out.println("정지 화면 유지 실패");
            }
        }
    }

    public void customerMainView() {
        while (true) {
            ScreenControl.OpenScreen(ConsoleColor.FONT_PURPLE);
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|                     회원 관리                       |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.println("|   1. 회원 리스트 보기   |    2.  회원 검색 하기     |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.println("|   3. 회원 등록 하기     |    4.  회원 수정 하기     |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.println("|   5. 회원 삭제 하기     |    6. 이전메뉴 돌아가기   |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.print("원하시는 메뉴 번호를 입력하세요 : ");
            ScreenControl.ColorReset();
            int pageNum = ScanInput.scanInt();
            switch (pageNum) {
                case 1:
                    AllUserView(CrudType.NORMAL);
                    break;
                case 2:
                    readUserView();
                    break;
                case 3:
                    createUserView();
                    break;
                case 4:
                    updateUserView();
                    break;
                case 5:
                    deletUserView();
                    break;
                case 6:
                    return;
            }
        }

    }

    public void allProductFined() {
        ScreenControl.CLR();
        System.out.println("관리자가 모든 회원정보를 읽어옵니다.");
        List<Product> productList = adminService.allProductFined();
        printProducts(productList, CrudType.NORMAL);
    }


    public void productMainview() {
        while (true) {
            ScreenControl.OpenScreen(ConsoleColor.FONT_PURPLE);
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|                    제품  페이지                     |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.println("|   1. 제품 리스트 보기   |   2.  제품 검색 하기      |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.println("|   3.  제품 등록 하기    |   4.  제품 수정 하기      |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.println("|   5.  제품 삭제 하기    |   6. 이전메뉴 돌아가기    |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.print("원하시는 메뉴 번호를 입력하세요 : ");
            ScreenControl.ColorReset();
            int pageNum = ScanInput.scanInt();
            switch (pageNum) {
                case 1:
                    allProductFined();
                    break;
                case 2:
                    readProductView();
                    break;
                case 3:
                    createProductView();
                    break;
                case 4:
                    updateProductView();
                    break;
                case 5:
                    deleteProductView();
                    break;
                case 6:
                    return;
            }
        }
    }

    public void showAcounttingBook() {
        ScreenControl.OpenScreen(ConsoleColor.FONT_WHITE);
        System.out.println("관리자가 판매 리스트를 확인합니다.");

    }

    public void createProductView() {
        ScreenControl.OpenScreen(ConsoleColor.FONT_CYAN);
        MachineUserView muv = new MachineUserView();
        muv.

    }

    public void readProductView() {
        ScreenControl.OpenScreen(ConsoleColor.FONT_RED);
        System.out.println("관리자가 제품정보를 읽어옵니다.");

    }

    public void updateProductView() {
        ScreenControl.OpenScreen(ConsoleColor.FONT_GREEN);
        System.out.println("관리자가 제품정보를 수정합니다.");
        ScreenControl.ColorReset();
    }

    public void deleteProductView() {
        ScreenCleaner.ClrScreen();
        System.out.println("관리자가 제품정보를 삭제합니다.");
    }

    public void adminMain() {
        while (true) {
            String consolColor = ConsoleColor.FONT_WHITE;
            String consoleBackColor = ConsoleColor.BACKGROUND_BLACK;
            String consolReset = ConsoleColor.RESET;
            System.out.printf(consoleBackColor + consolColor);
            ScreenCleaner.ClrScreen();
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|                   관리자  페이지                    |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.println("|    1. 제품 관리 하기    |     2. 회원 관리 하기     |");
            System.out.println("+-------------------------+---------------------------+");
            System.out.println("|    3. 판매내역 보기     |     4.   로그 아웃        |");
            System.out.println("+-----------------------------------------------------+");
            System.out.print("원하시는 메뉴 번호를 입력하세요 : ");
            System.out.printf(consolReset);
            int pageNum = ScanInput.scanInt();
            switch (pageNum) {
                case 1:
                    productMainview();
                    break;
                case 2:
                    customerMainView();
                    break;
                case 3:
                    showAcounttingBook();
                    break;
                case 4:
                    return;
            }
        }


    }
}
