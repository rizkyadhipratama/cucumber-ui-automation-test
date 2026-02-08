package com.febrio.page;

import com.febrio.Hooks;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CartPage {

    WebDriver driver = Hooks.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public CartPage(WebDriver driver){
        this.driver = driver;
    }
//    ("user click add to cart button for specific product")
    public void userClickAddToCartButtonForSpecificProduct() {
        By addDataToCart = By.id("add-to-cart-sauce-labs-backpack");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addDataToCart));
        driver.findElement(addDataToCart).click();
    }

//    ("user click cart icon")
    public void userClickCartIcon() {

        By cartIcon = By.cssSelector(".shopping_cart_link");

        // Wait for cart icon to be visible and clickable
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));

        // Scroll into view to ensure it's clickable
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cart);

        // Click the cart icon
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();

        // Wait a moment for navigation to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Wait for cart page to load
        wait.until(ExpectedConditions.urlContains("cart.html"));

        // Now validate cart page elements
        By cartItem = By.cssSelector("[data-test='inventory-item-name']");
        By checkoutBtn = By.cssSelector("[data-test='checkout']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));

        String ActualCartItem = driver.findElement(cartItem).getText();
        String ActualCheckOutButton = driver.findElement(checkoutBtn).getText();
        Assert.assertEquals("Sauce Labs Backpack", ActualCartItem);
        Assert.assertEquals("Checkout", ActualCheckOutButton);

    }
}
