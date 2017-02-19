package utils.pepboys;

public class CreditCard {
    private String number;
    private String expDate;
    private String cvv;

    public CreditCard(String number, String expDate, String cvv) {
        this.number = number;
        this.expDate = expDate;
        this.cvv = cvv;
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
}
