package DAO;

import DTO.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Db.MysqlConnection;
import Entity.User;

public class UserDAO implements CrudInterface {
    public static final int USER_ID = 1;
    public static final int USER_NAME = 2;

    @Override
    public int insert(Object object) {
        // 결과를 돌려줄 변수
        User cos = (User) object;
        int result = 0;

//		System.out.println("DAO insert");
        // 전달된 telBook DB에 저장

        Connection conn = MysqlConnection.getConnection();
        // 쿼리 실어보낼 아이
        PreparedStatement psmt = null;
        // 쿼리 작성
        String sql;

        sql = "INSERT INTO " + User.Table.TABLE_NAME + "(" +
                User.Column.ID + ", " +
                User.Column.PASSWORD + ", " +
                User.Column.NAME + ", " +
                User.Column.PHONE + ", " +
                User.Column.MAINCARD + ", " +
                User.Column.FIRST_DATE + ", " +
                User.Column.LAST_DATE + ") " +
                " VALUES (?,?,?,?,?,?,?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, cos.getId());
            psmt.setString(2, cos.getPassword().toString());
            psmt.setString(3, cos.getName());
            psmt.setString(4, cos.getPhone());
            psmt.setInt(5, cos.getMainCardNum());
            psmt.setTimestamp(6, cos.getFirstDate());
            psmt.setTimestamp(7, cos.getLastDate());

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
        User cos = (User) object;
        int result = 0;

//		System.out.println("DAO insert");
        // 전달된 telBook DB에 저장

        Connection conn = MysqlConnection.getConnection();
        // 쿼리 실어보낼 아이
        PreparedStatement psmt = null;
        // 쿼리 작성
        String sql = "UPDATE " + User.Table.TABLE_NAME +
                " SET " + User.Column.PASSWORD + " = ?, " +
                User.Column.NAME + " = ?, " +
                User.Column.PHONE + " = ?, " +
                User.Column.MAINCARD + " = ?, " +
                User.Column.ID + " = ? " +
                " WHERE " + User.Column.NUM + " = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, cos.getPassword().toString());
            psmt.setString(2, cos.getName());
            psmt.setString(3, cos.getPhone());
            psmt.setInt(4, cos.getMainCardNum());
            psmt.setString(5, cos.getId());
            psmt.setString(6, cos.getName());
            result = psmt.executeUpdate();
            psmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public int delete(Long id) {
        int result = 0;

        Connection conn = MysqlConnection.getConnection();
        PreparedStatement psmt = null;
        String sql = "DELETE FROM " + User.Table.TABLE_NAME +
                " WHERE " + User.Column.NUM + " = ?";

        try {
            psmt = conn.prepareCall(sql);
            psmt.setLong(1, id);

            result = psmt.executeUpdate();
            psmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public List<Object> getListAll() {
        // RecordSet을 하나씩 읽어서 담을 TelBook entity 리스트 선언
        List<Object> costomerDto = new ArrayList<>();

        Connection conn = MysqlConnection.getConnection();
        PreparedStatement psmt = null;
        ResultSet rs = null;

        String sql = "SELECT " + User.Column.NUM + ", " +
                User.Column.ID + ", " +
                User.Column.PASSWORD + ", " +
                User.Column.NAME + ", " +
                User.Column.PHONE + ", " +
                User.Column.MAINCARD + ", " +
                User.Column.FIRST_DATE + ", " +
                User.Column.LAST_DATE +
                " FROM " + User.Table.TABLE_NAME + " ORDER BY " + User.Column.NAME;
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                UserDTO cus = new UserDTO();
                cus.setNum(rs.getInt(User.Column.NUM));
                cus.setId(rs.getString(User.Column.ID));
                cus.setPassword(rs.getString(User.Column.PASSWORD));
                cus.setName(rs.getString(User.Column.NAME));
                cus.setPhone(rs.getString(User.Column.PHONE));
                cus.setMainCardNum(rs.getInt(User.Column.MAINCARD));
                cus.setFirstDate(rs.getTimestamp(User.Column.FIRST_DATE));
                cus.setLastDate(rs.getTimestamp(User.Column.LAST_DATE));
                costomerDto.add(cus);
            }
            rs.close();
            psmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return costomerDto;
    }

    @Override
    public Object getOne(Long num) {
        System.out.println("DAO getOne");

        Connection conn = MysqlConnection.getConnection();
        PreparedStatement psmt = null;
        ResultSet rs = null;

        String sql = "SELECT " +
                User.Column.ID + ", " +
                User.Column.PASSWORD + ", " +
                User.Column.NAME + ", " +
                User.Column.PHONE + ", " +
                User.Column.MAINCARD + ", " +
                User.Column.FIRST_DATE + ", " +
                User.Column.LAST_DATE +
                " FROM " + User.Table.TABLE_NAME +
                " WHERE " +
                User.Column.NUM + " = ? ";
        User cus = null;

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, num.intValue());

            rs = psmt.executeQuery();
            while (rs.next()) {
                cus = new User();
                cus.setNum(rs.getInt(User.Column.NUM));
                cus.setId(rs.getString(User.Column.ID));
                cus.setPassword(rs.getString(User.Column.PASSWORD));
                cus.setName(rs.getString(User.Column.NAME));
                cus.setPhone(rs.getString(User.Column.PHONE));
                cus.setMainCardNum(rs.getInt(User.Column.MAINCARD));
                cus.setFirstDate(rs.getTimestamp(User.Column.FIRST_DATE));
                cus.setLastDate(rs.getTimestamp(User.Column.LAST_DATE));
            }
            rs.close();
            psmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cus;
    }

    public List<Object> serchId(String id) {

        return List.of();
    }


    @Override
    public Object getOne(String id) {

        System.out.println("DAO getOne");

        Connection conn = MysqlConnection.getConnection();
        PreparedStatement psmt = null;
        ResultSet rs = null;

        String sql = "SELECT " +
                User.Column.NUM + ", " +
                User.Column.ID + ", " +
                User.Column.PASSWORD +
                " FROM " +
                User.Table.TABLE_NAME +
                " WHERE " +
                User.Column.ID + " = ?";
        User cus = null;

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);

            rs = psmt.executeQuery();
            // 갖고온 데이터를 TelBook에 담아서 리턴
            while (rs.next()) {
                cus = new User();
                cus.setId(rs.getString(User.Column.ID));
                cus.setPassword(rs.getString(User.Column.PASSWORD));
                cus.setNum(rs.getInt(User.Column.NUM));
            }
            rs.close();
            psmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cus;
    }

