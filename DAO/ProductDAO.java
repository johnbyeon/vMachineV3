package DAO;

import DTO.ProductDTO;
import Db.MysqlConnection;
import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements CrudInterface {
    @Override
    public int insert(Object object) {
        // 결과를 돌려줄 변수
        ProductDTO cos = (ProductDTO)object;
        int result = 0;

        Connection conn = MysqlConnection.getConnection();
        // 쿼리 실어보낼 아이
        PreparedStatement psmt = null;
        // 쿼리 작성
        String sql;

        sql = "INSERT INTO prodcut(product_name, " +
                "product_display_count, " +
                "product_inventory_count, " +
                "product_price) " +
                " VALUES (?,?,?,?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, cos.getName());
            psmt.setInt(2, cos.getDisplayCount());
            psmt.setInt(3, cos.getInventoryCount());
            psmt.setInt(4, cos.getPrice());
            result = psmt.executeUpdate();
            psmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(result);
        return result;
    }

    @Override
    public int update(Object object) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<Object> getListAll() {
        System.out.println("DAO getListAll");

        // RecordSet을 하나씩 읽어서 담을 TelBook entity 리스트 선언
        List<Object> productDTOList = new ArrayList<>();

        Connection conn = MysqlConnection.getConnection();
        PreparedStatement psmt = null;
        ResultSet rs = null;

        String sql = "SELECT product_num, " +
                " product_name, " +
                " product_display_count, " +
                " product_adding_time, " +
                " product_update_time, " +
                " product_inventory_count," +
                " product_price " +
                " FROM product ORDER BY product_name";
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setNum(rs.getInt("product_num"));
                productDTO.setName(rs.getString("product_name"));
                productDTO.setDisplayCount(rs.getInt("product_display_count"));
                productDTO.setAddTime(rs.getTimestamp("product_adding_time"));
                productDTO.setUpdateTime(rs.getTimestamp("product_update_time"));
                productDTO.setInventoryCount(rs.getInt("product_inventory_count"));
                productDTO.setPrice(rs.getInt("product_price"));
                productDTOList.add(productDTO);
            }
            rs.close();
            psmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productDTOList;
    }

    @Override
    public Object getOne(Long num) {
        Connection conn = MysqlConnection.getConnection();
        PreparedStatement psmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM User WHERE cus_num = ?";
        User user = null;

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setLong(1, num);

            rs = psmt.executeQuery();
            // 갖고온 데이터를 TelBook에 담아서 리턴
            while (rs.next()) {
                user = new User();
                user.setNum(rs.getInt("cus_num"));
                user.setId(rs.getString("cus_id"));
                user.setPassword(rs.getString("cus_password"));
                user.setName(rs.getString("cus_name"));
                user.setPhone(rs.getString("cus_phone"));
                user.setMainCardNum(rs.getInt("cus_main_card_num"));
                user.setFirstDate(rs.getTimestamp("cus_first_date"));
                user.setLastDate(rs.getTimestamp("cus_last_date"));
            }
            rs.close();
            psmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    @Override
    public Object getOne(String id) {
        return null;
    }

    @Override
    public List<Object> searchKeyword(int num, String keyword) {
        return List.of();
    }

}
