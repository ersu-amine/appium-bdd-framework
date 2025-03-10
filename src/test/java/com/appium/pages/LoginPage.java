package com.appium.pages;

import com.appium.utils.SingletonDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(String platform){
        PageFactory.initElements(SingletonDriver.getDriver(platform),this);
    }

    public void login(){
        //TODO implement login to swaglabs
    }
}
