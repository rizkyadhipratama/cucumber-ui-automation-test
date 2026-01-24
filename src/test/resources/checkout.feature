@checkout
Feature: checkout
Scenario: User Checkout The Item
Given user is on login page for checkout
When user input username text box with "standard_user" for checkout
And user input password pada text box with "secret_sauce" for checkout
Then user click submit for checkout
Then user will redirect to homepage for checkout
Given user in homepage
Then user click add to cart button for specific product
Then user click cart icon
Given user click checkout button
When user input first name with "swag" and last name with "labs" and postal code with "1234"
Then user click continue
Given user in checkout overview page
Then user click finish