package refactor.tests.unit.admin;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import refactor.components.frameworkutil.WebDriverFactory;
import refactor.components.frameworkutil.WebDriverTypes;
import refactor.components.pages.admin.AdminHomePageImpl;
import refactor.components.pages.admin.AdminProfilePageImpl;
import refactor.components.pages.other.ChangePasswordPageImpl;
import refactor.components.pages.other.LoginPageImpl;

import java.util.Properties;

public class AdminProfilePageTests {
    private static Properties properties;
    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";
    private final String adminPropertyName = "admin_name";
    private final String adminName = "ROLE_ADMIN";
    private WebDriver driver;
    private static WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;
    private AdminHomePageImpl adminHomePage;
    private AdminProfilePageImpl adminProfilePage;

    private ChangePasswordPageImpl changePasswordPage;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
    }


    @Test
    @DisplayName("Get admin name")
    void getAdminName() {


        Assertions.assertEquals(adminName, new LoginPageImpl(driver, "admin").driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToProfilePage().getName());
    }

//
//    @Test
//    @DisplayName("Get admin email")
//    void getAdminEmail() {
//        loginPage.enterEmail(driver, adminPropertyUsername, properties);
//        loginPage.enterPassword(driver, adminPropertyPassword, properties);
//        loginPage.login(driver, properties.getProperty(adminPropertyName));
//        adminProfilePage = (AdminProfilePageImpl) adminHomePage.goToProfilePage(driver);
//        Assertions.assertEquals("admin@sparta.com", adminProfilePage.getEmail(driver));
//    }
//
//
//    @Test
//    @DisplayName("Check admin profile name matches with properties file name")
//    void checkAdminProfileNameMatchesWithPropertiesFileName() {
//        loginPage.enterEmail(driver, adminPropertyUsername, properties);
//        loginPage.enterPassword(driver, adminPropertyPassword, properties);
//        loginPage.login(driver, properties.getProperty(adminPropertyName));
//        adminProfilePage = (AdminProfilePageImpl) adminHomePage.goToProfilePage(driver);
//        Assertions.assertTrue(adminProfilePage.checkNameMatches(properties, driver));
//
//    }
//
//
//    @Test
//    @DisplayName("Check admin profile email matches with properties file email")
//    void checkAdminProfileEmailMatchesWithPropertiesFileEmail() {
//        loginPage.enterEmail(driver, adminPropertyUsername, properties);
//        loginPage.enterPassword(driver, adminPropertyPassword, properties);
//        loginPage.login(driver, properties.getProperty(adminPropertyName));
//        adminProfilePage = (AdminProfilePageImpl) adminHomePage.goToProfilePage(driver);
//        Assertions.assertTrue(adminProfilePage.checkEmailMatches(properties, driver));
//    }
//
//    @Test
//    @DisplayName("Check if change password button redirect to change password page")
//    void checkIfChangePasswordButtonRedirectToChangePasswordPage() {
//        loginPage.enterEmail(driver, adminPropertyUsername, properties);
//        loginPage.enterPassword(driver, adminPropertyPassword, properties);
//        loginPage.login(driver, properties.getProperty(adminPropertyName));
//        adminProfilePage = (AdminProfilePageImpl) adminHomePage.goToProfilePage(driver);
//        changePasswordPage = (ChangePasswordPageImpl) adminProfilePage.changePassword(driver);
//        Assertions.assertEquals(ChangePasswordPageImpl.class, changePasswordPage.getClass());
//
//    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @AfterAll
    static void tearDownAll() {
        webDriverFactory.endAllServices();
    }
}
