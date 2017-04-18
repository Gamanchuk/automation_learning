package utils.pepboys;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

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
        put("qa user3", new BillingUser(
                "Qa",
                "moovweb",
                "Qa moovweb",
                "8th avenue",
                "New york",
                "NY",
                "10018",
                "Unit 1611",
                "5122014321",
                "qa@moovweb.com",
                "New york NY 10018",
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
        put("user at Spear street", new BillingUser(
                "Moovweb",
                "QA",
                "Moovweb QA",
                "201 Spear St",
                "SanFrancisco",
                "CA",
                "94105",
                "10",
                "4154154156",
                "qa@moovweb.com",
                "SanFrancisco CA 94105",
                "Spear201!",
                "manytu2012-buy@gmail.com",
                "q1q1q1q1"
        ));
        put("Moovweb QA", new BillingUser(
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

    private static String [] items = {
            "787226",
            "787233",
            "785244",
            "9011450",
            "8322906",
            "1231825",
            "627470",
            "627487",
            "627494",
            "627463",
            "832661",
            "9983690",
            "9046614",
            "9654183",
            "9856226",
            "9983676",
            "9663165",
            "9663189",
            "9046571",
            "9856240",
            "47407",
            "9856507",
            "46866",
            "9046557",
            "800282",
            "936477",
            "619277",
            "619284",
            "619303",
            "619310",
            "9307698",
            "9655155",
            "9423853",
            "9655162",
            "401582",
            "617219",
            "9654826",
            "186838",
            "186821",
            "186845"
    };

    public static BillingUser getUser(String userName) {
        return users.get(userName);
    }

    public static CreditCard getCard(String cardName) {
        return cards.get(cardName);
    }

    public static Vehicle getVehicle(String model) {
        return vehicles.get(model);
    }

    public static String getRandomItemId() {
        int itemNumber = ThreadLocalRandom.current().nextInt(0, items.length);
        return items[itemNumber];
    }
}
