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
        String name = null;
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
        String phone = null;
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
        System.out.println(keyword);
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
        boolean isChange = false;

        int cardNum = userDTO.getMainCardNum();
        if (reNew("아이디 : " + userDTO.getId()) == true) {
            while (true) {
                userId = checkUser();
                if (userId != null) {
                    isChange = true;
                    break;
                }
            }
        } else {
            userId = userDTO.getId();
        }
        if (reNew("이름 : " + userDTO.getName())) {
            while (true){
                name = checkName();
                if (name != null) {
                    isChange = true;
                    break;
                }
            }
        } else {
            name = userDTO.getName();
        }
        if (reNew("전화번호 : " + userDTO.getPhone())) {
            while (true){
                phone = checkPhone();
                if (phone != null) {
                    isChange = true;
                    break;
                }
            }
        } else {
            phone = userDTO.getPhone();
        }
        ScreenControl.ColorReset();
        if (isChange == true){
            signUserService.update(UserDTO
                    .makeDto(userDTO.getNum(), userId, password, name, phone, cardNum , userDTO.getFirstDate(),userDTO.getLastDate()));

        }else {
            System.out.println("변경된 내용이 없어서 처음으로 돌아갑니다.");

        }
        try {
            Thread.sleep(1500);
        }catch (Exception e){
            System.out.println("정지 화면 유지 실패");
        }


    }

    public void deleteUserView(int record) {
        ScreenControl.CLR();
        signUserService.delete(record);
    }

}
