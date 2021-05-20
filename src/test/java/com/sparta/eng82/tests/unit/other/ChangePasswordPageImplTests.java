package com.sparta.eng82.tests.unit.other;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminProfilePageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import com.sparta.eng82.interfaces.pages.navpages.admin.AdminHomePage;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
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

    private final String passwordChange = "hello";
    static Properties properties;

    @BeforeAll
    static void setupAll() {
        properties = new Properties();
        Utility.loadProperties(properties);
    }

    @BeforeEach
    void setup(){
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
        loginPage = new LoginPageImpl(driver);
        adminHomePageImpl = new AdminHomePageImpl(driver);
        adminProfilePage = new AdminProfilePageImpl(driver);
    }


    @Test
    @DisplayName("Checking if the number of dots that pop up in current is the same as the the number of characters typed")
    void isTheNumberOfDotsThatPopUpInCurrentPasswordTheSameAsTheNumberOfCharactersTyped() {
        loginPage.enterEmail(driver, adminPropertyUsername, properties)
                .enterPassword(driver, adminPropertyPassword, properties)
                .login(driver, adminPropertyName);
        adminHomePageImpl.goToProfilePage(driver).changePassword(driver, adminProfilePage).enterCurrentPassword(properties.getProperty(adminPropertyPassword));
        //Go to profile method doesn't work TODO GO TO PROFILE NEEDS TO BE FIXED
        Assertions.assertEquals(properties.getProperty(adminPropertyPassword).length(), driver.findElement(By.name("currentPassword")).getAttribute("value").length());
    }

    @Test
    @DisplayName("Is the number of dots in new password equivalent to the length of the password")
    void isTheNumberOfDotsInNewPasswordEquivalentToTheLengthOfThePassword() {
        loginPage.enterEmail(driver, adminPropertyUsername, properties)
                .enterPassword(driver, adminPropertyPassword, properties)
                .login(driver, properties.getProperty(adminPropertyName));
        adminHomePageImpl.goToProfilePage(driver).changePassword(driver, adminProfilePage).enterNewPassword(passwordChange);
        Assertions.assertEquals(passwordChange.length(), driver.findElement(By.name("newPassword")).getAttribute("value").length());
    }

    @Test
    @DisplayName("Is the number of dots in confirm password equivalent to the length of the password")
    void isTheNumberOfDotsInConfirmPasswordEquivalentToTheLengthOfThePassword() {
        loginPage.enterEmail(driver, adminPropertyUsername, properties)
                .enterPassword(driver, adminPropertyPassword, properties)
                .login(driver, properties.getProperty(adminPropertyName));
        adminHomePageImpl.goToProfilePage(driver).changePassword(driver, adminProfilePage).enterCurrentPassword(passwordChange);
        Assertions.assertEquals(passwordChange.length(), driver.findElement(By.name("confirmPassword")).getAttribute("value").length());
    }


}
