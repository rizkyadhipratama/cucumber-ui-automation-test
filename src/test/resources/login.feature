Feature: Login
  @valid-login
  Scenario: Login with valid username and password
    Given user is on login page
    When user input username text box with "standard_user"
    And user input password pada text box with "secret_sauce"
    Then user click submit
    Then user will redirect to homepage
    Then user logout

  @invalid-login
  Scenario: Login with invalid username and password
    Given user is on login page
    When user input username text box with "standard_user"
    And user input password pada text box with "secret_invalid"
    Then user click submit
    Then user will redirect back to login page
    And user see error message
