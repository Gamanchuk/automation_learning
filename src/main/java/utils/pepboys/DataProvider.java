package utils.pepboys;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import utils.Config;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class DataProvider {

    public static BillingUser getUser(String userName) {
        String propsPath = "./profiles/sites/" + Config.SITE_NAME + "/users/" + userName + ".properties";
        Properties props = getProperties(propsPath);

        return new BillingUser(
                props.getProperty("firstName"),
                props.getProperty("lastName"),
                props.getProperty("fullName"),
                props.getProperty("fullAddress"),
                props.getProperty("city"),
                props.getProperty("state"),
                props.getProperty("zipCode"),
                props.getProperty("apartment"),
                props.getProperty("phone"),
                props.getProperty("email"),
                props.getProperty("cityInfo"),
                props.getProperty("password"),
                props.getProperty("paypalEmail"),
                props.getProperty("paypalPassword"),
                props.getProperty("rewardsNumber")
        );
    }

    public static CreditCard getCard(String cardName) {
        String propsPath = "./profiles/sites/" + Config.SITE_NAME + "/cards/" + cardName + ".properties";
        Properties props = getProperties(propsPath);

        return new CreditCard(
                props.getProperty("name"),
                props.getProperty("number"),
                props.getProperty("expDate"),
                props.getProperty("cvv"),
                props.getProperty("cardholderName")
        );
    }

    public static Vehicle getVehicle(String model) {
        String propsPath = "./profiles/sites/" + Config.SITE_NAME + "/vehicles/" + model + ".properties";
        Properties props = getProperties(propsPath);

        return new Vehicle(
                props.getProperty("modelYear"),
                props.getProperty("model"),
                props.getProperty("make"),
                props.getProperty("engine"),
                props.getProperty("drivetrain"),
                props.getProperty("trim")
        );
    }

    public static String getRandomItem() {
        List<String> items = getFileStrings(System.getProperty("user.dir") + "/src/main/resources/profiles/sites/" + Config.SITE_NAME + "/items.txt");
        int itemNumber = ThreadLocalRandom.current().nextInt(0, items.size());
        return items.get(itemNumber);
    }

    private static Properties getProperties(String propsPath) {
        Properties props = new Properties();
        try {
            props = PropertiesLoaderUtils.loadAllProperties(propsPath);
        } catch (IOException e) {
            System.out.println("'" + propsPath + "' was not found");
            e.printStackTrace();
        }

        return props;
    }

    private static List<String> getFileStrings(String path) {
        try {
            return FileUtils.readLines(new File(path), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
