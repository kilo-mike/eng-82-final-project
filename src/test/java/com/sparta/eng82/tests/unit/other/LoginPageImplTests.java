package com.sparta.eng82.tests.unit.other;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.accesspages.LogoutPageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPageImplTests {

    private WebDriver driver;
    private static WebDriverFactory webDriverFactory;

    private LoginPageImpl loginPage;
    private LogoutPageImpl logoutPage;
    private AdminHomePageImpl adminHomePage;
    private TrainerHomePageImpl trainerHomePage;
    private TraineeHomePageImpl traineeHomePage;

    private static Properties properties;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
        properties = new Properties();
        Utility.loadProperties(properties);
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        loginPage = new LoginPageImpl(driver);
        logoutPage = new LogoutPageImpl(driver);


        adminHomePage = new AdminHomePageImpl(driver);
        trainerHomePage = new TrainerHomePageImpl(driver);
        traineeHomePage = new TraineeHomePageImpl(driver);
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin_username", "trainer_username", "trainee_username"})
    @DisplayName("Enter email test")
    void enterEmailTest(String propertyUsername) {
        loginPage.enterEmail(driver, propertyUsername, properties);
        Assertions.assertEquals(properties.getProperty(propertyUsername), driver.findElement(new By.ById("username")).getAttribute("value"));
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
        loginPage.enterEmail(driver, user + "_username", properties);
        loginPage.enterPassword(driver, user + "_password", properties);
        loginPage.login(driver, properties.getProperty(user + "_name"));
        Assertions.assertFalse(driver.getCurrentUrl().endsWith("/login"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Logout check message")
    void logoutCheckMessage(String user) {
        loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, properties.getProperty(user + "_name"));

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
}
