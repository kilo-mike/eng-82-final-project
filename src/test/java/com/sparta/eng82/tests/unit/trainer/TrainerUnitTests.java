package com.sparta.eng82.tests.unit.trainer;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.interfaces.pages.navpages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeHomePage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTraineeFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerHomePage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.feedbackpages.TrainerTraineeFeedbackFormPage;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.EnumSet;
import java.util.Properties;

public class TrainerUnitTests {
    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private static EnumSet<WebDriverTypes> normalTypes;
    private static EnumSet<WebDriverTypes> headlessTypes;

    private static Properties properties;
    private final String trainerPropertyUsername = "trainer_username";
    private final String trainerPropertyPassword = "trainer_password";
    private final String trainerPropertyName = "trainer_name";

    private final String traineePropertyUsername = "trainee_username";
    private final String traineePropertyPassword = "trainee_password";
    private final String traineePropertyName = "trainee_name";

    private TrainerHomePage trainerHomePage;
    private LoginPageImpl loginPage;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
        normalTypes = EnumSet.of(WebDriverTypes.CHROME, WebDriverTypes.EDGE);
        headlessTypes = EnumSet.of(WebDriverTypes.CHROME_HEADLESS);
        properties = new Properties();
        Utility.loadProperties(properties);
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
        driver.get("http://localhost:8080/");
        loginPage = new LoginPageImpl(driver);
        loginPage.enterEmail(driver, trainerPropertyUsername, properties).enterPassword(driver, trainerPropertyPassword, properties);
        trainerHomePage = (TrainerHomePage) loginPage.login(driver, trainerPropertyName);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Check that the correct form is selected when specifying a student")
    void checkThatTheCorrectFormIsSelectedWhenSpecifyingAStudent() {
        TrainerTraineeFeedbackFormPage trainerTraineeFeedbackFormPage = trainerHomePage.selectJaneDoe();

        Assertions.assertEquals("http://localhost:8080/feedback?id=4", trainerTraineeFeedbackFormPage.getUrl(driver));
    }

    @Nested
    @DisplayName("Tests for the Trainer Home Page")
    class TrainerHomePageTests {

        @Test
        @DisplayName("Check the URL is correct when loading a new homepage")
        void checkTheUrlIsCorrectWhenLoadingANewHomepage() {
            driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
            driver.get("http://localhost:8080/");
            LoginPageImpl loginPage = new LoginPageImpl(driver);
            loginPage.enterEmail(driver, trainerPropertyUsername, properties).enterPassword(driver, trainerPropertyPassword, properties);
            loginPage.login(driver, trainerPropertyName);
            Assertions.assertEquals("http://localhost:8080/", driver.getCurrentUrl());
        }

        // TODO: Fix the selectTraineeName() class, 'unable to locate element'
        @Test
        @DisplayName("Checking that the specified student is correctly selected")
        void checkingThatTheSpecifiedStudentIsCorrectlySelected() {
            driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
            driver.get("http://localhost:8080/");
            LoginPageImpl loginPage = new LoginPageImpl(driver);
            loginPage.enterEmail(driver, trainerPropertyUsername, properties).enterPassword(driver, trainerPropertyPassword, properties);
            TrainerHomePage trainerHomePage = (TrainerHomePage) loginPage.login(driver, trainerPropertyName);

            TrainerTraineeFeedbackFormPage trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "JaneDoe");
        }

        @Test
        @DisplayName("Checking that manage group button takes the user to the correct page")
        void checkingThatManageGroupButtonTakesTheUserToTheCorrectPage() {
            ManageGroupPage manageGroupPage = trainerHomePage.manageGroupButton();

            Assertions.assertEquals("http://localhost:8080/group", driver.getCurrentUrl());
        }

        @Test
        @DisplayName("Checking that the displayed trainer name is correctly displayed on the homepage")
        void checkingThatTheDisplayedTrainerNameIsCorrectlyDisplayedOnTheHomepage() {
            Assertions.assertTrue(trainerHomePage.isUserDisplayNameCorrect());
        }

