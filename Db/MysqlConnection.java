package Db;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    public static Connection DBConn;

    public static Connection getConnection() {
        if (DBConn == null) {
            try {
                String dbDriver = "com.mysql.cj.jdbc.Driver";
                String dbUrl = "jdbc:mysql://localhost:3306/machine_v3_db";
                String dbUser = "root";
                String dbPassword = "1111";
                Class.forName(dbDriver);
                DBConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                // 연결 성공한 경우
                System.out.println("DB 연결 성공");
            } catch (ClassNotFoundException e) {
                System.out.println("DB 연결 실패_1");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("DB 연결 실패_2");
                e.printStackTrace();
            }
        }
        return DBConn;
    }
}
