package com.sparta.eng82.tests.unit.trainee;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.EnumSet;

public class TraineeHomepageTests {


    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private static EnumSet<WebDriverTypes> normalTypes;
    private static EnumSet<WebDriverTypes> headlessTypes;

    @BeforeAll
    static void setup() {
        webDriverFactory = new WebDriverFactory();
        normalTypes = EnumSet.of(WebDriverTypes.CHROME, WebDriverTypes.EDGE);
        headlessTypes = EnumSet.of(WebDriverTypes.CHROME_HEADLESS);
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
        //loginPage.enterEmail()
        Assertions.assertEquals("http://localhost:8080/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the correct form is selected when specifying a week")
    void checkThatTheCorrectFormIsSelectedWhenSpecifyingAWeek() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        driver.get("http://localhost:8080/");
        LoginPageImpl loginPage = new LoginPageImpl(driver);
        TraineeHomePageImpl traineeHomePage = (TraineeHomePageImpl) loginPage.login("trainee2");
        Assertions.assertEquals(traineeHomePage.clickFeedbackFormForWeek(2).getWeek(driver), "Week 2");

    }





}
