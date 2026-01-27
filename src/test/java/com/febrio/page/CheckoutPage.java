package com.febrio.page;

import com.febrio.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver = Hooks.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }
//    ("user click checkout button")
    public void userClickCheckoutButton() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By checkoutButton = By.id("checkout");

        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton))
                .click();
    }

//    ("user input first name with {string} and last name with {string} and postal code with {string}")
    public void userInputFirstNameWithAndLastNameWithAndPostalCodeWith(String FirstName, String LastName, String PostalCode) {

        By firstNameField = By.cssSelector("input#first-name");
        By lastNameField = By.cssSelector("input#last-name");
        By postalCodeField = By.cssSelector("input#postal-code");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(FirstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(LastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField)).sendKeys(PostalCode);

        System.out.println(driver.getCurrentUrl());

        driver.findElement(firstNameField).sendKeys(FirstName);
        driver.findElement(lastNameField).sendKeys(LastName);
        driver.findElement(postalCodeField).sendKeys(PostalCode);

    }

//    ("user click continue")
    public void userClickContinue() {
        By continueField = By.cssSelector("[data-test='continue']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueField));
        driver.findElement(continueField).click();

    }

//    ("user in checkout overview page")
    public void userInCheckoutOverviewPage() {
        By itemName = By.cssSelector(".inventory_item_name");
        By paymentInfo = By.cssSelector("[data-test='payment-info-label']");
        By shipInfo = By.cssSelector("[data-test='shipping-info-label']");
        By priceTotal = By.cssSelector("[data-test='total-info-label']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInfo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shipInfo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceTotal));
        String actualItemName = driver.findElement(itemName).getText();
        String actualPaymentInfo = driver.findElement(paymentInfo).getText();
        String actualShipInfo = driver.findElement(shipInfo).getText();
        String actualPriceTotal = driver.findElement(priceTotal).getText();

//        Check ketersediaan field
        Assert.assertEquals("Sauce Labs Backpack", actualItemName);
        Assert.assertEquals("Payment Information:", actualPaymentInfo);
        Assert.assertEquals("Shipping Information:", actualShipInfo);
        Assert.assertEquals("Price Total", actualPriceTotal);

    }

//    ("user click finish")
    public void userClickFinish() {
        By finishButton = By.cssSelector("[data-test='finish']");
        driver.findElement(finishButton).click();
    }
}
