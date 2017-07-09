package utils.pepboys;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static org.testng.Assert.fail;

public class CreditCard {
    private String name;
    private String number;
    private String expDate;
    private String cvv;
    private String cardholderName;

    private Log log = LogFactory.getLog(this.getClass().getSimpleName());

    public CreditCard(String name, String number, String expDate, String cvv, String cardholderName) {
        this.name = name;
        this.number = number;
        this.expDate = expDate;
        this.cvv = cvv;
        this.cardholderName = cardholderName;
    }

    public String getName() {
        return name;
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

    public String getSecureCardData() {
        String secureCardNumber = null;
        int cardNumberLength = this.number.length();
        int cardCVVnumber = this.cvv.length();
        String lastFourNumbers = StringUtils.right(this.number, 4);
        log.info(this.expDate);
        String[] temp = this.expDate.split("/");
        log.info(temp[0] + " - " + temp[1]);
        String modifiedDate = temp[0] + "/" + "20" + temp[1];
        String cardName = firstUpperCase(name);

        log.info("Card info: ");
        log.info("Card name: " + cardName);
        log.info("Cart length: " + cardNumberLength);
        log.info("Last four numbers: " + lastFourNumbers);
        log.info("Modified date: " + modifiedDate);


        if (cardNumberLength == 16) {
            secureCardNumber = String.format("%s: **** **** **** %s (%s)", cardName, lastFourNumbers, modifiedDate);

        } else if (cardNumberLength == 15) {
            secureCardNumber = String.format("%s: **** **** **** %s", cardName, lastFourNumbers);

        } else if (cardCVVnumber == 4) {
            secureCardNumber = String.format("%s: **** ****** **" + "%s", cardName, lastFourNumbers);
        } else {
            fail("Card number length doesn't equals 16 or 15. Please select another card");
        }

        log.info("Secure card number: " + cardNumberLength);

        // return **** **** **** 4657 (02/12)
        return secureCardNumber;
    }

    private void printCard() {

    }

    private String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) {
            log.error("Word is empty.");
            return null;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
