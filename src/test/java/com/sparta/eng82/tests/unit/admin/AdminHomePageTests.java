package com.sparta.eng82.tests.unit.admin;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.admin.addpages.AddTrainerPageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AdminHomePageTests {
    private WebDriver driver;
    private WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;
    private AdminHomePageImpl adminHomePage;
    private AddTrainerPageImpl addTrainerPage;
    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";
    private final String adminPropertyName = "admin_name";
    private static Properties properties;

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
    @DisplayName("Add trainer test")
    void addTrainerTest() {
        loginPage.enterEmail(driver, adminPropertyUsername, properties);
        loginPage.enterPassword(driver, adminPropertyPassword, properties);
        loginPage.login(driver, properties.getProperty(adminPropertyName));
        addTrainerPage = (AddTrainerPageImpl) adminHomePage.addTrainer();
        Assertions.assertEquals(AddTrainerPageImpl.class, addTrainerPage.getClass());
    }

    @Test
    @DisplayName("Is trainer added Test")
    void isTrainerAddedTest() {

        loginPage.enterEmail(driver, adminPropertyUsername, properties);
        loginPage.enterPassword(driver, adminPropertyPassword, properties);
        loginPage.login(driver, properties.getProperty(adminPropertyName));
        adminHomePage.addTrainer().enterFirstName("test")
                .enterSecondName("test")
                .selectGroup("hola")
                .addTrainer();
        Assertions.assertTrue(adminHomePage.isTrainerAdded("test", "test", "hola"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}