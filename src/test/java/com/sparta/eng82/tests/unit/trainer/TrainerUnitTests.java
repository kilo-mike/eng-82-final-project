package com.sparta.eng82.tests.unit.trainer;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerHomePage;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.EnumSet;
import java.util.Properties;

public class TrainerUnitTests {


    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private static EnumSet<WebDriverTypes> normalTypes;
    private static EnumSet<WebDriverTypes> headlessTypes;

    private LoginPageImpl loginPage;
    private TrainerHomePage trainerHomePage;

    private final String trainerPropertyUsername = "trainer_username";
    private final String trainerPropertyPassword = "trainer_password";
    private final String trainerPropertyName = "trainer_name";

    private static Properties properties;

    @BeforeAll
    static void setupAll() {
        properties = new Properties();
        Utility.loadProperties(properties);


//        normalTypes = EnumSet.of(WebDriverTypes.CHROME, WebDriverTypes.EDGE);
//        headlessTypes = EnumSet.of(WebDriverTypes.CHROME_HEADLESS);
    }

    @BeforeEach
    void setup() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        loginPage = new LoginPageImpl(driver);
        trainerHomePage = new TrainerHomePageImpl(driver);
    }

//    @AfterAll
//    static void tearDown() {
//        driver.quit();
//    }
//
//    private static EnumSet<WebDriverTypes> getNormalTypes() {
//        return normalTypes;
//    }
//
//    private static EnumSet<WebDriverTypes> getHeadlessTypes() {
//        return headlessTypes;
//    }

    @Test
    @DisplayName("Logout check message")
    void logoutCheckMessage() {
        loginPage.enterEmail(driver, trainerPropertyUsername, properties)
                .enterPassword(driver, trainerPropertyPassword, properties)
                .login(driver, properties.getProperty(trainerPropertyName));
    }

    @Test
    @DisplayName("Check the URL is correct when loading a new homepage")
    void checkTheUrlIsCorrectWhenLoadingANewHomepage() {
        loginPage.enterEmail(driver, trainerPropertyUsername, properties)
                .enterPassword(driver, trainerPropertyPassword, properties)
                .login(driver, properties.getProperty(trainerPropertyName));

        Assertions.assertEquals("http://localhost:8080/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the correct form is selected when specifying a week")
    void checkThatTheCorrectFormIsSelectedWhenSpecifyingAWeek() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        driver.get("http://localhost:8080/");
        LoginPageImpl loginPage = new LoginPageImpl(driver);
        TraineeHomePageImpl traineeHomePage = (TraineeHomePageImpl) loginPage.login(driver, "trainee2");
        Assertions.assertEquals(traineeHomePage.clickFeedbackFormForWeek(2).getWeek(driver), "Week 2");
    }
    
    
    @Nested
    @DisplayName("Add Group Page Tests")
    class GroupPageTests {
        @Test
        @DisplayName("Checking that stream selections are correct")
        void checkingThatStreamSelectionsAreCorrect() {
            loginPage.enterEmail(driver, trainerPropertyUsername, properties)
                    .enterPassword(driver, trainerPropertyPassword, properties)
                    .login(driver, properties.getProperty(trainerPropertyName));

            loginPage = (LoginPageImpl) trainerHomePage.selectJaneDoe();

        }
    }
}

