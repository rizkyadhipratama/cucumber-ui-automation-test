package com.febrio.page;

import com.febrio.Hooks;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver = Hooks.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

//   ("user in homepage")
    public void userInHomepage() {
        By classTitle = By.cssSelector("[data-test='title']");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualTitle = driver.findElement(classTitle).getText();
        Assert.assertEquals("Products", actualTitle);
    }
}
