package Service;

import DAO.UserDAO;
import DAO.ProductDAO;
import DTO.UserDTO;
import DTO.ProductDTO;
import Entity.User;
import Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    UserDAO userDAO = new UserDAO();
    ProductDAO productDAO = new ProductDAO();
    public List<Product> allProductFined(){
        List<Object> objectList = productDAO.getListAll();
        if(objectList == null) return null;
        List<Product> productList = new ArrayList<>();
        for(Object o:objectList) {
            Product prud  = ProductDTO.fromDto((ProductDTO)o);
            productList.add(prud);
        }

        return  productList;
    }
    public List<User> allUserFind() {
        List<Object> objectList = userDAO.getListAll();
        if(objectList == null) return null;
        List<User> userList = new ArrayList<>();
        for(Object o:objectList) {
            User cus  = UserDTO.fromDto((UserDTO)o);
            userList.add(cus);
        }
        return userList;

    }
    public void productInput(ProductDTO dto) {
//		System.out.println("데이터 입력 처리 서비스");

        int result = productDAO.insert(ProductDTO.fromDto(dto));
        if(result > 0) {
            System.out.println("저장되었습니다.");
        } else {
            System.out.println("저장에 실패했습니다.");
        }
    }

    public List<User> findKeyWord(int keyNum, String userName){
        List<Object> objectList = userDAO.searchKeyword(keyNum,userName);
        if(objectList == null) return null;
        List<User> userList = new ArrayList<>();
        for(Object o:objectList) {
            User cus  = UserDTO.fromDto((UserDTO)o);
            userList.add(cus);
        }
        return userList;
    }
    public User findUserNum(int keyNum){
        Long objL = Long.valueOf(keyNum);
        Object object = userDAO.getOne(objL);
        if(object == null) return null;
        else
        return (User)object;
    }

}
