package com.sparta.eng82.components.pages.accesspages;

import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LogoutPageImpl implements LoginPage {

    private WebDriver driver;

    public LogoutPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoutMessageShowing() {
        return getUrl(driver).endsWith("?logout");
    }
}
