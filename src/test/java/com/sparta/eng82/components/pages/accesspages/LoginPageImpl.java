package com.sparta.eng82.components.pages.accesspages;

import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginPageImpl implements LoginPage {

    private final WebDriver driver;

    public LoginPageImpl(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:8080/login");
    }
}
