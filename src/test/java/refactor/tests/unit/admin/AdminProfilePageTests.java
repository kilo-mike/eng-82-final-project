package refactor.tests.unit.admin;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import refactor.components.frameworkutil.PropertiesLoader;
import refactor.components.frameworkutil.WebDriverFactory;
import refactor.components.frameworkutil.WebDriverTypes;
import refactor.components.pages.admin.AdminHomePageImpl;
import refactor.components.pages.admin.AdminProfilePageImpl;
import refactor.components.pages.other.ChangePasswordPageImpl;
import refactor.components.pages.other.LoginPageImpl;

import java.util.Properties;

public class AdminProfilePageTests {


    private WebDriver driver;
    private static WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;
    private AdminHomePageImpl adminHomePage;
    private AdminProfilePageImpl adminProfilePage;
    private final String userAdmin = "admin";
    private ChangePasswordPageImpl changePasswordPage;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        adminProfilePage = (AdminProfilePageImpl) new LoginPageImpl(driver, userAdmin)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToProfilePage();
//        adminProfilePage  = (AdminProfilePageImpl) new LoginPageImpl(driver,userAdmin).driverGet().login();
    }


    @Test
    @DisplayName("Get admin name")
    void getAdminName() {
        Assertions.assertEquals(PropertiesLoader.getName(userAdmin), adminProfilePage.getName());
    }


    @Test
    @DisplayName("Get admin email")
    void getAdminEmail() {
        Assertions.assertEquals(PropertiesLoader.getEmail(userAdmin), adminProfilePage.getEmail());
    }


    @Test
    @DisplayName("Check admin profile name matches with properties file name")
    void checkAdminProfileNameMatchesWithPropertiesFileName() {
        Assertions.assertTrue(adminProfilePage.checkNameMatches());
    }


    @Test
    @DisplayName("Check admin profile email matches with properties file email")
    void checkAdminProfileEmailMatchesWithPropertiesFileEmail() {
        Assertions.assertTrue(adminProfilePage.checkEmailMatches());
    }

    @Test
    @DisplayName("Check if change password button redirect to change password page")
    void checkIfChangePasswordButtonRedirectToChangePasswordPage() {
        Assertions.assertEquals(ChangePasswordPageImpl.class, adminProfilePage.goToProfilePage().goToChangePasswordPage().getClass());

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
