package utils.pepboys;

public class BillingUser {
    private String name;
    private String address;
    private String appartment;
    private String phone;
    private String email;
    private String cityInfo;

    public BillingUser(String name, String address, String appartment, String phone, String email, String cityInfo) {
        this.name = name;
        this.address = address;
        this.appartment = appartment;
        this.phone = phone;
        this.email = email;
        this.cityInfo = cityInfo;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAppartment() {
        return appartment;
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
}
