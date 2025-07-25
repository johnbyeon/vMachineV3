package Entity;

import java.sql.Timestamp;

public class AccountingBook {
    public class Table{
        public static final String TABLE_NAME = "accounting_book";
    }
    public class Column{
        public static final String NUM = "acnt_num";
        public static final String USER_NUM = "acnt_cus_num";
        public static final String PAYMENT_NUM = "acnt_pay_num";
        public static final String PRODUCT_NUM = "acnt_product_num";
        public static final String PRODUCT_COUNT = "acnt_product_count";
    }



    private int num;
    private int cusNum;
    private int payNum;
    private int productNum;
    private int productCount;


    public AccountingBook() {
    }

    public AccountingBook(int num, int cusNum, int payNum, int productNum, int productCount) {
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
