package com.sparta.eng82.tests.unit.trainee.feedbackpages;

import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.trainee.feedback.TraineeTraineeFeedbackFormPageImpl;
import com.sparta.eng82.components.pages.trainee.feedback.TraineeTrainerFeedbackFormPageImpl;

public class TraineeTraineeFeedbackFormPageTests {

    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;

    private final String traineePropertyUsername = "trainee_username";
    private final String traineePropertyPassword = "trainee_password";
    private final String traineePropertyName = "trainee_name";

    private TraineeHomePageImpl traineeHomePage;
    private TraineeTraineeFeedbackFormPageImpl traineeTraineeFeedbackFormPage;


    @BeforeEach
    void setup() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        traineeHomePage = (TraineeHomePageImpl) new LoginPageImpl(driver, "trainee").login();
        traineeTraineeFeedbackFormPage =  traineeHomePage.clickFeedbackFormForWeek(2);
    }

    @Test
    @DisplayName("Click Trainer Tab Test")
    void clickTrainerTabTest() {
        Assertions.assertEquals(TraineeTrainerFeedbackFormPageImpl.class, traineeTraineeFeedbackFormPage.clickOnTrainer().getClass());
    }

    @Test
    @DisplayName("Click Stop Tab Test")
    void clickStopTabTest() {
        traineeTraineeFeedbackFormPage.clickStopTab();
        Assertions.assertTrue(driver.findElement(By.id("stopTrainee")).isDisplayed());
    }

    @Test
    @DisplayName("Get Comment From Stop Box Test")
    void getCommentFromStopBoxTest() {
        String testString = "New Trainee Get Stop Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setStopCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @DisplayName("Set Comment In Stop Box Test")
    void setCommentInStopBoxTest() {
        String testString = "New Trainee Set Stop Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setStopCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @DisplayName("Edit Comment In Stop Box Test")
    void editCommentInStopBoxTest() {
        String testString = "New Trainee Edit Stop Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.editStopCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.getStopCommentBox().contains(testString));
    }

    @Test
    @DisplayName("Delete Comment In Stop Box Test")
    void deleteCommentInStopBoxTest() {
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.deleteStopCommentBox();
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals("", traineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @Ignore
    @DisplayName("Is Stop Comment Box Empty Test")
    void isStopCommentBoxEmptyTest() {
        traineeTraineeFeedbackFormPage.clickStopTab();
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.deleteStopCommentBox();
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isStopCommentBoxEmpty());
    }

    @Test
    @Ignore
    @DisplayName("Is Stop Comment Box Disabled Test")
    void isStopCommentBoxDisabledTest() {
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isStopCommentBoxDisabled());
    }

    @Test
    @Ignore
    @DisplayName("Is Stop Comment Box Enabled Before Submission Test")
    void isStopCommentBoxEnabledBeforeSubmissionTest() {
    }

    @Test
    @Ignore
    @DisplayName("Click Start Tab Test")
    void clickStartTabTest() {
        traineeTraineeFeedbackFormPage.clickStartTab();
        Assertions.assertTrue(driver.findElement(By.id("startTrainee")).isDisplayed());

    }

    @Test
    @Ignore
    @DisplayName("Get Comment From Start Box Test")
    void getCommentFromStartBoxTest() {
        String testString = "New Trainee Get Start Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setStartCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getStartCommentBox());
    }

    @Test
    @Ignore
    @DisplayName("Set Comment In Start Box Test")
    void setCommentInStartBoxTest() {
        String testString = "New Trainee Set Start Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setStartCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getStartCommentBox());
    }

    @Test
    @Ignore
    @DisplayName("Edit Comment In Start Box Test")
    void editCommentInStartBoxTest() {
        String testString = "New Trainee Edit Start Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.editStartCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.getStartCommentBox().contains(testString));
    }

    @Test
    @Ignore
    @DisplayName("Delete Comment In Start Box Test")
    void deleteCommentInStartBoxTest() {
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.deleteStartCommentBox();
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals("", traineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @Ignore
    @DisplayName("Is Start Comment Box Empty Test")
    void isStartCommentBoxEmptyTest() {

    }

    @Test
    @Ignore
    @DisplayName("Is Start Comment Box Disabled Test")
    void isStartCommentBoxDisabledTest() {

    }

    @Test
    @Ignore
    @DisplayName("Is Start Comment Box Enabled Before Submission Test")
    void isStartCommentBoxEnabledBeforeSubmissionTest() {

    }

    @Test
    @Ignore
    @DisplayName("Click Continue Tab Test")
    void clickContinueTabTest() {
        traineeTraineeFeedbackFormPage.clickContinueTab();
        Assertions.assertTrue(driver.findElement(By.id("continueTrainee")).isDisplayed());
    }

    @Test
    @Ignore
    @DisplayName("Get Comment From Continue Box Test")
    void getCommentFromContinueBoxTest() {
        String testString = "New Trainee Get Continue Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setContinueCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getContinueCommentBox());
    }

    @Test
    @Ignore
    @DisplayName("Set Comment In Continue Box Test")
    void setCommentInContinueBoxTest() {
        String testString = "New Trainee Set Continue Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setContinueCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getContinueCommentBox());
    }

    @Test
    @Ignore
    @DisplayName("Edit Comment In Continue Box Test")
    void editCommentInContinueBoxTest() {
        String testString = "New Trainee Edit Continue Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.editContinueCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.getContinueCommentBox().contains(testString));
    }

    @Test
    @Ignore
    @DisplayName("Delete Comment In Continue Box Test")
    void deleteCommentInContinueBoxTest() {
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.deleteContinueCommentBox();
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals("", traineeTraineeFeedbackFormPage.getContinueCommentBox());
    }

    @Test
    @Ignore
    @DisplayName("Is Continue Comment Box Empty Test")
    void isContinueCommentBoxEmptyTest() {

    }

    @Test
    @Ignore
    @DisplayName("Is Continue Comment Box Disabled Test")
    void isContinueCommentBoxDisabledTest() {

    }

    @Test
    @Ignore
    @DisplayName("Is Continue Comment Box Enabled Before Submission Test")
    void isContinueCommentBoxEnabledBeforeSubmissionTest() {

    }

    @Test
    @Ignore
    @DisplayName("Get Comment From Trainer Comment Box Test")
    void getCommentFromTrainerCommentBoxTest() {

    }

    @Test
    @Ignore
    @DisplayName("Set Comment In Trainer Comment Box Test")
    void setCommentInTrainerCommentBoxTest() {

    }

    @Test
    @Ignore
    @DisplayName("Delete Comment In Trainer Comment Box Test")
    void deleteCommentInTrainerCommentBoxTest() {

    }

    @Test
    @Ignore
    @DisplayName("Is Trainer Comment Comment Box Empty Test")
    void isTrainerCommentCommentBoxEmptyTest() {

    }

    @Test
    @Ignore
    @DisplayName("Is Trainer Comment Comment Box Disabled Test")
    void isTrainerCommentCommentBoxDisabledTest() {

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

