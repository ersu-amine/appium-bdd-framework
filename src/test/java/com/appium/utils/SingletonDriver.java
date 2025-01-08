package com.appium.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class SingletonDriver {
    //singleton instance of driver
    private static SingletonDriver instance = null;

    //AppiumDriver<MobileElement> is deprecated
    //instance of mobile driver
    private AppiumDriver driver;
    private static URI uri;

    private SingletonDriver() throws URISyntaxException, MalformedURLException {
        String platform = ConfigurationFileReader.getProperty("platform");
            switch (platform) {
                case "android":
                    UiAutomator2Options options = new UiAutomator2Options();
                    options.setDeviceName(ConfigurationFileReader.getProperty("platformName"));
                    options.setApp("/Users/michealthonton/IdeaProjects/cucumber-appium/src/test/resources/apps/ApiDemosDebug.apk");

                    driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    
                    
                    uri = new URI("http://127.0.0.1:4723");
                   
                    driver = new AndroidDriver(uri.toURL(), options);

                    break;

                case "IOS":
                    XCUITestOptions IOSoptions = new XCUITestOptions();
                    IOSoptions.setDeviceName("FirstPhone");
                    IOSoptions.setApp("/Users/michealthonton/IdeaProjects/cucumber-appium/src/test/resources/apps/UIKitCatalog.app");
                    IOSoptions.setPlatformVersion("18.2");
                    IOSoptions.setWdaLaunchTimeout(Duration.ofSeconds(15));

                    driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), IOSoptions);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                    break;
            }

    }

    public static SingletonDriver getInstance() throws MalformedURLException, URISyntaxException {
        if (instance == null) {
            instance = new SingletonDriver();
        }
        return instance;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

}



