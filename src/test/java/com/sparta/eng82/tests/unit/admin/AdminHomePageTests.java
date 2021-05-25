package com.sparta.eng82.tests.unit.admin;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.admin.AddTrainerPageImpl;
import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;

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
    private final String userAdmin = "admin";



    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();

    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        adminHomePage = (AdminHomePageImpl) new LoginPageImpl(driver, userAdmin).login();
    }

    @Test
    @DisplayName("Add trainer test")
    void addTrainerTest() {
        Assertions.assertEquals(AddTrainerPageImpl.class, adminHomePage.addTrainer().getClass());
    }

    @Test
    @DisplayName("Is trainer added Test")
    void isTrainerAddedTest() {
        adminHomePage.addTrainer()
                .enterFirstName("test2")
                .enterSecondName("ssss")
                .selectGroup("No Group")
                .addNewTrainer();
        Assertions.assertTrue(adminHomePage.isTrainerAdded("test2", "ssss", "Not Assigned"));

    }

    @Test
    @DisplayName("Is the size of the return list with all the trainers right ")
    void isTheSizeOfTheReturnListWithAllTheTrainersRight() {
        Assertions.assertTrue(adminHomePage.getAllTrainersAvailable(6));
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