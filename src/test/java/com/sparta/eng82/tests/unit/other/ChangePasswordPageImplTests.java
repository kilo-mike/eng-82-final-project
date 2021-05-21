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

    private final By byCurrentPassword = By.name("currentPassword");
    private final By byNewPassword = By.name("newPassword");
    private final By byConfirmPassword = By.name("confirmPassword");

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
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        loginPage = new LoginPageImpl(driver);
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check length of hidden password characters matches actual current password length")
    void numberOfCharactersCurrentPasswordCorrect(String user) {
        loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToProfilePage(driver)
                .changePassword(driver)
                .enterCurrentPassword(password);

        Assertions.assertEquals(password.length(), driver.findElement(byCurrentPassword).getAttribute("value").length());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check length of new password")
    void checkLengthOfNewPassword(String user) {
        loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToProfilePage(driver)
                .changePassword(driver)
                .enterNewPassword(password);

        Assertions.assertEquals(password.length(), driver.findElement(byNewPassword).getAttribute("value").length());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check length of confirmed password")
    void checkLengthOfConfirmedPassword(String user) {
        loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToProfilePage(driver)
                .changePassword(driver)
                .enterConfirmPassword(password);

        Assertions.assertEquals(password.length(), driver.findElement(byConfirmPassword).getAttribute("value").length());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Change password")
    void changePassword(String user) {
        loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToProfilePage(driver)
                .changePassword(driver)
                .enterCurrentPassword(password)
                .enterNewPassword(password)
                .enterConfirmPassword(password)
                .clickChange(user);

        Assertions.assertTrue(driver.getCurrentUrl().endsWith("/"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
