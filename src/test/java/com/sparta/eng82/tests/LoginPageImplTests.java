package com.sparta.eng82.tests;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.accesspages.LogoutPageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.frameworkutil.PropertiesLoader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageImplTests {

    private static WebDriverFactory webDriverFactory;
    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Enter email test")
    void enterEmailTest(String user) {
        new LoginPageImpl(driver, user).enterEmail();
        Assertions.assertEquals(PropertiesLoader.loadProperties().getProperty(), driver.findElement(new By.ById("username")).getAttribute("value"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin_password", "trainer_password", "trainee_password"})
    @DisplayName("Enter password test")
    void enterPasswordTest(String propertyPassword) {
        loginPage.enterPassword(driver, propertyPassword, properties);
        Assertions.assertEquals(properties.getProperty(propertyPassword), driver.findElement(new By.ById("password")).getAttribute("value"));

    }

    @ParameterizedTest
    @ValueSource(strings = {"admin_name", "trainer_name", "trainee_name"})
    @DisplayName("Login test")
    void loginTest(String propertyName) {
        Assertions.assertNull(loginPage.login(driver, properties.getProperty(propertyName)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Login test with entered email and password")
    void loginTestWithEnteredEmailAndPassword(String user) {
        loginPage.enterEmail(driver, user, properties)
                .enterPassword(driver, user, properties)
                .login(driver, user);
        Assertions.assertFalse(driver.getCurrentUrl().endsWith("/login"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Login attempt test")
    void loginAttemptTest(String user) {
        Assertions.assertTrue(loginPage.loginAttempt(driver, user + "_name", user + "_username", user + "_password", properties));
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Wrong password attempt test")
    void wrongPasswordAttemptTest(String user) {
        Assertions.assertTrue(loginPage.wrongPasswordAttempt(driver, user + "_name", user + "_username", "this-must-be-wrong-123", properties));
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Logout check message")
    void logoutCheckMessage(String user) {

        // TODO login should take in driver and user ONCE
        //new LoginPageImpl(driver, user).enterEmail().enterPassword()...

        new LoginPageImpl(driver, user).enterEmail()
                .enterPassword()
                .login()
                .logOut();

        switch (user) {
            case "admin":
                logoutPage = (LogoutPageImpl) adminHomePage.logOut(driver);
                break;
            case "trainer":
                logoutPage = (LogoutPageImpl) trainerHomePage.logOut(driver);
                break;
            case "trainee":
                logoutPage = (LogoutPageImpl) traineeHomePage.logOut(driver);
                break;
        }

        Assertions.assertTrue(logoutPage.isLogoutMessageShowing());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @AfterAll
    static void tearDownAll() {
        webDriverFactory.endAllServices();
    }
}
