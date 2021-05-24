package refactor.tests.unit.other;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import refactor.components.frameworkutil.PropertiesLoader;
import refactor.components.frameworkutil.WebDriverFactory;
import refactor.components.frameworkutil.WebDriverTypes;
import refactor.components.pages.other.LoginPageImpl;

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
        Assertions.assertEquals(PropertiesLoader.getEmail(user), new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .getEmailInputValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Enter password test")
    void enterPasswordTest(String user) {
        Assertions.assertEquals(PropertiesLoader.getPassword(user), new LoginPageImpl(driver, user)
                .driverGet()
                .enterPassword()
                .getPasswordInputValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Login test")
    void loginTest(String user) {
        Assertions.assertFalse(new LoginPageImpl(driver, user)
                .driverGet()
                .clickLogin()
                .isOnHomePage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Login test with entered email and password")
    void loginTestWithEnteredEmailAndPassword(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .isOnHomePage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Login attempt test")
    void loginAttemptTest(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user)
                .driverGet()
                .loginAttempt());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Wrong password attempt test")
    void wrongPasswordAttemptTest(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user)
                .driverGet()
                .wrongPasswordAttempt("this-has-to-be-wrong"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Logout check message")
    void logoutCheckMessage(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user).driverGet().enterEmail()
                .enterPassword()
                .clickLogin()
                .logOut()
                .isLogoutMessageShowing());
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
