package utils.pepboys;

import java.util.HashMap;
import java.util.Map;

public class DataProvider {
    private static Map<String, BillingUser> users = new HashMap<String, BillingUser>(){{
        put("qa user", new BillingUser(
                "qa",
                "moovweb",
                "qa moovweb",
                "123 Mission St",
                "San Francisco",
                "CA",
                "94105",
                "10",
                "4152011234",
                "qa@moovweb.com",
                "San Francisco CA 94105",
                "Spear201!",
                "manytu2012-buy@gmail.com",
                "q1q1q1q1"
        ));
        put("qa user2", new BillingUser(
                "anotherqa",
                "moovweb",
                "anotherqa moovweb",
                "440 Valencia St",
                "San Francisco",
                "CA",
                "94103-3449",
                "440",
                "4123445566",
                "qa@moovweb.com",
                "San Francisco CA 94103-3449",
                "Spear201!",
                "manytu2012-buy@gmail.com",
                "q1q1q1q1"
        ));
        put("invalidQaUser", new BillingUser(
                "Moovweb",
                "!@&$)();:@!",
                "qa moovweb",
                "123 Mission St",
                "San Francisco",
                "CA",
                "94105",
                "10th floor",
                "4152011234",
                "qa@moovweb.com",
                "San Francisco CA 94105",
                "Spear201!",
                "manytu2012-buy@gmail.com",
                "q1q1q1q1"
        ));
    }};

    private static Map<String, CreditCard> cards = new HashMap<String, CreditCard>() {{
        put("visa", new CreditCard(
                "visa",
                "4111111111111111",
                "12/17",
                "111",
                "qa moovweb"
        ));
        put("discover", new CreditCard(
                "discover",
                "6011111111111117",
                "12/17",
                "111",
                "qa moovweb"
        ));
        put("amex", new CreditCard(
                "americanexpress",
                "378282246310005",
                "12/17",
                "1111",
                "qa moovweb"
        ));
        put("mastercard", new CreditCard(
                "mastercard",
                "5555555555554444",
                "12/17",
                "111",
                "qa moovweb"
        ));
    }};

    private static Map<String, Vehicle> vehicles = new HashMap<String, Vehicle>() {{
       put("captiva", new Vehicle(
               "2014",
               "CHEVROLET",
               "CAPTIVA",
               "4-146  2.4L DOHC",
               "4WD/AWD",
               "LS, LT"
       ));
    }};

    public static BillingUser getUser(String userName) {
        return users.get(userName);
    }

    public static CreditCard getCard(String cardName) {
        return cards.get(cardName);
    }

    public static Vehicle getVehicle(String model) {
        return vehicles.get(model);
    }
}
