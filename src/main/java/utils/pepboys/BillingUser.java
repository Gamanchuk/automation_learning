package utils.pepboys;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class BillingUser {
    private String name;
    private String fullAddress;
    private String recomendedAddress;
    private String city;
    private String state;
    private String zipCode;
    private String apartment;
    private String phone;
    private String email;
    private String cityInfo;
    private String password;
    private String paypalEmail;
    private String paypalPassword;


    public BillingUser(String name, String fullAddress, String city, String state, String zipCode, String apartment, String phone, String email, String cityInfo, String password, String paypalEmail, String paypalPassword) {
        this.name = name;
        this.fullAddress = fullAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.apartment = apartment;
        this.phone = phone;
        this.email = email;
        this.cityInfo = cityInfo;
        this.password = password;
        this.paypalEmail = paypalEmail;
        this.paypalPassword = paypalPassword;
    }

    public String getName() {
        return name;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getApartment() {
        return apartment;
    }

    public String getPhone() {
        return phone;
    }


    public String getFormattedPhone() {

        String mask = "(###) ###-####";
        String result = null;

        try {
            MaskFormatter maskFormatter = new MaskFormatter(mask);
            maskFormatter.setValueContainsLiteralCharacters(false);
            result = maskFormatter.valueToString(this.phone);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String getEmail() {
        return email;
    }

    public String getCityInfo() {
        return cityInfo;
    }

    public String getPassword() {
        return password;
    }

    public String getPaypalEmail() {
        return paypalEmail;
    }

    public String getPaypalPassword() {
        return paypalPassword;
    }

}
