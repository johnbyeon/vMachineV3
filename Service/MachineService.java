package Service;

import DAO.CrudInterface;
import DAO.ProductDAO;
import DTO.UserDTO;

public class MachineService {
    CrudInterface dao = new ProductDAO();
    public void input(UserDTO dto) {
//		System.out.println("데이터 입력 처리 서비스");
        int result = dao.insert(UserDTO.fromDto(dto));
        if(result > 0) {
            System.out.println("저장되었습니다.");
        } else {
            System.out.println("저장에 실패했습니다.");
        }
    }

    public void update(){

    }
    public void finditem(){

    }

}
