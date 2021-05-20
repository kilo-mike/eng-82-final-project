package com.sparta.eng82.tests.unit.trainee;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeHomePage;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.EnumSet;
import java.util.Properties;

public class TraineeHomepageTests {


    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private static EnumSet<WebDriverTypes> normalTypes;
    private static EnumSet<WebDriverTypes> headlessTypes;

    private static Properties properties;
    private final String traineePropertyUsername = "trainee_username";
    private final String traineePropertyPassword = "trainee_password";
    private final String traineePropertyName = "trainee_name";
    @BeforeAll
    static void setup() {
        webDriverFactory = new WebDriverFactory();
        normalTypes = EnumSet.of(WebDriverTypes.CHROME, WebDriverTypes.EDGE);
        headlessTypes = EnumSet.of(WebDriverTypes.CHROME_HEADLESS);
        properties = new Properties();
        Utility.loadProperties(properties);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    private static EnumSet<WebDriverTypes> getNormalTypes() {
        return normalTypes;
    }

    private static EnumSet<WebDriverTypes> getHeadlessTypes() {
        return headlessTypes;
    }

    @Test
    @DisplayName("Check the URL is correct when loading a new homepage")
    void checkTheUrlIsCorrectWhenLoadingANewHomepage() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        driver.get("http://localhost:8080/");
        LoginPageImpl loginPage = new LoginPageImpl(driver);
        loginPage.enterEmail(traineePropertyUsername, properties).enterPassword(traineePropertyPassword,properties);
        loginPage.login(traineePropertyName);
        Assertions.assertEquals("http://localhost:8080/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the correct form is selected when specifying a week")
    void checkThatTheCorrectFormIsSelectedWhenSpecifyingAWeek() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        driver.get("http://localhost:8080/");
        LoginPageImpl loginPage = new LoginPageImpl(driver);
        loginPage.enterEmail(traineePropertyUsername, properties).enterPassword(traineePropertyPassword,properties);
        TraineeHomePage traineeHomePage = (TraineeHomePage) loginPage.login(traineePropertyName);
        Assertions.assertEquals(traineeHomePage.clickFeedbackFormForWeek(2).getWeek(driver), "Week 2");

    }





}
