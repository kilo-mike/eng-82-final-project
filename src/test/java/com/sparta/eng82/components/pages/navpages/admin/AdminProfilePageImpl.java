package com.sparta.eng82.components.pages.navpages.admin;

import com.sparta.eng82.interfaces.pages.accesspages.ChangePasswordPage;
import com.sparta.eng82.interfaces.pages.navpages.ProfilePage;
import com.sparta.eng82.interfaces.pages.navpages.admin.AdminHomePage;
import org.openqa.selenium.WebDriver;

public class AdminProfilePageImpl implements ProfilePage {

    WebDriver driver;

    public AdminProfilePageImpl(WebDriver driver) {
        this.driver = driver;
    }
}
