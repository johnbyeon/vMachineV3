package DTO;

import Entity.AccountingBook;
import Entity.PaymentHistory;

import java.sql.Timestamp;

public class PaymentHistoryDTO {
    private int num;
    private int creNum;
    private int status;
    private int amount;
    private int balace;
    private Timestamp date;

    public PaymentHistoryDTO() {
    }

    public PaymentHistoryDTO(int num,
                          int creNum,
                          int status,
                          int amount,
                          int balace,
                          Timestamp date) {
        this.num = num;
        this.creNum = creNum;
        this.status = status;
        this.amount = amount;
        this.balace = balace;
        this.date = date;
    }
    public static PaymentHistory fromDto(PaymentHistoryDTO dto) {
        return new PaymentHistory(
                dto.getNum(),
                dto.getCreNum(),
                dto.getStatus(),
                dto.getAmount(),
                dto.getBalace(),
                dto.getDate()
        );
    }

    // Entity(TelBook)을 TelBookDto로 변환..
    public static PaymentHistoryDTO fromEntity(PaymentHistory entity) {
        return new PaymentHistoryDTO(
                entity.getNum(),
                entity.getCreNum(),
                entity.getStatus(),
                entity.getAmount(),
                entity.getBalace(),
                entity.getDate()
        );

    }


    public void setNum(int num) {
        this.num = num;
    }

    public void setCreNum(int creNum) {
        this.creNum = creNum;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setBalace(int balace) {
        this.balace = balace;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    public int getStatus() {
        return status;
    }

    public int getNum() {
        return num;
    }

    public int getCreNum() {
        return creNum;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalace() {
        return balace;
    }

    public Timestamp getDate() {
        return date;
    }




}
