package com.sparta.eng82.tests.unit.trainee;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeHomePage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTraineeFeedbackFormPage;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
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

    private LoginPageImpl loginPage;
    private TraineeHomePage traineeHomePage;

    @BeforeAll
    static void setupAll() {
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

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
        driver.get("http://localhost:8080/");
        loginPage = new LoginPageImpl(driver);
        loginPage.enterEmail(driver, traineePropertyUsername, properties).enterPassword(driver, traineePropertyPassword, properties);
        traineeHomePage = (TraineeHomePage) loginPage.login(driver, traineePropertyName);
    }

    @Test
    @DisplayName("Check the URL is correct when loading a new homepage")
    void checkTheUrlIsCorrectWhenLoadingANewHomepage() {
        Assertions.assertEquals("http://localhost:8080/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that the correct form is selected when specifying a week")
    void checkThatTheCorrectFormIsSelectedWhenSpecifyingAWeek() {
        TraineeTraineeFeedbackFormPage traineeTraineeFeedbackFormPage = (TraineeTraineeFeedbackFormPage) traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals("Week 2", traineeTraineeFeedbackFormPage.getWeek(driver));
    }

    @Test
    @DisplayName("Check that the current week test selects the correct week")
    void checkThatTheCurrentWeekTestSelectsTheCorrectWeek() {
        String currentWeek = traineeHomePage.getCurrentWeek();
        TraineeTraineeFeedbackFormPage traineeTraineeFeedbackFormPage = (TraineeTraineeFeedbackFormPage) traineeHomePage.clickCurrentWeek();
        Assertions.assertEquals(currentWeek, traineeTraineeFeedbackFormPage.getWeek(driver));
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
        String[] acceptableColours = {"Green", "Amber", "Red"};
        String colour = traineeHomePage.getCurrentTrafficLight();
        Assertions.assertTrue(Arrays.stream(acceptableColours).anyMatch(s -> s.contains(colour)));
    }

    @Ignore
    @Test
    @DisplayName("Test the current week is correct")
    void testTheCurrentWeekIsCorrect() {
        //TODO I have no idea how to test this lol
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