        @Test
        @DisplayName("Checking that the navbar is correctly appearing after clicking")
        void checkingThatTheNavbarIsCorrectlyAppearingAfterClicking() {
            Assertions.assertTrue(trainerHomePage.mainNavigationMenuAppears());
        }

        @RepeatedTest(3)
        @DisplayName("Checking that Navigation Menu correctly changes visibility after clicks")
        void checkingThatNavigationMenuCorrectlyChangesVisibilityAfterClicks() {
            Assertions.assertTrue(trainerHomePage.isNavigationMenuVisibilityChangingAfterClick());
        }

        //TODO: CHANGE THE TRAINER BACK TO MANISH IN login.properties
        @Test
        @DisplayName("Checking that clicking on a specified week correctly selects that week")
        void checkingThatClickingOnASpecifiedWeekCorrectlySelectsThatWeek() {
            Assertions.assertTrue(trainerHomePage.isChosenWeekDisplayingAsCurrentlySelected(2));
        }
    }

    @Nested
    @DisplayName("TrainerTrainee Tests")
    class TrainerTraineeTests {

        @Test
        @DisplayName("Check that the technical grade is set AND saved as expected")
        void checkThatTheTechnicalGradeIsSetAndSavedAsExpected() {
            TrainerTraineeFeedbackFormPage trainerTraineeFeedbackFormPage = trainerHomePage.selectJaneDoe();
            trainerTraineeFeedbackFormPage.setTechnicalGrade(driver, 'D');
            trainerTraineeFeedbackFormPage.saveForm(driver);
            trainerHomePage.selectJaneDoe();
            Assertions.assertEquals("D", driver.findElement(By.name("technicalGrade")).findElement(By.xpath("//option[@selected=\"selected\"]")).getText());
        }

        @Test
        @DisplayName("Check that the consultant grade is set AND saved as expected")
        void checkThatTheConsultantGradeIsSetAndSavedAsExpected() {
            TrainerTraineeFeedbackFormPage trainerTraineeFeedbackFormPage = trainerHomePage.selectJaneDoe();
            trainerTraineeFeedbackFormPage.setConsultantGrade(driver, 'D');
            trainerTraineeFeedbackFormPage.saveForm(driver);
            trainerHomePage.selectJaneDoe();
            Assertions.assertEquals("D", driver.findElement(By.name("consultantGrade")).findElement(By.xpath("//option[@selected=\"selected\"]")).getText());
        }

        @Test
        @DisplayName("Check that clicking the Consultant Grade title opens the Competencies Page")
        void checkThatClickingTheConsultantGradeTitleOpensTheCompetenciesPage() {
            TrainerTraineeFeedbackFormPage trainerTraineeFeedbackFormPage = trainerHomePage.selectJaneDoe();
            CompetenciesPage competenciesPage = trainerTraineeFeedbackFormPage.clickConsultantGrade(driver);
            Assertions.assertEquals("http://localhost:8080/competencies", driver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the Submit Form button works for Trainers")
        void checkThatTheSubmitFormButtonWorks() {
            TrainerTraineeFeedbackFormPage trainerTraineeFeedbackFormPage = trainerHomePage.selectJaneDoe();
            trainerTraineeFeedbackFormPage.submitForm(driver, "TrainerHomePageImpl");

            WebDriver driver2 = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
            driver2.get("http://localhost:8080/");
            LoginPageImpl loginPage2 = new LoginPageImpl(driver2);
            loginPage2.enterEmail(driver2, traineePropertyUsername, properties).enterPassword(driver2, traineePropertyPassword, properties);
            TraineeHomePage traineeHomePage = (TraineeHomePage) loginPage.login(driver2, traineePropertyName);

            TraineeTraineeFeedbackFormPage traineeTraineeFeedbackFormPage = (TraineeTraineeFeedbackFormPage) traineeHomePage.clickFeedbackFormForWeek(2);
            String testText = "hello, how are you?";
            boolean interactable = true;
            try {
                traineeTraineeFeedbackFormPage.setContinueCommentBox(testText);
            } catch (ElementNotInteractableException e) {
                interactable = false;
            }
            Assertions.assertFalse(interactable);
        }
    }

}

