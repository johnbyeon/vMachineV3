package DTO;

import java.sql.Timestamp;

public class PaymentAccountDTO {
    private int ac_num;
    private int cus_num;
    private String cus_id;
    private int pay_num;
    private int prod_num;
    private String prod_name;
    private int prod_count;
    private int pay_amount;
    private Timestamp pay_date;

    public PaymentAccountDTO(){}
    public PaymentAccountDTO(int ac_num,
                             int cus_num,
                             String cus_id,
                             int pay_num,
                             int prod_num,
                             String prod_name,
                             int prod_count,
                             int pay_amount,
                             Timestamp pay_date) {
        this.ac_num = ac_num;
        this.cus_num = cus_num;
        this.cus_id = cus_id;
        this.pay_num = pay_num;
        this.prod_num = prod_num;
        this.prod_name = prod_name;
        this.prod_count = prod_count;
        this.pay_amount = pay_amount;
        this.pay_date = pay_date;
    }

    public void setPay_amount(int pay_amount) {
        this.pay_amount = pay_amount;
    }

    public void setAc_num(int ac_num) {
        this.ac_num = ac_num;
    }

    public void setCus_num(int cus_num) {
        this.cus_num = cus_num;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public void setPay_num(int pay_num) {
        this.pay_num = pay_num;
    }

    public void setProd_num(int prod_num) {
        this.prod_num = prod_num;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public void setProd_count(int prod_count) {
        this.prod_count = prod_count;
    }

    public void setPay_date(Timestamp pay_date) {
        this.pay_date = pay_date;
    }


    public int getCus_num() {
        return cus_num;
    }

    public int getAc_num() {
        return ac_num;
    }

    public String getCus_id() {
        return cus_id;
    }

    public int getPay_num() {
        return pay_num;
    }

    public int getProd_num() {
        return prod_num;
    }

    public String getProd_name() {
        return prod_name;
    }

    public int getProd_count() {
        return prod_count;
    }

    public int getPay_amount() {
        return pay_amount;
    }

    public Timestamp getPay_date() {
        return pay_date;
    }






}
