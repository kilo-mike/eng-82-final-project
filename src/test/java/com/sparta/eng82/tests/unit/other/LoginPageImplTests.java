package com.sparta.eng82.tests.unit.other;


import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPageImplTests {

    private WebDriver driver;
    private WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;
    private AdminHomePageImpl adminHomePage;

    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";
    private final String adminPropertyName = "admin_name";

    private static Properties properties;

    @BeforeAll
    static void setupAll() {
        properties = new Properties();
        Utility.loadProperties(properties);
    }

    @BeforeEach
    void setup() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        loginPage = new LoginPageImpl(driver);
        adminHomePage = new AdminHomePageImpl(driver);
    }

    @Test
    @DisplayName("Enter email test")
    void enterEmailTest() {
        loginPage.enterEmail(adminPropertyUsername, properties);
        Assertions.assertEquals(properties.getProperty(adminPropertyUsername), driver.findElement(new By.ById("username")).getAttribute("value"));
    }

    @Test
    @DisplayName("Enter password test")
    void enterPasswordTest() {
        loginPage.enterPassword(adminPropertyPassword, properties);
        Assertions.assertEquals(properties.getProperty(adminPropertyPassword), driver.findElement(new By.ById("password")).getAttribute("value"));

    }

    @Test
    @DisplayName("Login test")
    void loginTest() {
        Assertions.assertNull(loginPage.login(properties.getProperty(adminPropertyName)));
    }

    @Test
    @DisplayName("Login test with entered email and password")
    void loginTestWithEnteredEmailAndPassword() {
        loginPage.enterEmail(adminPropertyUsername, properties);
        loginPage.enterPassword(adminPropertyPassword, properties);
        loginPage.login(properties.getProperty(adminPropertyName));
        Assertions.assertFalse(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    @DisplayName("Login attempt test")
    void loginAttemptTest() {
        Assertions.assertTrue(loginPage.loginAttempt(adminPropertyName, adminPropertyUsername, adminPropertyPassword, properties));
    }

    @Test
    @DisplayName("Logout check message")
    void logoutCheckMessage() {
        loginPage.enterEmail(adminPropertyUsername, properties)
                .enterPassword(adminPropertyPassword, properties)
                .login(properties.getProperty(adminPropertyName));

        loginPage = (LoginPageImpl) adminHomePage.logOut(driver);

        Assertions.assertTrue(loginPage.isLogoutMessageShowing());
    }

//    @AfterEach
//    void tearDown() {
//        driver.quit();
//    }
}
