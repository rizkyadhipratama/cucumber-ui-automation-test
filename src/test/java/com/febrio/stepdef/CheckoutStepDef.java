package com.febrio.stepdef;

import com.febrio.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepDef {

    WebDriver driver = Hooks.driver;

    // Locators
    By usernameInputText = By.cssSelector("input#user-name");
    By userInputPassword = By.cssSelector("input#password");
    By loginButton = By.id("login-button");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));



    @Given("user is on login page for checkout")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
        String webPageTitle = driver.getTitle();
        Assert.assertEquals("Swag Labs", webPageTitle);

    }

    @When("user input username text box with {string} for checkout")
    public void userInputUsernameTextBoxWith(String username) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(usernameInputText).sendKeys(username);

    }

    @And("user input password pada text box with {string} for checkout")
    public void userInputPasswordPadaTextBoxWith(String password) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(userInputPassword).sendKeys(password);
    }

    @Then("user click submit for checkout")
    public void userClickSubmit() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(loginButton).click();
    }

    @Then("user will redirect to homepage for checkout")
    public void userWillRedirectToHomepage() {
        // User will redirect to homepage if login success
        By classTitle = By.cssSelector(".title");
//        wait.until(ExpectedConditions.presenceOfElementLocated(classTitle));
        String actualTitle = driver.findElement(classTitle).getText();
        Assert.assertEquals("Products", actualTitle);

    }


    @Given("user in homepage")
    public void userInHomepage() {
        By classTitle = By.cssSelector("[data-test='title']");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualTitle = driver.findElement(classTitle).getText();
        Assert.assertEquals("Products", actualTitle);
    }

    @Then("user click add to cart button for specific product")
    public void userClickAddToCartButtonForSpecificProduct() {
        By addDatatoCart = By.id("add-to-cart-sauce-labs-backpack");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addDatatoCart));
        driver.findElement(addDatatoCart).click();
    }

    @Then("user click cart icon")
    public void userClickCartIcon() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='shopping-cart-link']")));
        driver.findElement(cartIcon).click();
        By cartItem = By.cssSelector("[data-test='inventory-item-name']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
        String ActualCartItem = driver.findElement(cartItem).getText();
        Assert.assertEquals("Sauce Labs Backpack", ActualCartItem);

    }

    @When("user click checkout button")
    public void userClickCheckoutButton() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By checkoutButton = By.id("checkout");

        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton))
                .click();
    }

    @When("user input first name with {string} and last name with {string} and postal code with {string}")
    public void userInputFirstNameWithAndLastNameWithAndPostalCodeWith(String FirstName, String LastName, String PostalCode) {

        By FirstNameField = By.cssSelector("input#first-name");
        By LastNameField = By.cssSelector("input#last-name");
        By PostalCodeField = By.cssSelector("input#postal-code");
        wait.until(ExpectedConditions.visibilityOfElementLocated(FirstNameField)).sendKeys(FirstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LastNameField)).sendKeys(LastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PostalCodeField)).sendKeys(PostalCode);

        System.out.println(driver.getCurrentUrl());

        driver.findElement(FirstNameField).sendKeys(FirstName);
        driver.findElement(LastNameField).sendKeys(LastName);
        driver.findElement(PostalCodeField).sendKeys(PostalCode);

    }

    @Then("user click continue")
    public void userClickContinue() {
        By ContinueField = By.cssSelector("[data-test='continue']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueField));
        driver.findElement(ContinueField).click();

    }

    @Given("user in checkout overview page")
    public void userInCheckoutOverviewPage() {
        By ItemName = By.cssSelector(".inventory_item_name");
        By PaymentInfo = By.cssSelector("[data-test='payment-info-label']");
        By ShipInfo = By.cssSelector("[data-test='shipping-info-label']");
        By PriceTotal = By.cssSelector("[data-test='total-info-label']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(ItemName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentInfo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShipInfo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PriceTotal));
        String actualItemName = driver.findElement(ItemName).getText();
        String actualPaymentInfo = driver.findElement(PaymentInfo).getText();
        String actualShipInfo = driver.findElement(ShipInfo).getText();
        String actualPriceTotal = driver.findElement(PriceTotal).getText();

//        Check ketersediaan field
        Assert.assertEquals("Sauce Labs Backpack", actualItemName);
        Assert.assertEquals("Payment Information:", actualPaymentInfo);
        Assert.assertEquals("Shipping Information:", actualShipInfo);
        Assert.assertEquals("Price Total", actualPriceTotal);

    }

    @Then("user click finish")
    public void userClickFinish() {
        By FinishButton = By.cssSelector("[data-test='finish']");
        driver.findElement(FinishButton).click();
    }
}
