package com.febrio.stepdef;

import com.febrio.page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.febrio.Hooks.driver;


public class LoginStepDef {

    LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.userIsOnLoginPage();
    }

    @When("user input username text box with {string}")
    public void userInputUsernameTextBoxWith(String username) {
        loginPage.userInputUsernameTextBoxWith(username);
    }

    @And("user input password pada text box with {string}")
    public void userInputPasswordPadaTextBoxWith(String password) {
        loginPage.userInputPasswordPadaTextBoxWith(password);    }

    @Then("user click submit")
    public void userClickSubmit() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.userClickSubmit();
    }

    @Then("user will redirect to homepage")
    public void userWillRedirectToHomepage() {
        // User will redirect to homepage if login success
        loginPage.userWillRedirectToHomepage();
    }

    @Then("user logout")
    public void userLogout() {
        loginPage.userLogout();
    }

    @Then("user will redirect back to login page")
    public void userWillRedirectBackToLoginPage() {
        loginPage.userWillRedirectBackToLoginPage();
    }

    @And("user see error message")
    public void userSeeErrorMessage() {
    loginPage.userSeeErrorMessage();

    }


}
