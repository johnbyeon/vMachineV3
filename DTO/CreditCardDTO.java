package DTO;

import Entity.AccountingBook;

public class CreditCardDTO {

    private int num;
    private int cusNum;
    private int cardNum;
    private int cardBalance;
    private int firstDate;
    private int useStatus;

    public CreditCardDTO(int num, int cusNum, int cardNum, int cardBalance, int firstDate, int useStatus) {
        this.num = num;
        this.cusNum = cusNum;
        this.cardNum = cardNum;
        this.cardBalance = cardBalance;
        this.firstDate = firstDate;
        this.useStatus = useStatus;
    }

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
