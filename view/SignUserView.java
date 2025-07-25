package view;

import DAO.UserDAO;
import DTO.UserDTO;
import Entity.User;
import Service.SHA256;
import Service.SignUserService;
import exception.InputValidation;
import exception.MyException;
import Enum.UserType;
import view.consoleControl.ConsoleColor;
import view.consoleControl.ScreenControl;

import java.sql.Timestamp;

public class SignUserView {
    ConsoleColor cc = new ConsoleColor();
    InputValidation validation = new InputValidation();
    UserDAO userDAO = new UserDAO();
    SignUserService signUserService = new SignUserService();
    AdminView adminView = new AdminView();

    private String checkName() {
        boolean checkName = true;
        String name = "";
        do {
            try {
                System.out.println("이름을 입력하세요 (15자내외)");
                name = ScanInput.scanStr();
                if (name.length() <= 15) {
                    validation.nameCheck(name);
                    checkName = false;
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        } while (checkName);
        return name;
    }

    private String checkPhone() {
        boolean check = true;
        String phone = "";
        do {
            try {
                System.out.println("전화번호를 입력하세요 : ");
                phone = ScanInput.scanStr();
                validation.phoneCheck(phone);
                check = false;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return phone;
    }

    private String checkPassword() {
        String userpw;
        String userpwcheck;
        while (true) {
            System.out.print("비밀번호 입력하세요 : ");
            userpw = ScanInput.scanStr();
            System.out.print("비밀번호가 다른지 확인을 위해 다시 입력하세요 : ");
            userpwcheck = ScanInput.scanStr();
            if (userpw.equals(userpwcheck)) {
                try {
                    String newUserpw = SHA256.encrypt(userpw);
                    return newUserpw;
                } catch (Exception e) {
                    System.out.println("비밀번호 변환 실패  : " + e.getMessage());
                }
            } else {
                System.out.println("비밀번호가 서로 다릅니다.");
                if (yesOrNot() == false) {
                    return null;
                }
            }
        }
    }

    public boolean yesOrNot() {
        while (true) {
            System.out.println("계속 진행할까요? (Y|N)");
            String yesOrNot = ScanInput.scanStr();
            if (yesOrNot.toUpperCase().equals("Y")) {
                return true;
            } else if (yesOrNot.toUpperCase().equals("N")) {
                return false;
            }
        }
    }

    private String checkUser() {
        while (true) {
            System.out.print("아이디를 입력하세요 : ");
            String userId = ScanInput.scanStr();
            userId = userId.toLowerCase();
            validation.idCheck(userId);
            //입력한 아이디로 체크하기
            //  customerDAO활용
            //customerDAO.serchId(userId);
            User user = (User) userDAO.getOne(userId);
            if (user == null)
                return userId;
            else {
                System.out.println("아이디가 중복 되었습니다.");
                if (yesOrNot() == false) {
                    return null;
                }
            }
        }

    }

    public void createUserView(String keyword) {
        ScreenControl.CLR();
        System.out.println("+-----------------------------------------------------+");
        System.out.println("|            " + keyword + "              |");
        System.out.println("+-----------------------------------------------------+");
        String userId = checkUser();
        if (userId == null) return;
        String password = checkPassword();
        if (password == null) return;
        String name = checkName();
        String phone = checkPhone();
        ScreenControl.ColorReset();
        Timestamp nowTimestamp = new Timestamp(System.currentTimeMillis());
        signUserService.input(UserDTO
                .makeDto(0, userId, password, name, phone, 0, nowTimestamp, nowTimestamp));
    }


    public UserType LOGIN() {
        ScreenControl.CLR();
        UserType userType = UserType.UNINIT;
        System.out.println("+-----------------------------------------------------+");
        System.out.println("|              로그인 정보를 입력하세요               |");
        System.out.println("+-----------------------------------------------------+");
        System.out.print("아이디 : ");
        String id = ScanInput.scanStr();
        id = id.toLowerCase();
        System.out.print("비밀번호 : ");
        String pw = ScanInput.scanStr();
        ScreenControl.ColorReset();
        return signUserService.LOGIN(id, pw);
    }

    public void readUserView() {
        ScreenControl.CLR();
        System.out.println("특정 회원정보를 읽어옵니다.");

    }

    public boolean reNew(String reNewMsg) {
        while (true) {
            System.out.println(reNewMsg);
            System.out.println("변경하시겠습니까?");
            String yesOrNo = ScanInput.scanStr();
            if (yesOrNo.toUpperCase().equals("Y")) {
                return true;
            } else if (yesOrNo.toUpperCase().equals("N")) {
                return false;
            }
        }
    }

    public void updateUserView(UserDTO userDTO) {
        String userId;
        String password = userDTO.getPassword();
        String name;
        String phone;
        int cardNum = userDTO.getMainCardNum();
        if (reNew("이름 : " + userDTO.getId()) == true) {
            while (true) {
                userId = checkUser();
                if (userId != null) break;
            }
        } else {
            userId = userDTO.getName();
        }
        if (reNew("이름 : " + userDTO.getName())) {
            name = checkName();
        } else {
            name = userDTO.getName();
        }
        if (reNew("전화번호 : " + userDTO.getPhone())) {
            phone = checkPhone();
        } else {
            phone = userDTO.getPhone();
        }
        ScreenControl.ColorReset();
        signUserService.update(UserDTO
                .makeDto(userDTO.getNum(), userId, password, name, phone, cardNum , userDTO.getFirstDate(),userDTO.getLastDate()));


    }

    public void deleteUserView() {
        ScreenControl.CLR();
        System.out.println("회원정보를 삭제합니다.");
    }

}
