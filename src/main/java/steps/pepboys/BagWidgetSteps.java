package steps.pepboys;

import components.widgets.BagWidget;

@Deprecated
public class BagWidgetSteps {

    BagWidget bagWidget = new BagWidget();


//    @Given("the user go to page \"([^\"]*)\"")
//    public void goToPage(String page) {
//        bagWidget.goToPage(page);
//    }
//
//
//    @When("he enters \"([^\"]*)\" in search field and submit")
//    public void search(String searchText) {
//        bagWidget.setTextInSearch(searchText).submitSearch();
//    }
//
//
//    @And("ensure the product \"([^\"]*)\" found")
//    public void checkFoundProduct(String searchText) {
//        assertEquals(bagWidget.getItemNumber(), searchText);
//    }
//
//
//    @And("add product to bag")
//    public void addProductToBag() {
//        bagWidget.actionToBag();
//    }
//
//
//    @And("view and check out bag")
//    public void viewBagAndCheckOut() {
//        bagWidget.actionViewBagAndCheckOut();
//    }
//
//
//    @And("he enters/apply coupon \"([^\"]*)\"")
//    public void applyCoupon(String coupon) {
//        bagWidget.setCoupon(coupon).actionApplyCoupon();
//    }
//
//
//    @And("check out with paypal")
//    public void checkOutPayPal() {
//        bagWidget.actionCheckOutPayPal();
//    }
//
//
//    @And("he choice/apply random sample")
//    public void  choiceSample() {
//        bagWidget.setRandomSample().actionApplySample();
//    }
//
//
//    @And("he enter \"([^\"]*)\" for continue as guest")
//    public void continueAsGuest(String email) {
//        bagWidget.switchToFrame().continueAsGuest().setGuestEmail(email).actionContinueCheckout().switchToDefaultFrame();
//    }
//
//
//    @Then("he check price \"([^\"]*)\" order")
//    public void checkOrder(String order) {
//
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        assertEquals(bagWidget.switchToFrame().getOrderTotal(), order);
//
//    }
//
//    @Then("click button Place Order")
//    public void placeOrder() {
//        bagWidget.placeOrderButtonClick();
//    }
//
//    public void setShippingInformation(String fullName, String streetAddress, String aptAddress, String city, String state, String zipCode, String telephone) {
//
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        // bagWidget.switchToFrame();
//
//        bagWidget.setFullName(fullName)
//                .setStreetAddress(streetAddress)
//                .setAptAddress(aptAddress)
//                .setCity(city)
//                .setState(state)
//                .setZipCode(zipCode)
//                .setTelephone(telephone)
//                .continueShipping();
//
//    }
//
//    public void verificationAddress() {
//        bagWidget.verificationAddress().actionContinueAddressVerificationButton().continueToPayment();
//    }
//
//    public void setPayPalSystemPayment() {
//        bagWidget.goToPayPalPay();
//    }
//
//    public void checkOut() {
//        bagWidget.actionCheckOut().actionSkipSample();
//    }
//
//    public void checkOutAsGuest() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        bagWidget.switchToFrame();
//        bagWidget.checkOutAsGuest();
//    }


}
