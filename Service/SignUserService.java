package Service;

import DAO.CrudInterface;
import DAO.UserDAO;
import DTO.UserDTO;

import Entity.User;
import Enum.UserType;

public class SignUserService {
    CrudInterface customerDAO = new UserDAO();
    public void input(UserDTO dto) {
//		System.out.println("데이터 입력 처리 서비스");

        int result = customerDAO.insert(UserDTO.fromDto(dto));
        if(result > 0) {
            System.out.println("저장되었습니다.");
        } else {
            System.out.println("저장에 실패했습니다.");
        }
    }
    public void update(UserDTO dto){
        int result = customerDAO.update(UserDTO.fromDto(dto));
        if(result > 0) {
            System.out.println("저장되었습니다.");
        } else {
            System.out.println("저장에 실패했습니다.");
        }
    }
    public UserDTO searchId(String id) {
//		System.out.println("아이디 검색 처리화면 서비스");
        User user = (User)(customerDAO.getOne(id));
        System.out.println(user.toString());
        if(user == null) {
            System.out.println("자료 없음");
            return null;
        } else {

            return  UserDTO.fromEntity((User) customerDAO.getOne(id));
        }
    }

    public UserType LOGIN(String id, String pw){
        UserDTO cDto = searchId(id);
        String pwEnc = "";
        try {
            pwEnc = SHA256.encrypt(pw);
        } catch (Exception e) {
            System.out.println("로그인 패스워드 암호화 실패 : " +  e.getMessage());
            return UserType.UNKNOWN;
        }
        if(id.equals("admin") && cDto.getPassword().equals(pwEnc))
        {
            int num = ((UserDAO) customerDAO).updateLastDate(cDto.getNum());
            return UserType.ADMIN;
        }else if (cDto.getPassword().equals(pwEnc)){
            int num = ((UserDAO) customerDAO).updateLastDate(cDto.getNum());
            return UserType.CUSTOMER;
        }else {
            return UserType.UNKNOWN;
        }
    }
}
