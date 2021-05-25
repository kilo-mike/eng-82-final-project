package com.sparta.eng82.tests.unit.trainee;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;

import java.util.Arrays;
import java.util.EnumSet;

public class TraineeHomepageTests {


    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private static EnumSet<WebDriverTypes> normalTypes;
    private static EnumSet<WebDriverTypes> headlessTypes;


    private final String traineePropertyUsername = "trainee_username";
    private final String traineePropertyPassword = "trainee_password";
    private final String traineePropertyName = "trainee_name";

    private LoginPageImpl loginPage;
    private TraineeHomePageImpl traineeHomePage;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
        normalTypes = EnumSet.of(WebDriverTypes.CHROME, WebDriverTypes.EDGE);
        headlessTypes = EnumSet.of(WebDriverTypes.CHROME_HEADLESS);
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        traineeHomePage = (TraineeHomePageImpl) new LoginPageImpl(driver, "trainee").login();

    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }


    @AfterAll
    static void tearDown() {
        webDriverFactory.endAllServices();
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
        Assertions.assertEquals("http://localhost:8080/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the correct form is selected when specifying a week")
    void checkThatTheCorrectFormIsSelectedWhenSpecifyingAWeek() {
        Assertions.assertEquals("Week 2", traineeHomePage.clickFeedbackFormForWeek(2).getWeek());
    }

    @Test
    @DisplayName("Check that the current week test selects the correct week")
    void checkThatTheCurrentWeekTestSelectsTheCorrectWeek() {
        Assertions.assertEquals(traineeHomePage.getCurrentWeek(), traineeHomePage.clickCurrentWeek().getWeek());
    }

    @Test
    @DisplayName("Check that all the weeks are unique apart from current week")
    void checkThatAllTheWeeksAreUniqueApartFromCurrentWeek() {
        Assertions.assertTrue(traineeHomePage.areAllWeeksDistinct());
    }

    @Test
    @DisplayName("Check all the weeks are prior to current week")
    void checkAllTheWeeksArePriorToCurrentWeek() {
        Assertions.assertTrue(traineeHomePage.areAllWeeksPriorToCurrentWeek());
    }

    @Test
    @DisplayName("Check all the weeks are shown before current week")
    void checkAllTheWeeksAreShownBeforeCurrentWeek() {
        Assertions.assertTrue(traineeHomePage.areAllPreviousWeeksShown());
    }

    @Test  //TODO This can be mocked I think
    @DisplayName("Check the traffic light colour for the current week")
    void checkTheTrafficLightColourForCurrentWeek() {
        // TODO
        //traineHomePage.checkTrafficLightColourForCurrentWeek();
        Assertions.assertTrue(Arrays.stream(new String[]{"Green", "Amber", "Red"}).anyMatch(s -> s.contains(traineeHomePage.getCurrentTrafficLight())));
    }

    @Test
    @DisplayName("Test the current week is correct")
    void testTheCurrentWeekIsCorrect() {
        Assertions.assertEquals(traineeHomePage.getCurrentWeek(), traineeHomePage.getMaxWeek());
    }

    @Test
    @DisplayName("Check the name is shown properly")
    void checkTheNameIsShownProperly() {
        Assertions.assertEquals("Jane Doe", traineeHomePage.getName());
    }

    @Test
    @DisplayName("Check the stream is shown properly")
    void checkTheStreamIsShownProperly() {
        Assertions.assertEquals("Java SDET", traineeHomePage.getStream());
    }

    @Test
    @DisplayName("Check the group is shown properly")
    void checkTheGroupIsShownProperly() {
        Assertions.assertEquals("Engineering 80", traineeHomePage.getGroup());
    }

    @Test
    @DisplayName("Check the trainer is shown properly")
    void checkTheTrainerIsShownProperly() {
        Assertions.assertEquals("Manish Gadhvi", traineeHomePage.getTrainer());
    }


}