    public int updateLastDate(int cus_num) {
        int result = 0;
        //마지막 날짜 업데이트
        Connection conn = MysqlConnection.getConnection();
        // 쿼리 실어보낼 아이
        PreparedStatement psmt = null;
        // 쿼리 작성
        String sql = "UPDATE " + User.Table.TABLE_NAME +
                " SET " + User.Column.LAST_DATE + " = ?" +
                " WHERE " + User.Column.NUM + " = ?";
        try {
            psmt = conn.prepareStatement(sql);
            Timestamp nowTimestamp = new Timestamp(System.currentTimeMillis());
            psmt.setTimestamp(1, nowTimestamp);
            psmt.setInt(2, cus_num);
            result = psmt.executeUpdate();
            psmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Object> searchKeyword(int num, String keyword) {

        List<Object> costomerDto = new ArrayList<>();
        Connection conn = MysqlConnection.getConnection();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String whereColumn = "";
        switch (num) {
            case UserDAO.USER_ID:
                whereColumn = User.Column.ID;
                break;
            case UserDAO.USER_NAME:
                whereColumn = User.Column.NAME;
                break;
        }
        String sql = "SELECT " + User.Column.NUM + ", " +
                User.Column.NUM + ", " +
                User.Column.NAME + ", " +
                User.Column.PHONE + ", " +
                User.Column.MAINCARD + ", " +
                User.Column.FIRST_DATE + ", " +
                User.Column.LAST_DATE +
                " WHERE " + whereColumn + " like ?" +
                " ORDER BY " + User.Column.NAME;
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, "%" + keyword + "%");
            rs = psmt.executeQuery();

            while (rs.next()) {
                UserDTO cus = new UserDTO();
                cus.setNum(rs.getInt(User.Column.NUM));
                cus.setId(rs.getString(User.Column.ID));
                cus.setName(rs.getString(User.Column.NAME));
                cus.setMainCardNum(rs.getInt(User.Column.MAINCARD));
                cus.setPhone(rs.getString(User.Column.PHONE));
                cus.setFirstDate(rs.getTimestamp(User.Column.FIRST_DATE));
                cus.setLastDate(rs.getTimestamp(User.Column.LAST_DATE));
                costomerDto.add(cus);
            }
            rs.close();
            psmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return costomerDto;
    }
}
