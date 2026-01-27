package com.febrio.stepdef;

import com.febrio.Hooks;
import com.febrio.page.CartPage;
import com.febrio.page.CheckoutPage;
import com.febrio.page.HomePage;
import com.febrio.page.LoginPage;
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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("user is on login page for checkout")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.userIsOnLoginPage();
    }

    @When("user input username text box with {string} for checkout")
    public void userInputUsernameTextBoxWith(String username) {
        loginPage.userInputUsernameTextBoxWith(username);
    }

    @And("user input password pada text box with {string} for checkout")
    public void userInputPasswordPadaTextBoxWith(String password) {
        loginPage.userInputPasswordPadaTextBoxWith(password);

    }

    @Then("user click submit for checkout")
    public void userClickSubmit() {
        loginPage.userClickSubmit();
    }

    @Then("user will redirect to homepage for checkout")
    public void userWillRedirectToHomepage() {
        loginPage.userWillRedirectBackToLoginPage();
    }


    @Given("user in homepage")
    public void userInHomepage() {
        homePage = new HomePage(driver);
        homePage.userInHomepage();
    }

    @Then("user click add to cart button for specific product")
    public void userClickAddToCartButtonForSpecificProduct() {
        cartPage = new CartPage(driver);
        cartPage.userClickAddToCartButtonForSpecificProduct();
    }

    @Then("user click cart icon")
    public void userClickCartIcon() {
        cartPage.userClickCartIcon();
    }

    @When("user click checkout button")
    public void userClickCheckoutButton() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.userClickCheckoutButton();
    }

    @When("user input first name with {string} and last name with {string} and postal code with {string}")
    public void userInputFirstNameWithAndLastNameWithAndPostalCodeWith(String firstName, String lastName, String postalCode) {
        checkoutPage.userInputFirstNameWithAndLastNameWithAndPostalCodeWith(firstName, lastName, postalCode);
    }

    @Then("user click continue")
    public void userClickContinue() {
        checkoutPage.userClickContinue();

    }

    @Given("user in checkout overview page")
    public void userInCheckoutOverviewPage() {
        checkoutPage.userInCheckoutOverviewPage();

    }

    @Then("user click finish")
    public void userClickFinish() {
        checkoutPage.userClickFinish();
    }
}
