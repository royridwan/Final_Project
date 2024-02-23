package pages;

import helper.Utility;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static helper.Utility.driver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;

public class WebPage {
    String username, pwd, name, creditCard;
    int currentIndex = 1;
    int global_price;
    int pageIndex = 0;
    By signUp_menu = By.id("signin2");
    By signUp_username = By.id("sign-username");
    By signUp_pwd = By.id("sign-password");
    By login_username = By.id("loginusername");
    By login_pwd = By.id("loginpassword");
    By signUp_btn = By.xpath("//button[normalize-space()='Sign up']");
    By login_btn = By.xpath("//button[normalize-space()='Log in']");
    By login_menu = By.id("login2");
    By logout_menu = By.id("logout2");
    By welcome_user = By.xpath("//a[@id='nameofuser']");
    By product_name = By.xpath("//a[@class='hrefch']");
    By addToCart_btn = By.xpath("//a[@class='btn btn-success btn-lg']");
    By home_menu = By.xpath("(//a[@class='nav-link'])[1]");
    By cart_menu = By.id("cartur");
    By order_btn = By.xpath("(//button[normalize-space()='Place Order'])[1]");
    By order_name = By.id("name");
    By order_country = By.id("country");
    By order_city = By.id("city");
    By order_card = By.id("card");
    By order_month = By.id("month");
    By order_year = By.id("year");
    By purchase_btn = By.xpath("(//button[normalize-space()='Purchase'])[1]");


    public void userGoToWebPage() {
        driver.get("https://www.demoblaze.com/");
    }

    public void userClickSignUpMenu() {
        driver.findElement(signUp_menu).click();
    }

    public void userInputSignUpUsername() {
        username = Utility.generateRandomUsername();
        driver.findElement(signUp_username).sendKeys(username);
    }

    public void userInputSignUpPwd() {
        pwd = Utility.generateRandomPwd();
        driver.findElement(signUp_pwd).sendKeys(pwd);
    }

    public void userClickSignUpButton() {
        driver.findElement(signUp_btn).click();
    }

    public void validationMessage(String messageType, String message) {
        try {
            switch (messageType){
                case "alert":
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                    String actualMessage = alert.getText();
                    alert.accept();
                    assertThat(actualMessage).isEqualTo(message);
                    break;
                case "page":
                    assertTrue(driver.getPageSource().contains(message));
                    break;
                default:
                    System.out.println("input right message type");
                    break;
            }
        } catch (NoAlertPresentException e) {
            throw new RuntimeException(e);
        }
    }

    public void userClickLoginMenu() {
        driver.findElement(login_menu).click();
    }

    public void userInputLoginUsername() {
        driver.findElement(login_username).sendKeys(username);
    }

    public void userInputLoginPwd() {
        driver.findElement(login_pwd).sendKeys(pwd);
    }

    public void userClickLoginButton() {
        driver.findElement(login_btn).click();
    }

