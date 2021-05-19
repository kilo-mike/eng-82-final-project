package com.sparta.eng82.components.pages.navpages.admin;

import com.sparta.eng82.interfaces.pages.navpages.ProfilePage;
import org.openqa.selenium.WebDriver;

public class AdminProfilePageImpl implements ProfilePage {

    WebDriver driver;

    public AdminProfilePageImpl(WebDriver driver) {
        this.driver = driver;
    }
}
