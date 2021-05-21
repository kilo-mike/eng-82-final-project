package refactor.tests;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import refactor.NavPage;
import refactor.frameworkutil.PropertiesLoader;
import refactor.frameworkutil.WebDriverFactory;
import refactor.frameworkutil.WebDriverTypes;
import refactor.pages.LoginPageImpl;

public class LoginPageImplTests {

    private static WebDriverFactory webDriverFactory;
    private WebDriver driver;
    private LoginPageImpl loginPage;

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
        loginPage = new LoginPageImpl(driver, user).driverGet().enterEmail();
        Assertions.assertEquals(PropertiesLoader.getEmail(user), loginPage.getEmailInputValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Enter password test")
    void enterPasswordTest(String user) {
        loginPage = new LoginPageImpl(driver, user).driverGet().enterPassword();
        Assertions.assertEquals(PropertiesLoader.getPassword(user), loginPage.getPasswordInputValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Login test")
    void loginTest(String user) {
        NavPage navPage = new LoginPageImpl(driver, user).driverGet().clickLogin();
        Assertions.assertFalse(navPage.isOnHomePage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Login test with entered email and password")
    void loginTestWithEnteredEmailAndPassword(String user) {
        NavPage navPage = new LoginPageImpl(driver, user).driverGet().enterEmail()
                .enterPassword()
                .clickLogin();

        Assertions.assertTrue(navPage.isOnHomePage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Login attempt test")
    void loginAttemptTest(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user).driverGet().loginAttempt());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Wrong password attempt test")
    void wrongPasswordAttemptTest(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user).driverGet().wrongPasswordAttempt("this-has-to-be-wrong"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Logout check message")
    void logoutCheckMessage(String user) {
        loginPage = new LoginPageImpl(driver, user).driverGet().enterEmail()
                .enterPassword()
                .clickLogin()
                .logOut();

        Assertions.assertTrue(loginPage.isLogoutMessageShowing());
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
