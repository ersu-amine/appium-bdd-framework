package com.appium.utils;

import org.apiguardian.api.API;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {
    public static final String PLATFORM_VERSION;
    public static final String DEVICE_NAME;
    //public static final String APP_PACKAGE;
    //public static final String APP_ACTIVITY;

    static {
        Properties properties = null;
        String environment = System.getProperty("environment") != null ? System.getProperty("environment") : ConfigurationFileReader.getProperty("environment");

        try {
            //path of environment properties file
            String path = System.getProperty("user.dir") + "/src/test/resources/environments/" + environment + ".properties";

            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PLATFORM_VERSION = properties.getProperty("platformName");
        DEVICE_NAME = properties.getProperty("deviceName");

    }
}
