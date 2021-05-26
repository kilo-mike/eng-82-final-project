package com.sparta.eng82.tests.unit.trainee.feedbackpages;

import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.trainee.feedback.TraineeTraineeFeedbackFormPageImpl;
import com.sparta.eng82.components.pages.trainee.feedback.TraineeTrainerFeedbackFormPageImpl;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TraineeTrainerFeedbackFormPageTests {

    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;
    private int week = 3;


    private final String traineePropertyUsername = "trainee_username";
    private final String traineePropertyPassword = "trainee_password";
    private final String traineePropertyName = "trainee_name";

    private TraineeHomePageImpl traineeHomePage;
    private TraineeTraineeFeedbackFormPageImpl traineeTraineeFeedbackFormPage;

    private TraineeTrainerFeedbackFormPageImpl traineeTrainerFeedbackFormPage;


    @BeforeEach
    void setup() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
        traineeHomePage = (TraineeHomePageImpl) new LoginPageImpl(driver, "trainee").login();
        traineeTraineeFeedbackFormPage =  traineeHomePage.clickFeedbackFormForWeek(3);
        traineeTrainerFeedbackFormPage = traineeTraineeFeedbackFormPage.clickOnTrainer();

    }

    @Test
    @DisplayName("Click Trainee Tab Test")
    void clickTraineeTabTest() {
        Assertions.assertEquals(TraineeTraineeFeedbackFormPageImpl.class, traineeTrainerFeedbackFormPage.clickOnTrainee().getClass());
    }

    @Test
    @DisplayName("Click Stop Tab Test")
    void clickStopTabTest() {
        traineeTrainerFeedbackFormPage.clickStopTab();
        Assertions.assertTrue(driver.findElement(By.id("stopTrainer")).isDisplayed());
    }

    @Test
    @DisplayName("Get Comment From Stop Box Test")
    void getCommentFromStopBoxTest() {
        String testString = driver.findElement(By.id("stopTrainer")).getText();
        Assertions.assertEquals(testString, traineeTrainerFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @DisplayName("Is Stop Comment Box Empty Test")
    void isStopCommentBoxEmptyTest() {
        boolean empty = driver.findElement(By.id("stopTrainer")).getText().isEmpty();
        Assertions.assertEquals(empty, traineeTrainerFeedbackFormPage.isStopCommentBoxEmpty());
    }

    @Test
    @DisplayName("is Stop Comment Box Disabled")
    void isStopCommentBoxDisabledTest() {
        boolean enabled = driver.findElement(By.id("stopTrainer")).isEnabled();
        Assertions.assertEquals(enabled, traineeTrainerFeedbackFormPage.isStopCommentBoxDisabled());
    }

    @Test
    @DisplayName("Click Start Tab Test")
    void clickStartTabTest() {
        traineeTrainerFeedbackFormPage.clickStartTab();
        Assertions.assertTrue(driver.findElement(By.id("startTrainer")).isDisplayed());
    }

    @Test
    @DisplayName("Get Comment From Start Box Test")
    void getCommentFromStartBoxTest() {
        String testString = driver.findElement(By.id("startTrainer")).getText();
        Assertions.assertEquals(testString, traineeTrainerFeedbackFormPage.getStartCommentBox());
    }

    @Test
    @DisplayName("Is Start Comment Box Empty Test")
    void isStartCommentBoxEmptyTest() {
        boolean empty = driver.findElement(By.id("startTrainer")).getText().isEmpty();
        Assertions.assertEquals(empty, traineeTrainerFeedbackFormPage.isStartCommentBoxEmpty());
    }

    @Test
    @DisplayName("is Start Comment Box Disabled")
    void isStartCommentBoxDisabledTest() {
        boolean enabled = driver.findElement(By.id("startTrainer")).isEnabled();
        Assertions.assertEquals(enabled, traineeTrainerFeedbackFormPage.isStartCommentBoxDisabled());
    }

    @Test
    @DisplayName("Click Continue Tab Test")
    void clickContinueTabTest() {
        traineeTrainerFeedbackFormPage.clickContinueTab();
        Assertions.assertTrue(driver.findElement(By.id("continueTrainer")).isDisplayed());
    }

    @Test
    @DisplayName("Get Comment From Continue Box Test")
    void getCommentFromContinueBoxTest() {
        String testString = driver.findElement(By.id("continueTrainer")).getText();
        Assertions.assertEquals(testString, traineeTrainerFeedbackFormPage.getContinueCommentBox());
    }

    @Test
    @DisplayName("Is Continue Comment Box Empty Test")
    void isContinueCommentBoxEmptyTest() {
        boolean empty = driver.findElement(By.id("continueTrainer")).getText().isEmpty();
        Assertions.assertEquals(empty, traineeTrainerFeedbackFormPage.isContinueCommentBoxEmpty());
    }

    @Test
    @DisplayName("is Stop Comment Box Disabled")
    void isContinueCommentBoxDisabledTest() {
        boolean enabled = driver.findElement(By.id("continueTrainer")).isEnabled();
        Assertions.assertEquals(enabled, traineeTrainerFeedbackFormPage.isContinueCommentBoxDisabled());
    }

    @Test
    @DisplayName("Get Comment From Continue Box Test")
    void getCommentFromTrainerBoxTest() {
        String testString = driver.findElement(By.id("trainerComments")).getText();
        Assertions.assertEquals(testString, traineeTrainerFeedbackFormPage.getTrainerCommentBox());
    }

    @Test
    @DisplayName("Is Continue Comment Box Empty Test")
    void isTrainerCommentBoxEmptyTest() {
        boolean empty = driver.findElement(By.id("trainerComments")).getText().isEmpty();
        Assertions.assertEquals(empty, traineeTrainerFeedbackFormPage.isTrainerCommentBoxEmpty());
    }

    @Test
    @DisplayName("is Stop Comment Box Disabled")
    void isTrainerCommentBoxDisabledTest() {
        boolean enabled = driver.findElement(By.id("trainerComments")).isEnabled();
        Assertions.assertEquals(enabled, traineeTrainerFeedbackFormPage.isTrainerCommentBoxDisabled());
    }




    @AfterEach
    void tearDown() {
        driver.close();
    }

    @AfterAll
    static void tearDownAll() {
        webDriverFactory.endAllServices();
    }

}
