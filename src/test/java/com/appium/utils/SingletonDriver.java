package com.appium.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

public class SingletonDriver {

    //AppiumDriver<MobileElement> is deprecated
    //instance of mobile driver
    private static AppiumDriver driver;
    private static URL url;

    private SingletonDriver()  {
//        String platform = ConfigurationFileReader.getProperty("platform");
//        switch (platform) {
//            case "android":
//                UiAutomator2Options options = new UiAutomator2Options();
//                options.setDeviceName(ConfigurationFileReader.getProperty("platformName"));
//                options.setApp("/Users/michealthonton/IdeaProjects/cucumber-appium/src/test/resources/apps/ApiDemosDebug.apk");
//
//                driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//
//
//                uri = new URI("http://127.0.0.1:4723");
//
//                driver = new AndroidDriver(uri.toURL(), options);
//
//                break;
//
//            case "IOS":
//                XCUITestOptions IOSoptions = new XCUITestOptions();
//                IOSoptions.setDeviceName("FirstPhone");
//                IOSoptions.setApp("/Users/michealthonton/IdeaProjects/cucumber-appium/src/test/resources/apps/UIKitCatalog.app");
//                IOSoptions.setPlatformVersion("18.2");
//                IOSoptions.setWdaLaunchTimeout(Duration.ofSeconds(15));
//
//                driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), IOSoptions);
//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//                break;
//        }

    }

    public static AppiumDriver getDriver(String platform){
        String platformName = ConfigurationFileReader.getProperty(platform);
        //create driver if it is null
        if (Objects.isNull(driver)) {
            switch (platformName) {
                case "android-native":
                    UiAutomator2Options options = new UiAutomator2Options();
                    options.setApp(ConfigurationFileReader.getProperty("android-app"));
                    try {
                        // Create URI and convert to URL
                        url =  new URI("http://127.0.0.1:4723").toURL();
                    } catch (Exception e) {
                        // Handle both URISyntaxException and MalformedURLException
                        throw new IllegalArgumentException("Invalid URI or URL: " +  e);
                    }
                    driver = new AndroidDriver(url, options);
                    break;

                case "IOS-native":
                    XCUITestOptions optionsIOS = new XCUITestOptions();
                    optionsIOS.setApp(ConfigurationFileReader.getProperty("IOS-app"));
                    try {
                        // Create URI and convert to URL
                        url =  new URI("http://127.0.0.1:4723").toURL();
                    } catch (Exception e) {
                        // Handle both URISyntaxException and MalformedURLException
                        throw new IllegalArgumentException("Invalid URI or URL: " +  e);
                    }

                    driver = new IOSDriver(url, optionsIOS);
                    break;
            }
        }
        //return existing or newly made driver
        return driver;
    }
}



