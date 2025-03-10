Feature: As a user I should be able to login

  Scenario Outline: Verify successful user login to app on android, ios platforms
    When User navigates to login page on "<platform>" platform
    And User logins with valid credentials
    Then User verifies landing on the product page

    Examples:
    |platform|
    |platformA|
    |platformB|