package com.appium.step_def;

import com.appium.utils.ConfigurationFileReader;
import com.appium.utils.SingletonDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Hooks {
    public static AppiumDriverLocalService service;

    @Before
    public void setupMethod() {
        //TODO setup for mobile
        service = new AppiumServiceBuilder().withAppiumJS(new File(ConfigurationFileReader.getProperty("mainJS"))).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
    }

    @After
    public void teardownMethod(Scenario scenario) throws InterruptedException, MalformedURLException, URISyntaxException {

        //TODO adapt screenshot method to mobile
//        if (scenario.isFailed()) {
//
//            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
//        }

        //TODO wait and close driver

        SingletonDriver.getInstance().getDriver().close();
    }
}

