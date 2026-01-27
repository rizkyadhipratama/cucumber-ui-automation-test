package com.febrio.page;

import com.febrio.Hooks;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='shopping-cart-link']")));
        driver.findElement(cartIcon).click();
        By cartItem = By.cssSelector("[data-test='inventory-item-name']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
        String ActualCartItem = driver.findElement(cartItem).getText();
        Assert.assertEquals("Sauce Labs Backpack", ActualCartItem);

    }
}
