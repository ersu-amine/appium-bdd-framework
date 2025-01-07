package com.appium.step_def;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

        @Before
        public void setupMethod() {
            //TODO setup for mobile
        }

        @After
        public void teardownMethod(Scenario scenario) throws InterruptedException {

            //TODO adapt screenshot method to mobile
//        if (scenario.isFailed()) {
//
//            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
//        }

            //TODO wait and close driver
        }
    }

