package com.sparta.eng82.tests.unit.other;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminProfilePageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import com.sparta.eng82.interfaces.pages.navpages.admin.AdminHomePage;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ChangePasswordPageImplTests {
    private WebDriverFactory webDriverFactory;
    private WebDriver driver;
    private LoginPage loginPage;
    private AdminHomePageImpl adminHomePageImpl;
    private AdminProfilePageImpl adminProfilePage;


    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";
    private final String adminPropertyName = "admin_name";
    static Properties properties;

    @BeforeAll
    static void setupAll() {
        properties = new Properties();
        Utility.loadProperties(properties);
    }

    @BeforeEach
    void setup(){
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        loginPage = new LoginPageImpl(driver);
        adminHomePageImpl = new AdminHomePageImpl(driver);
        adminProfilePage = new AdminProfilePageImpl(driver);
    }

    // Doesn't work
    @Test
    @DisplayName("Checking if the number of dots that pop up is the same as the the number of characters typed")
    void isTheNumberOfDotsThatPopUpTheSameAsTheTheNumberOfCharactersTyped() {
        loginPage.enterEmail(adminPropertyUsername, properties)
                .enterPassword(adminPropertyPassword, properties)
                .login(properties.getProperty(adminPropertyName));
        adminHomePageImpl.navigateToProfile().changePassword(driver, adminProfilePage);
    }


}
