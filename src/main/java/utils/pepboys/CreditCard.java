package utils.pepboys;

public class CreditCard {
    private String number;
    private String expDate;
    private String cvv;
    private String cardholderName;

    public CreditCard(String number, String expDate, String cvv, String cardholderName) {
        this.number = number;
        this.expDate = expDate;
        this.cvv = cvv;
        this.cardholderName = cardholderName;
    }

    public String getNumber() {
        return number;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getCvv() {
        return cvv;
    }

    public String getCardholderName() {
        return cardholderName;
    }
}
