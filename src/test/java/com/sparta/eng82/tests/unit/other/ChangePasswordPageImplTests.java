package com.sparta.eng82.tests.unit.other;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.other.LoginPageImpl;

public class ChangePasswordPageImplTests {

    private static WebDriverFactory webDriverFactory;
    private final String password = "password";

    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
    }

    @AfterAll
    static void tearDownAll() {
        webDriverFactory.endAllServices();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check length of hidden password characters matches actual current password length")
    void numberOfCharactersCurrentPasswordCorrect(String user) {
        Assertions.assertEquals(password.length(), new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToProfilePage()
                .goToChangePasswordPage()
                .enterCurrentPassword(password)
                .lengthOfCurrentPasswordInputValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check length of new password")
    void checkLengthOfNewPassword(String user) {
        Assertions.assertEquals(password.length(), new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToProfilePage()
                .goToChangePasswordPage()
                .enterNewPassword(password)
                .lengthOfNewPasswordInputValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check length of confirmed password")
    void checkLengthOfConfirmedPassword(String user) {
        Assertions.assertEquals(password.length(), new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToProfilePage()
                .goToChangePasswordPage()
                .enterConfirmPassword(password)
                .lengthOfConfirmPasswordInputValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Change password")
    void changePassword(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToProfilePage()
                .goToChangePasswordPage()
                .enterCurrentPassword()
                .enterNewPassword(password)
                .enterConfirmPassword(password)
                .clickChange(user)
                .isOnHomePage());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
