package utils.pepboys;

public class BillingUser {
    private String name;
    private String address;
    private String apartment;
    private String phone;
    private String email;
    private String cityInfo;
    private String password;
    private String paypalEmail;
    private String paypalPassword;


    public BillingUser(String name, String address, String appartment, String phone, String email, String cityInfo, String password, String paypalEmail, String paypalPassword) {
        this.name = name;
        this.address = address;
        this.apartment = appartment;
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

    public String getAddress() {
        return address;
    }

    public String getApartment() {
        return apartment;
    }

    public String getPhone() {
        return phone;
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
