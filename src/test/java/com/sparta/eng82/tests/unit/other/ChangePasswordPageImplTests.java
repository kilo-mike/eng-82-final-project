package com.sparta.eng82.tests.unit.other;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ChangePasswordPageImplTests {

    private static Properties properties;
    private static WebDriverFactory webDriverFactory;
    private final String password = "password";
    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";
    private final String adminPropertyName = "admin_name";
    private final String passwordChange = "hello";
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
        properties = new Properties();
        Utility.loadProperties(properties);
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
        loginPage = new LoginPageImpl(driver);
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check length of hidden password characters matches actual password length")
    void numberOfCharactersPasswordCorrect(String user) {
        loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToProfilePage(driver)
                .changePassword(driver)
                .enterCurrentPassword(password);

        Assertions.assertEquals(password.length(), driver.findElement(By.name("currentPassword")).getAttribute("value").length());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

//    @Test
//    @DisplayName("Checking if the number of dots that pop up in current is the same as the the number of characters typed")
//    void isTheNumberOfDotsThatPopUpInCurrentPasswordTheSameAsTheNumberOfCharactersTyped() {
//        loginPage.enterEmail(driver, adminPropertyUsername, properties)
//                .enterPassword(driver, adminPropertyPassword, properties)
//                .login(driver, adminPropertyName);
//        adminHomePageImpl.goToProfilePage(driver).changePassword(driver, adminProfilePage).enterCurrentPassword(properties.getProperty(adminPropertyPassword));
//        //Go to profile method doesn't work TODO GO TO PROFILE NEEDS TO BE FIXED
//        Assertions.assertEquals(properties.getProperty(adminPropertyPassword).length(), driver.findElement(By.name("currentPassword")).getAttribute("value").length());
//    }
//
//    @Test
//    @DisplayName("Is the number of dots in new password equivalent to the length of the password")
//    void isTheNumberOfDotsInNewPasswordEquivalentToTheLengthOfThePassword() {
//        loginPage.enterEmail(driver, adminPropertyUsername, properties)
//                .enterPassword(driver, adminPropertyPassword, properties)
//                .login(driver, properties.getProperty(adminPropertyName));
//        adminHomePageImpl.goToProfilePage(driver).changePassword(driver, adminProfilePage).enterNewPassword(passwordChange);
//        Assertions.assertEquals(passwordChange.length(), driver.findElement(By.name("newPassword")).getAttribute("value").length());
//    }
//
//    @Test
//    @DisplayName("Is the number of dots in confirm password equivalent to the length of the password")
//    void isTheNumberOfDotsInConfirmPasswordEquivalentToTheLengthOfThePassword() {
//        loginPage.enterEmail(driver, adminPropertyUsername, properties)
//                .enterPassword(driver, adminPropertyPassword, properties)
//                .login(driver, properties.getProperty(adminPropertyName));
//        adminHomePageImpl.goToProfilePage(driver).changePassword(driver, adminProfilePage).enterCurrentPassword(passwordChange);
//        Assertions.assertEquals(passwordChange.length(), driver.findElement(By.name("confirmPassword")).getAttribute("value").length());
//    }
}
