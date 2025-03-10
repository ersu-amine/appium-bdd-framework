package com.appium.step_def;

import com.appium.utils.SingletonDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
    @When("User navigates to login page on {string} platform")
    public void user_navigates_to_login_page_on_platform(String platformType) {
        SingletonDriver.getDriver(platformType);
    }
    @And("User logins with valid credentials")
    public void user_logins_with_valid_credentials() {
        //TODO login
    }
    @Then("User verifies landing on the product page")
    public void user_verifies_landing_on_the_product_page() {
        //TODO assertion
    }
}
