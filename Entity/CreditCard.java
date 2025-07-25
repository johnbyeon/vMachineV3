package Entity;

public class CreditCard {
    public static final int UNUSED_CARD = 0;
    public static final int USING_CARD = 1;

    private int num;
    private int cusNum;
    private int cardNum;
    private int cardBalace;
    private int firstDate;
    private int useStatus;
    public CreditCard(){}
    public CreditCard(int num, int cusNum, int cardNum, int cardBalace, int firstDate, int useStatus) {
        this.num = num;
        this.cusNum = cusNum;
        this.cardNum = cardNum;
        this.cardBalace = cardBalace;
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

    public void setCardBalace(int cardBalace) {
        this.cardBalace = cardBalace;
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

    public int getCardBalace() {
        return cardBalace;
    }

    public int getFirstDate() {
        return firstDate;
    }

    public int getUseStatus() {
        return useStatus;
    }


}
