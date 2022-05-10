Feature: Login page feature

  Scenario: Login page title
    Given User is on login page
    When user gets page title
    Then page title should be "Login - My Store"

  Scenario: Forgot password link
    Given User is on login page
    Then password forgot link should be displayed

  Scenario: Login page title
    Given User is on login page
    When user enters username as "pkrocks412@gmail.com"
    And user enters password as "Selenium@1234"
    And User clicks on login button
    And user gets page title
    Then page title should be "My account - My Store1"
