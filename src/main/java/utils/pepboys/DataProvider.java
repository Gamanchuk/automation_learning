package utils.pepboys;

public class DataProvider {
    // Users
    private static BillingUser qaUser = new BillingUser(
            "qa",
            "moovweb",
            "qa moovweb",
            "123 mission street",
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
    );

    private static BillingUser invalidQaUser = new BillingUser(
            "Moovweb",
            "!@&$)();:@!",
            "qa moovweb",
            "123 mission street",
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
    );


    // Cards
    private static CreditCard visa = new CreditCard(
            "4111111111111111",
            "12/17",
            "111",
            "qa moovweb"
    );

    private static CreditCard discover = new CreditCard(
            "6011111111111117",
            "12/17",
            "111",
            "qa moovweb"
    );

    private static CreditCard amex = new CreditCard(
            "378282246310005",
            "12/17",
            "1111",
            "qa moovweb"
    );

    private static CreditCard mastercard = new CreditCard(
            "5555555555554444",
            "12/17",
            "111",
            "qa moovweb"
    );

    // Vehicles
    private static Vehicle captiva = new Vehicle(
            "2014",
            "CHEVROLET",
            "CAPTIVA",
            "4-146  2.4L DOHC",
            "4WD/AWD",
            "LS, LT"
    );

    public static BillingUser getUser(String userName) {
        switch (userName) {
            case "qa user":
                return qaUser;
            default:
                throw new Error("Unknown user: " + userName);
        }
    }

    public static CreditCard getCard(String cardName) {
        switch (cardName) {
            case "visa":
                return visa;
            case "discover":
                return discover;
            case "amex":
                return amex;
            case "mastercard":
                return mastercard;
            default:
                throw new Error("Unknown card: " + cardName);
        }
    }

    public static Vehicle getVehicle(String model) {
        switch (model) {
            case "captiva":
                return captiva;
            default:
                throw new Error("Unknown vehicle: " + model);
        }
    }
}
