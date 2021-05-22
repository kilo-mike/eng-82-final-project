package refactor.tests.unit.other;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.frameworkutil.WebDriverFactory;
import refactor.components.frameworkutil.WebDriverTypes;
import refactor.components.pages.other.LoginPageImpl;

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

//
//    @ParameterizedTest
//    @ValueSource(strings = {"admin", "trainer", "trainee"})
//    @DisplayName("Check length of new password")
//    void checkLengthOfNewPassword(String user) {
//        loginPage.enterEmail(driver, user + "_username", properties)
//                .enterPassword(driver, user + "_password", properties)
//                .login(driver, user + "_name")
//                .goToProfilePage(driver)
//                .changePassword(driver)
//                .enterNewPassword(password);
//
//        Assertions.assertEquals(password.length(), driver.findElement(byNewPassword).getAttribute("value").length());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"admin", "trainer", "trainee"})
//    @DisplayName("Check length of confirmed password")
//    void checkLengthOfConfirmedPassword(String user) {
//        loginPage.enterEmail(driver, user + "_username", properties)
//                .enterPassword(driver, user + "_password", properties)
//                .login(driver, user + "_name")
//                .goToProfilePage(driver)
//                .changePassword(driver)
//                .enterConfirmPassword(password);
//
//        Assertions.assertEquals(password.length(), driver.findElement(byConfirmPassword).getAttribute("value").length());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"admin", "trainer", "trainee"})
//    @DisplayName("Change password")
//    void changePassword(String user) {
//        loginPage.enterEmail(driver, user + "_username", properties)
//                .enterPassword(driver, user + "_password", properties)
//                .login(driver, user + "_name")
//                .goToProfilePage(driver)
//                .changePassword(driver)
//                .enterCurrentPassword(password)
//                .enterNewPassword(password)
//                .enterConfirmPassword(password)
//                .clickChange(user);
//
//        Assertions.assertTrue(driver.getCurrentUrl().endsWith("/"));
//    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
