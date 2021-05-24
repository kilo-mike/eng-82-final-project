package refactor.tests.unit.trainee.feedbackpages;

import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.frameworkutil.WebDriverFactory;
import refactor.components.frameworkutil.WebDriverTypes;
import refactor.components.pages.other.LoginPageImpl;
import refactor.components.pages.trainee.TraineeHomePage;
import refactor.components.pages.trainee.TraineeHomePageImpl;
import refactor.components.pages.trainee.feedback.TraineeTraineeFeedbackFormPage;
import refactor.components.pages.trainee.feedback.TraineeTraineeFeedbackFormPageImpl;
import refactor.components.pages.trainee.feedback.TraineeTrainerFeedbackFormPageImpl;

import java.util.Properties;

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
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
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
        String testString = "Patrick";
        Assertions.assertEquals(testString, traineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @DisplayName("Set Comment In Stop Box Test")
    void setCommentInStopBoxTest() {
        String testString = "New Trainee Edit Stop Comment";
        TraineeHomePage newTraineeHomePage = traineeTraineeFeedbackFormPage.setStopCommentBox(testString);
        TraineeTraineeFeedbackFormPage newTraineeTraineeFeedbackFormPage = (TraineeTraineeFeedbackFormPage) newTraineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals(testString, newTraineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @DisplayName("Edit Comment In Stop Box Test")
    void editCommentInStopBoxTest() {
        String testString = "New Trainee Edit Stop Comment";
        TraineeHomePage newTraineeHomePage = traineeTraineeFeedbackFormPage.editStopCommentBox(testString);
        TraineeTraineeFeedbackFormPage newTraineeTraineeFeedbackFormPage = (TraineeTraineeFeedbackFormPage) newTraineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertTrue(newTraineeTraineeFeedbackFormPage.getStopCommentBox().contains(testString));
    }

    @Test
    @DisplayName("Delete Comment In Stop Box Test")
    void deleteCommentInStopBoxTest() {
        TraineeHomePage newTraineeHomePage = traineeTraineeFeedbackFormPage.deleteStopCommentBox();
        TraineeTraineeFeedbackFormPage newTraineeTraineeFeedbackFormPage = (TraineeTraineeFeedbackFormPage) newTraineeHomePage.clickFeedbackFormForWeek(2);
        Assertions.assertEquals("", newTraineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @Ignore
    @DisplayName("Is Stop Comment Box Empty Test")
    void isStopCommentBoxEmptyTest() {
    }

    @Test
    @Ignore
    @DisplayName("Is Stop Comment Box Disabled Test")
    void isStopCommentBoxDisabledTest() {
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

    }

    @Test
    @Ignore
    @DisplayName("Get Comment From Start Box Test")
    void getCommentFromStartBoxTest() {
    }

    @Test
    @Ignore
    @DisplayName("Set Comment In Start Box Test")
    void setCommentInStartBoxTest() {
    }

    @Test
    @Ignore
    @DisplayName("Edit Comment In Start Box Test")
    void editCommentInStartBoxTest() {
    }

    @Test
    @Ignore
    @DisplayName("Delete Comment In Start Box Test")
    void deleteCommentInStartBoxTest() {

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

    }

    @Test
    @Ignore
    @DisplayName("Get Comment From Continue Box Test")
    void getCommentFromContinueBoxTest() {

    }

    @Test
    @Ignore
    @DisplayName("Set Comment In Continue Box Test")
    void setCommentInContinueBoxTest() {

    }

    @Test
    @Ignore
    @DisplayName("Edit Comment In Continue Box Test")
    void editCommentInContinueBoxTest() {

    }

    @Test
    @Ignore
    @DisplayName("Delete Comment In Continue Box Test")
    void deleteCommentInContinueBoxTest() {

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

