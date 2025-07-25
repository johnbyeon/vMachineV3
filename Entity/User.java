package Entity;

import java.sql.Timestamp;

public class User {
    public class Table {
        public static final String TABLE_NAME = "user";
    }
    public class Column {
        public static final String ID ="cus_id";
        public static final String NUM ="cus_num";
        public static final String NAME ="cus_name";
        public static final String PASSWORD ="cus_password";
        public static final String PHONE ="cus_phone";
        public static final String MAINCARD ="cus_main_card_num";
        public static final String FIRST_DATE ="cus_first_date";
        public static final String LAST_DATE ="cus_last_date";
    }








    private int num;
    private String id;
    private String password;
    private String name;
    private String phone;
    private int mainCardNum;
    private Timestamp firstDate;
    private Timestamp lastDate;

    public User() {
    }

    public User(int num,
                String id,
                String password,
                String name,
                String phone,
                int mainCardNum,
                Timestamp firstDate,
                Timestamp lastDate) {
        this.num = num;
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.mainCardNum = mainCardNum;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }

    public int getNum() {
        return num;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getMainCardNum() {
        return mainCardNum;
    }

    public Timestamp getFirstDate() {
        return firstDate;
    }

    public Timestamp getLastDate() {
        return lastDate;
    }

    public void setLastDate(Timestamp lastDate) {
        this.lastDate = lastDate;
    }

    public void setFirstDate(Timestamp firstDate) {
        this.firstDate = firstDate;
    }

    public void setMainCardNum(int mainCardNum) {
        this.mainCardNum = mainCardNum;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNum(int num) {
        this.num = num;
    }


}
