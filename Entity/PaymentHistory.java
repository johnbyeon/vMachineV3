package Entity;

import java.sql.Timestamp;

public class PaymentHistory {
    public class Table{
        public static final String TABLE_NAME = "payment_history";
    }
    public class Column{
        public static final String NUM = "pay_num";
        public static final String CREDIT_NUM = "pay_cre_num";
        public static final String STATUS = "pay_stauts";
        public static final String AMOUNT = "pay_amount";
        public static final String BALANCE = "pay_balance";
        public static final String DATE = "pay_date";
    }



    private int num;
    private int creNum;
    private int status;
    private int amount;
    private int balance;
    private Timestamp date;

    public PaymentHistory() {
    }

    public PaymentHistory(int num,
                          int creNum,
                          int status,
                          int amount,
                          int balance,
                          Timestamp date) {
        this.num = num;
        this.creNum = creNum;
        this.status = status;
        this.amount = amount;
        this.balance = balance;
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

    public void setBalance(int balance) {
        this.balance = balance;
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

    public int getBalance() {
        return balance;
    }

    public Timestamp getDate() {
        return date;
    }

}
