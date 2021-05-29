package com.sparta.eng82.tests.unit.admin;


import com.sparta.eng82.components.pages.admin.EditTrainerPageImpl;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.admin.AddTrainerPageImpl;
import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;

import java.util.Properties;

public class AdminHomePageTests {

    private WebDriver driver;
    private static WebDriverFactory webDriverFactory;

    private AdminHomePageImpl adminHomePage;

    private final String userAdmin = "admin";
    private final String desiredFirstName = "Dummy";
    private final String desiredLastName = "Smith";
    private final String desiredGroupName = "EngTest";



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
                .enterFirstName(desiredFirstName)
                .enterSecondName(desiredLastName)
                .selectGroup(desiredGroupName)
                .addNewTrainer();
        Assertions.assertTrue(adminHomePage.isTrainerAdded(desiredFirstName, desiredLastName, desiredGroupName));
        ((EditTrainerPageImpl) adminHomePage.clickOnTrainer(desiredFirstName, desiredLastName))
                .tickForRemove()
                .removeTrainer();

    }

    @Test
    @DisplayName("Is the size of the return list with all the trainers right ")
    void isTheSizeOfTheReturnListWithAllTheTrainersRight() {
        Assertions.assertTrue(adminHomePage.getAllTrainersAvailable(5));
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