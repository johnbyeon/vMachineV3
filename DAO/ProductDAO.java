package DAO;

import DTO.ProductDTO;
import Db.MysqlConnection;
import Entity.Product;
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
        ProductDTO cos = (ProductDTO) object;
        int result = 0;

        Connection conn = MysqlConnection.getConnection();
        // 쿼리 실어보낼 아이
        PreparedStatement psmt = null;
        // 쿼리 작성
        String sql;

        sql = "INSERT INTO " + Product.Table.TABLE_NAME + "(" +
                Product.Column.NAME + ", " +
                Product.Column.DISPLAY_COUNT + ", " +
                Product.Column.INVENTORY_COUNT + ", " +
                Product.Column.PRICE + ") " +
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

        String sql = "SELECT " + Product.Column.NUM + ", " +
                Product.Column.NAME + ", " +
                Product.Column.DISPLAY_COUNT + ", " +
                Product.Column.ADD_TIME + ", " +
                Product.Column.UPDATE_TIME + ", " +
                Product.Column.INVENTORY_COUNT + ", " +
                Product.Column.PRICE +
                " FROM " + Product.Table.TABLE_NAME + " ORDER BY " + Product.Column.NAME;
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setNum(rs.getInt(Product.Column.NUM));
                productDTO.setName(rs.getString(Product.Column.NAME));
                productDTO.setDisplayCount(rs.getInt(Product.Column.DISPLAY_COUNT));
                productDTO.setAddTime(rs.getTimestamp(Product.Column.ADD_TIME));
                productDTO.setUpdateTime(rs.getTimestamp(Product.Column.UPDATE_TIME));
                productDTO.setInventoryCount(rs.getInt(Product.Column.INVENTORY_COUNT));
                productDTO.setPrice(rs.getInt(Product.Column.PRICE));
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

        String sql = "SELECT * FROM " + Product.Table.TABLE_NAME +
                " WHERE " + Product.Column.NUM + " = ?";
        Product product = null;

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setLong(1, num);

            rs = psmt.executeQuery();
            // 갖고온 데이터를 TelBook에 담아서 리턴
            while (rs.next()) {
                product = new Product();
                product.setNum(rs.getInt(Product.Column.NUM));
                product.setName(rs.getString(Product.Column.NAME));
                product.setPrice(rs.getInt(Product.Column.PRICE));
                product.setAddTime(rs.getTimestamp(Product.Column.ADD_TIME));
                product.setUpdateTime(rs.getTimestamp(Product.Column.UPDATE_TIME));
                product.setDisplayCount(rs.getInt(Product.Column.DISPLAY_COUNT));
                product.setInventoryCount(rs.getInt(Product.Column.INVENTORY_COUNT));
            }
            rs.close();
            psmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
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
