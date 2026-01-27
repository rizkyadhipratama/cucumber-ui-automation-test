package com.febrio.page;

import com.febrio.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.febrio.Hooks.driver;

public class LoginPage {

    WebDriver driver = Hooks.driver;

    // Locators
    By usernameInputText = By.cssSelector("input#user-name");
    By userInputPassword = By.cssSelector("input#password");
    By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

//    ("user is on login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
        String webPageTitle = driver.getTitle();
        Assert.assertEquals("Swag Labs", webPageTitle);

    }

//    ("user input username text box with {string}")
    public void userInputUsernameTextBoxWith(String username) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(usernameInputText).sendKeys(username);

    }

//    ("user input password pada text box with {string}")
    public void userInputPasswordPadaTextBoxWith(String password) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(userInputPassword).sendKeys(password);
    }

//    ("user click submit")
    public void userClickSubmit() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(loginButton).click();
    }

//    ("user will redirect to homepage")
    public void userWillRedirectToHomepage() {
        // User will redirect to homepage if login success
        By classTitle = By.cssSelector(".title");


        String actualTitle = driver.findElement(classTitle).getText();
        Assert.assertEquals("Products", actualTitle);


    }

//    ("user logout")
    public void userLogout() {
        // After login success, then user logout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By hamburgerMenu = By.id("react-burger-menu-btn");
        By menuWrap = By.cssSelector(".bm-menu-wrap");
        By logoutMenu = By.id("logout_sidebar_link");

        // Klik hamburger
        WebElement burger = wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", burger);

        // Tunggu sidebar benar-benar terbuka (transform CSS berubah)
        wait.until(driver ->
                driver.findElement(menuWrap)
                        .getAttribute("class")
                        .contains("bm-menu-wrap")
        );

        // Tunggu logout visible & clickable
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutMenu));

        // Klik logout (JS biar aman)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);

    }

//    ("user will redirect back to login page")
    public void userWillRedirectBackToLoginPage() {
        // Test using wrong username, and need to redirect back to login page
        String webPageTitle = driver.getTitle();
        Assert.assertEquals("Swag Labs", webPageTitle);
    }

//    ("user see error message")
    public void userSeeErrorMessage() {
        // When test using wrong username, it will return error notification
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By errorMessage = By.cssSelector("[data-test='error']");

        String actualError = wait
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessage))
                .getText();

        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", actualError);

    }
}
