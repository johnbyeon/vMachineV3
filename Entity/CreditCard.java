package Entity;

public class CreditCard {
    public class Table{
        public static final String TABLE_NAME = "credit_card";
    }
    public class Column{
        public static final String NUM = "cre_num";
        public static final String USER_NUM = "cre_cus_num";
        public static final String CARD_NUM = "cre_card_num";
        public static final String BALANCE = "cre_card_balance";
        public static final String FIRST_DATE = "cre_first_date";
        public static final String USE_STATUS = "cre_use_status";
    }
    public static final int UNUSED_CARD = 0;
    public static final int USING_CARD = 1;

    private int num;
    private int cusNum;
    private int cardNum;
    private int cardBalance;
    private int firstDate;
    private int useStatus;
    public CreditCard(){}
    public CreditCard(int num, int cusNum, int cardNum, int cardBalance, int firstDate, int useStatus) {
        this.num = num;
        this.cusNum = cusNum;
        this.cardNum = cardNum;
        this.cardBalance = cardBalance;
        this.firstDate = firstDate;
        this.useStatus = useStatus;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setCusNum(int cusNum) {
        this.cusNum = cusNum;
    }

    public void setCardBalance(int cardBalance) {
        this.cardBalance = cardBalance;
    }

    public void setFirstDate(int firstDate) {
        this.firstDate = firstDate;
    }

    public void setUseStatus(int useStatus) {
        this.useStatus = useStatus;
    }
    public int getCardNum() {
        return cardNum;
    }

    public int getNum() {
        return num;
    }

    public int getCusNum() {
        return cusNum;
    }

    public int getCardBalance() {
        return cardBalance;
    }

    public int getFirstDate() {
        return firstDate;
    }

    public int getUseStatus() {
        return useStatus;
    }


}
