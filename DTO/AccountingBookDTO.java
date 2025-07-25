package DTO;

import Entity.AccountingBook;

import java.sql.Timestamp;

public class AccountingBookDTO {
    private int num;
    private int cusNum;
    private int payNum;
    private int productNum;
    private int productCount;


    // dto를 TelBook entity로 변환
    public static AccountingBook fromDto(AccountingBookDTO dto) {
        return new AccountingBook(
                dto.getNum(),
                dto.getCusNum(),
                dto.getPayNum(),
                dto.getProductCount(),
                dto.getProductCount()
        );
    }

    // Entity(TelBook)을 TelBookDto로 변환..
    public static AccountingBookDTO fromEntity(AccountingBook entity) {
        return new AccountingBookDTO(
                entity.getNum(),
                entity.getCusNum(),
                entity.getPayNum(),
                entity.getProductCount(),
                entity.getProductCount()
        );

    }

    public AccountingBookDTO() {
    }

    public AccountingBookDTO(int num, int cusNum, int payNum, int productNum, int productCount) {
        this.num = num;
        this.cusNum = cusNum;
        this.payNum = payNum;
        this.productNum = productNum;
        this.productCount = productCount;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setCusNum(int cusNum) {
        this.cusNum = cusNum;
    }

    public void setPayNum(int payNum) {
        this.payNum = payNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getNum() {
        return num;
    }

    public int getCusNum() {
        return cusNum;
    }

    public int getPayNum() {
        return payNum;
    }

    public int getProductNum() {
        return productNum;
    }

    public int getProductCount() {
        return productCount;
    }



}
