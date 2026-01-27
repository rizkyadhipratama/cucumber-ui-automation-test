UI Automation Testing With Cucumber

Application test: https://www.saucedemo.com/

Scenario Test:
  Scenario: Login with valid username and password
    (1) Given user is on login page
    (2) When user input username text box with "standard_user"
    (3) And user input password pada text box with "secret_sauce"
    (4) Then user click submit
    (5) Then user will redirect to homepage
    (6) Then user logout

  Scenario: Login with invalid username and password
    (1) Given user is on login page
    (2) When user input username text box with "standard_user"
    (3) And user input password pada text box with "secret_invalid"
    (4) Then user click submit
    (5) Then user will redirect back to login page
    (6) And user see error message

  Scenario: User Checkout The Item
    (1) Given user is on login page for checkout
    (2) When user input username text box with "standard_user" for checkout
    (3) And user input password pada text box with "secret_sauce" for checkout
    (4) Then user click submit for checkout
    (5) Then user will redirect to homepage for checkout
    (6) Given user in homepage
    (7) Then user click add to cart button for specific product
    (8) Then user click cart icon
    (9) Given user click checkout button
    (10) When user input first name with "swag" and last name with "labs" and postal code with "1234"
    (11) Then user click continue
    Given user in checkout overview page
    Then user click finish