    public void validationLoginSuccessful() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement welcomeTextElement = driver.findElement(By.id("nameofuser"));
        String actualWelcomeText = welcomeTextElement.getText();
        //System.out.println(actualWelcomeText);
        assertThat(actualWelcomeText).isEqualTo("Welcome " + username);
    }

    public void userClickProductName() {
        while (true) {
            try {
                WebElement productName = driver.findElement(By.xpath("(//h4[@class='card-title'])[" + currentIndex + "]/a[@class='hrefch']"));
                productName.click();
                currentIndex++;
                break;
            } catch (StaleElementReferenceException ignored) {

            }
        }
    }

    public void userClickAddToCartButton() {
        driver.findElement(addToCart_btn).click();
    }

    public void userClickHomeMenu() {
        driver.findElement(home_menu).click();
    }

    public void userClickCartMenu() {
        driver.findElement(cart_menu).click();
    }

    public void validationCartPageDisplayEquals(int productIn_cart) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int actualProductsCount = driver.findElements(By.xpath("(//tr[@class='success'])")).size();
        Assert.assertEquals(productIn_cart, actualProductsCount);
    }

    public void validationTotalPriceIsEqualsPriceOfProduct() {
        List<WebElement> priceElements = driver.findElements(By.xpath("//tr[@class='success']/td[3]"));
        int sumPrice_product = 0;
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText();
            int price = Integer.parseInt(priceText);
            sumPrice_product += price;
        }

        WebElement totalElement = driver.findElement(By.id("totalp"));
        int total_price;
        String totalText = totalElement.getText();
        if (totalText.isEmpty()) {
            total_price = 0;
        } else {
            total_price = Integer.parseInt(totalText);
        }
        global_price = total_price;
        assertThat(total_price).isEqualTo(sumPrice_product);
        //System.out.println(total_price + " : " + sumPrice_product);
    }

    public void userClickDeleteProductFromCart() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement delete_cart = driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='Delete'])[1]"));
        delete_cart.click();
    }

    public void userClickPlaceOrderButton() {
        driver.findElement(order_btn).click();
    }

    public void userInputPlaceOrderInformation() {
        name = "Ridwan";
        String country = "Indonesia";
        String city = "Denpasar";
        creditCard = "12345";
        String month = "february";
        String year = "2024";

        driver.findElement(order_name).sendKeys(name);
        driver.findElement(order_country).sendKeys(country);
        driver.findElement(order_city).sendKeys(city);
        driver.findElement(order_card).sendKeys(creditCard);
        driver.findElement(order_month).sendKeys(month);
        driver.findElement(order_year).sendKeys(year);
    }

    public void userClickPurchaseButton() {
        driver.findElement(purchase_btn).click();
    }

    public void validationOrderInformationIsMatch() {
        WebElement order_information = driver.findElement(By.xpath("//p[@class='lead text-muted ']"));
        String actual_information = order_information.getText();
        //System.out.println(actual_information);
        assertThat(actual_information).contains("Name: " + name);
        assertThat(actual_information).contains("Card Number: " + creditCard);
        assertThat(actual_information).contains("Amount: " + global_price + " USD");
    }

    public void userClickOkButton() {
        WebElement ok_btn = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        ok_btn.click();
    }

    public void validationUserIsOnHomePage() {
        WebElement product_body = driver.findElement(By.id("tbodyid"));
        assertTrue(product_body.isDisplayed());
    }

    public void userClickLogoutButton() {
        try {
            Thread.sleep(1000);
            driver.findElement(logout_menu).click();
        } catch (StaleElementReferenceException | InterruptedException ignored) {

        }
    }

    public void validationLogoutSuccessful() {
        driver.findElement(login_menu).isDisplayed();
    }

    public void userClickCategories(String categories) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        switch (categories){
            case "Phones":
                WebElement phones = driver.findElement(By.xpath("(//a[@onclick=\"byCat('phone')\"])"));
                phones.click();
                break;
            case "Laptops":
                WebElement laptops = driver.findElement(By.xpath("(//a[@onclick=\"byCat('notebook')\"])"));
                laptops.click();
                break;
            case "Monitors":
                WebElement monitors = driver.findElement(By.xpath("(//a[@onclick=\"byCat('monitor')\"])"));
                monitors.click();
                break;
            default:
                System.out.println("input right categories");
                driver.quit();
        }
    }

    public void validationPageDisplayProduct(String validateDisplay_cat) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> product_title = driver.findElements(By.xpath("(//a[@class=\"hrefch\"])"));
        String product_text = "";
        switch (validateDisplay_cat){
            case "Phones":
                for (WebElement phones_title : product_title) {
                    product_text = phones_title.getText();
                    //System.out.println(product_text);
                    break;
                }
                assertThat(product_text).startsWith("Samsung galaxy s6");
                break;
            case "Laptops":
                for (WebElement laptops_title : product_title) {
                    product_text = laptops_title.getText();
                    //System.out.println(product_text);
                    break;
                }
                assertThat(product_text).startsWith("Sony vaio i5");
                break;
            case "Monitors":
                for (WebElement monitors_title : product_title) {
                    product_text = monitors_title.getText();
                    //System.out.println(product_text);
                    break;
                }
                assertThat(product_text).startsWith("Apple monitor 24");
                break;
            default:
                System.out.println("input right validate categories");
                driver.quit();
        }
    }

}
