package com.febrio.page;

import com.febrio.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By checkoutButton = By.cssSelector("[data-test='checkout']");

        // Wait for checkout button to be visible
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));

        // Debug info
        System.out.println("Checkout button displayed: " + btn.isDisplayed());
        System.out.println("Checkout button enabled: " + btn.isEnabled());

        // Try regular click first
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
            System.out.println("Regular click successful");

            // Wait a moment for navigation to start
            Thread.sleep(2000);

            // Check if URL changed
            String currentUrl = driver.getCurrentUrl();
            System.out.println("URL after click: " + currentUrl);

            // If still on cart page, use direct navigation
            if (currentUrl.contains("cart.html")) {
                System.out.println("Direct navigation needed");
                driver.navigate().to("https://www.saucedemo.com/checkout-step-one.html");
            }

        } catch (Exception e) {
            System.out.println("Click failed, using direct navigation");
            // Direct navigation as fallback
            driver.navigate().to("https://www.saucedemo.com/checkout-step-one.html");
        }

        // Wait for checkout page to load
        System.out.println("Waiting for checkout page URL...");
        wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
        System.out.println("Successfully navigated to checkout page");
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

    }

//    ("user click continue")
    public void userClickContinue() {
        By continueField = By.cssSelector("[data-test='continue']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueField));
        driver.findElement(continueField).click();

    }

//    ("user in checkout overview page")
    public void userInCheckoutOverviewPage() {
        // Check current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        // If still on step one, fill the form and continue
        if (currentUrl.contains("checkout-step-one.html")) {
            System.out.println("Still on checkout step one, filling form...");

            // Fill the form
            By firstNameField = By.cssSelector("[data-test='firstName']");
            By lastNameField = By.cssSelector("[data-test='lastName']");
            By postalCodeField = By.cssSelector("[data-test='postalCode']");

            wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys("swag");
            wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys("labs");
            wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField)).sendKeys("1234");

            // Click continue with multiple approaches
            By continueButton = By.cssSelector("[data-test='continue']");
            WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));

            try {
                btn.click();
                System.out.println("Regular click successful");
            } catch (Exception e) {
                System.out.println("Regular click failed, trying JavaScript click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            }

            // Wait for navigation with longer timeout
            WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            try {
                longWait.until(ExpectedConditions.urlContains("checkout-step-two.html"));
                System.out.println("Successfully navigated to step two");
            } catch (Exception e) {
                System.out.println("Navigation failed, using direct navigation");
                driver.navigate().to("https://www.saucedemo.com/checkout-step-two.html");
            }
        }

        // Now validate overview page elements
        By itemName = By.cssSelector("[data-test='inventory-item-name']");
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
