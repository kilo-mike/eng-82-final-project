package com.sparta.eng82.tests.unit.admin;

import com.sparta.eng82.components.pages.accesspages.ChangePasswordPageImpl;
import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminProfilePageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AdminProfilePageTests {
    private static Properties properties;
    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";
    private final String adminPropertyName = "admin_name";
    private WebDriver driver;
    private WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;
    private AdminHomePageImpl adminHomePage;
    private AdminProfilePageImpl adminProfilePage;

    private ChangePasswordPageImpl changePasswordPage;

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
    @DisplayName("Get admin name")
    void getAdminName() {
        loginPage.enterEmail(driver, adminPropertyUsername, properties);
        loginPage.enterPassword(driver, adminPropertyPassword, properties);
        loginPage.login(driver, properties.getProperty(adminPropertyName));
        adminProfilePage = (AdminProfilePageImpl) adminHomePage.goToProfilePage(driver);
        Assertions.assertEquals("ROLE_ADMIN", adminProfilePage.getName(driver));
    }


    @Test
    @DisplayName("Get admin email")
    void getAdminEmail() {
        loginPage.enterEmail(driver, adminPropertyUsername, properties);
        loginPage.enterPassword(driver, adminPropertyPassword, properties);
        loginPage.login(driver, properties.getProperty(adminPropertyName));
        adminProfilePage = (AdminProfilePageImpl) adminHomePage.goToProfilePage(driver);
        Assertions.assertEquals("admin@sparta.com", adminProfilePage.getEmail(driver));
    }


    @Test
    @DisplayName("Check admin profile name matches with properties file name")
    void checkAdminProfileNameMatchesWithPropertiesFileName() {
        loginPage.enterEmail(driver, adminPropertyUsername, properties);
        loginPage.enterPassword(driver, adminPropertyPassword, properties);
        loginPage.login(driver, properties.getProperty(adminPropertyName));
        adminProfilePage = (AdminProfilePageImpl) adminHomePage.goToProfilePage(driver);
        Assertions.assertTrue(adminProfilePage.checkNameMatches(properties, driver));

    }


    @Test
    @DisplayName("Check admin profile email matches with properties file email")
    void checkAdminProfileEmailMatchesWithPropertiesFileEmail() {
        loginPage.enterEmail(driver, adminPropertyUsername, properties);
        loginPage.enterPassword(driver, adminPropertyPassword, properties);
        loginPage.login(driver, properties.getProperty(adminPropertyName));
        adminProfilePage = (AdminProfilePageImpl) adminHomePage.goToProfilePage(driver);
        Assertions.assertTrue(adminProfilePage.checkEmailMatches(properties, driver));
    }

    @Test
    @DisplayName("Check if change password button redirect to change password page")
    void checkIfChangePasswordButtonRedirectToChangePasswordPage() {
        loginPage.enterEmail(driver, adminPropertyUsername, properties);
        loginPage.enterPassword(driver, adminPropertyPassword, properties);
        loginPage.login(driver, properties.getProperty(adminPropertyName));
        adminProfilePage = (AdminProfilePageImpl) adminHomePage.goToProfilePage(driver);
        changePasswordPage = (ChangePasswordPageImpl) adminProfilePage.changePassword(driver);
        Assertions.assertEquals(ChangePasswordPageImpl.class, changePasswordPage.getClass());

    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
