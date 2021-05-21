package com.sparta.eng82.tests.unit.trainee.feedbackpages;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.feedbackpages.TraineeTrainerFeedbackFormPageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeHomePage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTraineeFeedbackFormPage;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class TraineeTraineeFeedbackFormPageTests {

    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;

    private final String traineePropertyUsername = "trainee_username";
    private final String traineePropertyPassword = "trainee_password";
    private final String traineePropertyName = "trainee_name";

    private static Properties properties;
    private TraineeHomePage traineeHomePage;
    private TraineeTraineeFeedbackFormPage traineeTraineeFeedbackFormPage;


    @BeforeAll
    static void setupAll() {
        properties = new Properties();
        Utility.loadProperties(properties);
    }

    @BeforeEach
    void setup() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        loginPage = new LoginPageImpl(driver);
        loginPage.enterEmail(driver, traineePropertyUsername, properties).enterPassword(driver, traineePropertyPassword,properties);
        traineeHomePage = (TraineeHomePage) loginPage.login(driver, traineePropertyName);
        traineeTraineeFeedbackFormPage = (TraineeTraineeFeedbackFormPage) traineeHomePage.clickFeedbackFormForWeek(2);
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
        Assertions.assertEquals("Trainee Stop Comment", traineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Test
    @DisplayName("Set Comment In Stop Box Test")
    void setCommentInStopBoxTest() {


    }

    @Test
    @DisplayName("Edit Comment In Stop Box Test")
    void editCommentInStopBoxTest() {

    }

    @Test
    @DisplayName("Delete Comment In Stop Box Test")
    void deleteCommentInStopBoxTest() {

    }

    @Test
    @DisplayName("Is Stop Comment Box Empty Test")
    void isStopCommentBoxEmptyTest() {

    }@Test
    @DisplayName("Is Stop Comment Box Disabled Test")
    void isStopCommentBoxDisabledTest() {

    }@Test
    @DisplayName("Is Stop Comment Box Enabled Before Submission Test")
    void isStopCommentBoxEnabledBeforeSubmissionTest() {

    }

    @Test
    @DisplayName("Click Start Tab Test")
    void clickStartTabTest() {

    }

    @Test
    @DisplayName("Get Comment From Start Box Test")
    void getCommentFromStartBoxTest() {

    }

    @Test
    @DisplayName("Set Comment In Start Box Test")
    void setCommentInStartBoxTest() {

    }

    @Test
    @DisplayName("Edit Comment In Start Box Test")
    void editCommentInStartBoxTest() {

    }

    @Test
    @DisplayName("Delete Comment In Start Box Test")
    void deleteCommentInStartBoxTest() {

    }

    @Test
    @DisplayName("Is Start Comment Box Empty Test")
    void isStartCommentBoxEmptyTest() {

    }@Test
    @DisplayName("Is Start Comment Box Disabled Test")
    void isStartCommentBoxDisabledTest() {

    }@Test
    @DisplayName("Is Start Comment Box Enabled Before Submission Test")
    void isStartCommentBoxEnabledBeforeSubmissionTest() {

    }

    @Test
    @DisplayName("Click Continue Tab Test")
    void clickContinueTabTest() {

    }

    @Test
    @DisplayName("Get Comment From Continue Box Test")
    void getCommentFromContinueBoxTest() {

    }

    @Test
    @DisplayName("Set Comment In Continue Box Test")
    void setCommentInContinueBoxTest() {

    }

    @Test
    @DisplayName("Edit Comment In Continue Box Test")
    void editCommentInContinueBoxTest() {

    }

    @Test
    @DisplayName("Delete Comment In Continue Box Test")
    void deleteCommentInContinueBoxTest() {

    }

    @Test
    @DisplayName("Is Continue Comment Box Empty Test")
    void isContinueCommentBoxEmptyTest() {

    }@Test
    @DisplayName("Is Continue Comment Box Disabled Test")
    void isContinueCommentBoxDisabledTest() {

    }@Test
    @DisplayName("Is Continue Comment Box Enabled Before Submission Test")
    void isContinueCommentBoxEnabledBeforeSubmissionTest() {

    }

    @Test
    @DisplayName("Get Comment From Trainer Comment Box Test")
    void getCommentFromTrainerCommentBoxTest() {

    }

    @Test
    @DisplayName("Set Comment In Trainer Comment Box Test")
    void setCommentInTrainerCommentBoxTest() {

    }

    @Test
    @DisplayName("Delete Comment In Trainer Comment Box Test")
    void deleteCommentInTrainerCommentBoxTest() {

    }

    @Test
    @DisplayName("Is Trainer Comment Comment Box Empty Test")
    void isTrainerCommentCommentBoxEmptyTest() {

    }@Test
    @DisplayName("Is Trainer Comment Comment Box Disabled Test")
    void isTrainerCommentCommentBoxDisabledTest() {

    }

    @AfterAll
    static void tearDown() {
        webDriverFactory.endAllServices();
    }

    @AfterEach
    void closeWindow(){
        driver.close();
    }

}

