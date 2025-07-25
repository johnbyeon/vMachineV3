package DTO;

import Entity.User;

import java.sql.Timestamp;

public class UserDTO {
    private int num;
    private String id;
    private String password;
    private String name;
    private String phone;
    private int mainCardNum;
    private Timestamp firstDate;
    private Timestamp lastDate;

    // dto를 TelBook entity로 변환
    public static User fromDto(UserDTO dto) {
        return new User(
                dto.getNum(),
                dto.getId(),
                dto.getPassword(),
                dto.getName(),
                dto.getPhone(),
                dto.getMainCardNum(),
                dto.getFirstDate(),
                dto.getLastDate());
    }

    // Entity(TelBook)을 TelBookDto로 변환..
    public static UserDTO fromEntity(User entity) {
        return new UserDTO(
                entity.getNum(),
                entity.getId(),
                entity.getPassword(),
                entity.getName(),
                entity.getPhone(),
                entity.getMainCardNum(),
                entity.getFirstDate(),
                entity.getLastDate());
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "num=" + num +
                ", id='" + id + '\'' +
                ", password=" + password +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mainCardNum=" + mainCardNum +
                ", firstDate=" + firstDate +
                ", lastDate=" + lastDate +
                '}';
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


    public Timestamp getLastDate() {
        return lastDate;
    }

    public Timestamp getFirstDate() {
        return firstDate;
    }

    public int getMainCardNum() {
        return mainCardNum;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public UserDTO() {
    }



    // 입력받은 자료를 바로 TelBookDto로 생성하기
    public static UserDTO makeDto(int num,
                                  String id,
                                  String password,
                                  String name,
                                  String phone,
                                  int mainCardNum,
                                  Timestamp firstDate,
                                  Timestamp lastDate) {

        return new UserDTO(num, id, password, name, phone, mainCardNum, firstDate, lastDate);
    }

    public UserDTO(int num,
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


    public UserDTO(int num,
                   String id,
                   String password,
                   String name,
                   int mainCardNum,
                   Timestamp firstDate,
                   Timestamp lastDate) {
        this.num = num;
        this.id = id;
        this.password = password;
        this.name = name;
        this.mainCardNum = mainCardNum;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }
    public UserDTO(int num,
                   String id,
                   String password,
                   int mainCardNum,
                   Timestamp firstDate,
                   Timestamp lastDate) {
        this.num = num;
        this.id = id;
        this.password = password;
        this.mainCardNum = mainCardNum;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }

}
