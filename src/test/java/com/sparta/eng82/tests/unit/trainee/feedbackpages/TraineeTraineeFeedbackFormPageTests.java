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

public class TraineeTraineeFeedbackFormPageTests {

    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;
    private final int submittedWeek = 1;
    private final int unsubmittedWeek = 3;

    private TraineeHomePageImpl traineeHomePage;
    private TraineeTraineeFeedbackFormPageImpl traineeTraineeFeedbackFormPage;

    @BeforeEach
    void setup() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        traineeHomePage = (TraineeHomePageImpl) new LoginPageImpl(driver, "trainee").login();
    }

    @Test
    @DisplayName("Click Trainer Tab Test")
    void clickTrainerTabTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals(TraineeTrainerFeedbackFormPageImpl.class, traineeTraineeFeedbackFormPage.clickOnTrainer().getClass());
    }

    @Test
    @DisplayName("Click Stop Tab Test")
    void clickStopTabTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        traineeTraineeFeedbackFormPage.clickStopTab();
        Assertions.assertTrue(driver.findElement(By.id("stopTrainee")).isDisplayed());
    }

    @Test
    @DisplayName("Get Comment From Stop Box Test")
    void getCommentFromStopBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = driver.findElement(new By.ById("stopTrainee")).getText();
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setStopCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @DisplayName("Set Comment In Stop Box Test")
    void setCommentInStopBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = "New Trainee Set Stop Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setStopCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @DisplayName("Edit Comment In Stop Box Test")
    void editCommentInStopBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = "New Trainee Edit Stop Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.editStopCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.getStopCommentBox().contains(testString));
    }

    @Test
    @DisplayName("Delete Comment In Stop Box Test")
    void deleteCommentInStopBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.deleteStopCommentBox();
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals("", traineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @DisplayName("Is Stop Comment Box Empty Test")
    void isStopCommentBoxEmptyTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        traineeTraineeFeedbackFormPage.clickStopTab();
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.deleteStopCommentBox();
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isStopCommentBoxEmpty());
    }

    @Test
    @DisplayName("Is Stop Comment Box Disabled Test")
    void isStopCommentBoxDisabledTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(submittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isStopCommentBoxDisabled());
    }

    @Test
    @DisplayName("Is Stop Comment Box Enabled Before Submission Test")
    void isStopCommentBoxEnabledBeforeSubmissionTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isStopCommentBoxDisabled());

    }

    @Test
    @DisplayName("Click Start Tab Test")
    void clickStartTabTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        traineeTraineeFeedbackFormPage.clickStartTab();
        Assertions.assertTrue(driver.findElement(By.id("startTrainee")).isDisplayed());
    }

    @Test
    @DisplayName("Get Comment From Start Box Test")
    void getCommentFromStartBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = "New Trainee Get Start Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setStartCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getStartCommentBox());
    }

    @Test
    @DisplayName("Set Comment In Start Box Test")
    void setCommentInStartBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = "New Trainee Set Start Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setStartCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getStartCommentBox());
    }

    @Test
    @DisplayName("Edit Comment In Start Box Test")
    void editCommentInStartBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = "New Trainee Edit Start Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.editStartCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.getStartCommentBox().contains(testString));
    }

    @Test
    @DisplayName("Delete Comment In Start Box Test")
    void deleteCommentInStartBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.deleteStartCommentBox();
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals("", traineeTraineeFeedbackFormPage.getStartCommentBox());
    }

    @Test
    @DisplayName("Is Start Comment Box Empty Test")
    void isStartCommentBoxEmptyTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        traineeTraineeFeedbackFormPage.clickStartTab();
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.deleteStartCommentBox();
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isStartCommentBoxEmpty());
    }

    @Test
    @DisplayName("Is Start Comment Box Disabled Test")
    void isStartCommentBoxDisabledTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(submittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isStartCommentBoxDisabled());
    }

    @Test
    @DisplayName("Is Start Comment Box Enabled Before Submission Test")
    void isStartCommentBoxEnabledBeforeSubmissionTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isStartCommentBoxEnabledBeforeSubmission());
    }

    @Test
    @DisplayName("Click Continue Tab Test")
    void clickContinueTabTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        traineeTraineeFeedbackFormPage.clickContinueTab();
        Assertions.assertTrue(driver.findElement(By.id("continueTrainee")).isDisplayed());
    }

    @Test
    @DisplayName("Get Comment From Continue Box Test")
    void getCommentFromContinueBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = "New Trainee Get Continue Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setContinueCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getContinueCommentBox());
    }

    @Test
    @DisplayName("Set Comment In Continue Box Test")
    void setCommentInContinueBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = "New Trainee Set Continue Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.setContinueCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getContinueCommentBox());
    }

    @Test
    @DisplayName("Edit Comment In Continue Box Test")
    void editCommentInContinueBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = "New Trainee Edit Continue Comment";
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.editContinueCommentBox(testString);
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.getContinueCommentBox().contains(testString));
    }

    @Test
    @DisplayName("Delete Comment In Continue Box Test")
    void deleteCommentInContinueBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.deleteContinueCommentBox();
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals("", traineeTraineeFeedbackFormPage.getContinueCommentBox());
    }

    @Test
    @DisplayName("Is Continue Comment Box Empty Test")
    void isContinueCommentBoxEmptyTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        traineeTraineeFeedbackFormPage.clickContinueTab();
        traineeHomePage = (TraineeHomePageImpl) traineeTraineeFeedbackFormPage.deleteContinueCommentBox();
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isContinueCommentBoxEmpty());

    }

    @Test
    @DisplayName("Is Continue Comment Box Disabled Test")
    void isContinueCommentBoxDisabledTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(submittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isContinueCommentBoxDisabled());
    }

    @Test
    @DisplayName("Is Continue Comment Box Enabled Before Submission Test")
    void isContinueCommentBoxEnabledBeforeSubmissionTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isContinueCommentBoxEnabledBeforeSubmission());
    }

    @Test
    @DisplayName("Get Comment From Trainer Comment Box Test")
    void getCommentFromTrainerCommentBoxTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = driver.findElement(new By.ById("trainerComments")).getText();
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getTrainerCommentBox());
    }

    @Test
    @DisplayName("Is Trainer Comment Comment Box Empty Test")
    void isTrainerCommentCommentBoxEmptyTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isTrainerCommentBoxEmpty());
    }

    @Test
    @DisplayName("Is Trainer Comment Comment Box Disabled Test")
    void isTrainerCommentCommentBoxDisabledTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isTrainerCommentBoxDisabled());
    }

    @Test
    @DisplayName("Get Technical Grade Test")
    void getTechnicalGradeTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals(driver.findElement(new By.ById("techGrade")).getText(), traineeTraineeFeedbackFormPage.getTechnicalGrade());
    }

    @Test
    @DisplayName("Get Consultant Grade Test")
    void getConsultantGradeTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertEquals(driver.findElement(new By.ById("consultGrade")).getText(), traineeTraineeFeedbackFormPage.getConsultantGrade());
    }

    @Test
    @DisplayName("Is Technical Grade Disabled Test")
    void isTechnicalGradeDisabledTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(submittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isTechnicalGradeDisabled());
    }

    @Test
    @DisplayName("Is Consultant Grade Disabled Test")
    void isConsultantGradeDisabledTest() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(submittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.isConsultantGradeDisabled());
    }

    @Test
    @DisplayName("Click on Stop and Set Comment")
    void clickOnStopAndSetComment() { //TODO This method does not save the form and does not change the value.
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = "New Trainee Set Stop Comment";
        traineeTraineeFeedbackFormPage = traineeTraineeFeedbackFormPage.clickOnStopAndSetComment(testString);
        Assertions.assertEquals(testString, driver.findElement(By.id("stopTrainee")).getAttribute("value"));
    }

    @Test
    @DisplayName("Click On Start And Set Comment")
    void clickOnStartAndSetComment() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = "New Trainee Set Start Comment";
        traineeTraineeFeedbackFormPage = traineeTraineeFeedbackFormPage.clickOnStartAndSetComment(testString);
        Assertions.assertEquals(testString, driver.findElement(By.id("startTrainee")).getAttribute("value"));
    }

    @Test
    @DisplayName("Click onContinue and Set Comment")
    void clickOnContinueAndSetComment() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        String testString = "New Trainee Set Continue Comment";
        traineeTraineeFeedbackFormPage = traineeTraineeFeedbackFormPage.clickOnContAndSetComments(testString);
        Assertions.assertEquals(testString, driver.findElement(By.id("continueTrainee")).getAttribute("value"));

    }

    @Test
    @DisplayName("Check If Displayed")
    void checkIfDisplayedTest() {
        By saveButton = new By.ById("saveBtn");
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.checkIfDisplayed(saveButton));

    }

    @Test
    @DisplayName("Are Trainee Comment Boxes Interactive")
    void areTraineeCommentBoxesInteractive() {
        traineeTraineeFeedbackFormPage = traineeHomePage.clickFeedbackFormForWeek(unsubmittedWeek);
        Assertions.assertTrue(traineeTraineeFeedbackFormPage.areTraineeCommentBoxesInteractive());
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

