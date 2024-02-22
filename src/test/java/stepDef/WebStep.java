package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebPage;

public class WebStep {

    WebPage webPage;
    public WebStep(){
        this.webPage = new WebPage();
    }

    @Given("user go to web page")
    public void userGoToWebPage() {
        webPage.userGoToWebPage();
    }

    @And("user click sign up menu")
    public void userClickSignUpMenu() {
        webPage.userClickSignUpMenu();
    }

    @And("user input sign up username")
    public void userInputSignUpUsername() {
        webPage.userInputSignUpUsername();
    }

    @And("user input sign up pwd")
    public void userInputSignUpPwd() {
        webPage.userInputSignUpPwd();
    }

    @When("user click sign up button")
    public void userClickSignUpButton() {
        webPage.userClickSignUpButton();
    }

    @And("user click login menu")
    public void userClickLoginMenu() {
        webPage.userClickLoginMenu();
    }

    @And("user input login username")
    public void userInputLoginUsername() {
        webPage.userInputLoginUsername();
    }

    @And("user input login pwd")
    public void userInputLoginPwd() {
        webPage.userInputLoginPwd();
    }

    @When("user click login button")
    public void userClickLoginButton() {
        webPage.userClickLoginButton();
    }

    @Then("validation login successful")
    public void validationLoginSuccessful() {
        webPage.validationLoginSuccessful();
    }

    @And("user click product name")
    public void userClickProductName() {
        webPage.userClickProductName();
    }

    @And("user click add to cart button")
    public void userClickAddToCartButton() {
        webPage.userClickAddToCartButton();
    }

    @And("user click home menu")
    public void userClickHomeMenu() {
        webPage.userClickHomeMenu();
    }

    @And("user click cart menu")
    public void userClickCartMenu() {
        webPage.userClickCartMenu();
    }

    @Then("validation cart page display equals {int} product")
    public void validationCartPageDisplayEqualsProduct(int productIn_cart) {
        webPage.validationCartPageDisplayEquals(productIn_cart);
    }

    @Then("validation get {string} message {string}")
    public void validationGetMessage(String type, String message) {
        webPage.validationMessage(type, message);
    }

    @And("user click place order button")
    public void userClickPlaceOrderButton() {
        webPage.userClickPlaceOrderButton();
    }

    @And("user input place order information")
    public void userInputPlaceOrderInformation() {
        webPage.userInputPlaceOrderInformation();
    }

    @And("user click purchase button")
    public void userClickPurchaseButton() {
        webPage.userClickPurchaseButton();
    }

    @And("user click logout button")
    public void userClickLogoutButton() {
        webPage.userClickLogoutButton();
    }

    @Then("validation logout successful")
    public void validationLogoutSuccessful() {
        webPage.validationLogoutSuccessful();
    }

    @Then("validation order information is match")
    public void validationOrderInformationIsMatch() {
        webPage.validationOrderInformationIsMatch();
    }

    @And("user click ok button")
    public void userClickOkButton() {
        webPage.userClickOkButton();
    }

    @Then("validation user is on home page")
    public void validationUserIsOnHomePage() {
        webPage.validationUserIsOnHomePage();
    }

    @Then("validation total price is equals price of product")
    public void validationTotalPriceIsEqualsPriceOfProduct() {
        webPage.validationTotalPriceIsEqualsPriceOfProduct();
    }

    @And("user click delete product from cart")
    public void userClickDeleteProductFromCart() {
        webPage.userClickDeleteProductFromCart();
    }

    @And("user click categories {string}")
    public void userClickCategories(String categories) {
        webPage.userClickCategories(categories);
    }

    @Then("validation page display {string} product")
    public void validationPageDisplayProduct(String validateDisplay_cat) {
        webPage.validationPageDisplayProduct(validateDisplay_cat);
    }
}
