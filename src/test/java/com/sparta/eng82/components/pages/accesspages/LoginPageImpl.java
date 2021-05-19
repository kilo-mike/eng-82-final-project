package com.sparta.eng82.components.pages.accesspages;

import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class LoginPageImpl implements LoginPage {
    WebDriver driver;
    Properties properties = new Properties();
    String usernamesPasswordFileLocation = "src/test/resources/login.properties";
    private final By emailTextBox = new By.ById("username");
    private final By passwordTextBox = new By.ById("password");
    private final By loginButton = new By.ById("loginBtn");

    public LoginPageImpl(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public LoginPage enterEmail(String whosEmail) {
        try {
            properties.load(new java.io.FileReader(usernamesPasswordFileLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.findElement(emailTextBox).sendKeys(properties.getProperty(whosEmail));
        return new LoginPageImpl(driver);
    }

    @Override
    public LoginPage enterPassword(String whosPassword) {
        try {
            properties.load(new java.io.FileReader(usernamesPasswordFileLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.findElement(passwordTextBox).sendKeys(properties.getProperty(whosPassword));
        return new LoginPageImpl(driver);
    }

    @Override
    public Page login() {//TODO still needs to be implemented
        return null;
    }

    @Override
    public boolean loginAttempt(String whosEmail, String whosPassword) {
        boolean isLoggedIn = false;
        enterEmail(whosEmail);
        enterPassword(whosPassword);
        if(driver.getCurrentUrl().equals("http://localhost:8080/")){
            isLoggedIn = true;
        }
        return isLoggedIn;
    }

    @Override
    public boolean isLogoutMessageShowing() {
        boolean isMessageShowing = false;
        if(getUrl(driver).equals("http://localhost:8080/login?logout")){
            isMessageShowing = true;
        }
        return isMessageShowing;
    }
}
