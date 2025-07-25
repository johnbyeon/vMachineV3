package Entity;

import java.sql.Timestamp;

public class PaymentHistory {
    private int num;
    private int creNum;
    private int status;
    private int amount;
    private int balace;
    private Timestamp date;

    public PaymentHistory() {
    }

    public PaymentHistory(int num,
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
