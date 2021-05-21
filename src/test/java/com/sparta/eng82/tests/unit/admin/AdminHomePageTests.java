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
    private static Properties properties;
    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";
    private final String adminPropertyName = "admin_name";
    private WebDriver driver;
    private static WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;
    private AdminHomePageImpl adminHomePage;
    private AddTrainerPageImpl addTrainerPage;

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
        adminHomePage.addTrainer().enterFirstName("test3")
                .enterSecondName("test3")
                .selectGroup("No Group")
                .addNewTrainer();
        Assertions.assertTrue(adminHomePage.isTrainerAdded("test3", "test3", "Not Assigned"));
    }

    @Test
    @DisplayName("Is the size of the return list with all the trainers right ")
    void isTheSizeOfTheReturnListWithAllTheTrainersRight() {
        loginPage.enterEmail(driver, adminPropertyUsername, properties);
        loginPage.enterPassword(driver, adminPropertyPassword, properties);
        loginPage.login(driver, properties.getProperty(adminPropertyName));
        Assertions.assertTrue(adminHomePage.getAllTrainersAvailable(7));
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @AfterAll
    static void tearDownAll(){
        webDriverFactory.endAllServices();
    }

}