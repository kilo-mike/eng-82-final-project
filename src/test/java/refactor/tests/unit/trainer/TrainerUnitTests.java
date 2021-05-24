package refactor.tests.unit.trainer;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import refactor.components.frameworkutil.PropertiesLoader;
import refactor.components.frameworkutil.WebDriverFactory;
import refactor.components.frameworkutil.WebDriverTypes;
import refactor.components.pages.other.CompetenciesPage;
import refactor.components.pages.other.LoginPageImpl;
import refactor.components.pages.trainee.TraineeHomePage;
import refactor.components.pages.trainee.feedback.TraineeTraineeFeedbackFormPage;
import refactor.components.pages.trainer.ManageGroupPage;
import refactor.components.pages.trainer.TrainerHomePageImpl;
import refactor.components.pages.trainer.feedbackpages.TrainerTraineeFeedbackFormPage;
import refactor.components.pages.trainer.feedbackpages.TrainerTraineeFeedbackFormPageImpl;

public class TrainerUnitTests {

    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private TrainerHomePageImpl trainerHomePage;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        trainerHomePage = (TrainerHomePageImpl) new LoginPageImpl(driver, "trainer").login();
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }

    @AfterAll
    static void tearDown() {
        webDriverFactory.endAllServices();
    }

    @Test
    @DisplayName("Check that the correct form is selected when specifying a student")
    void checkThatTheCorrectFormIsSelectedWhenSpecifyingAStudent() {
        TrainerTraineeFeedbackFormPageImpl trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "Jane Doe");

        Assertions.assertEquals("http://localhost:8080/feedback?id=4", trainerTraineeFeedbackFormPage.getUrl());
    }

    @Nested
    @DisplayName("Tests for the Trainer profile page")
    class TrainerProfilePage {

        // TODO: ProfilePage getName needs to be implemented
        @Test
        @DisplayName("Checking the displayed name is correct for the user")
        void checkingTheDisplayedNameIsCorrectForTheUser() {
            Assertions.assertTrue(trainerHomePage
                    .goToProfilePage()
                    .checkNameMatches());
        }

        // TODO: ProfilePage getEmail needs to be implemented
        @Test
        @DisplayName("Checking the displayed email is correct for the user")
        void checkingTheDisplayedEmailIsCorrectForTheUser() {
            Assertions.assertTrue(trainerHomePage
                    .goToProfilePage()
                    .checkEmailMatches());
        }
    }

    @Nested
    @DisplayName("Tests for the Trainer Home Page")
    class TrainerHomePageTests {

        @Test
        @DisplayName("Check the URL is correct when loading a new homepage")
        void checkTheUrlIsCorrectWhenLoadingANewHomepage() {
            Assertions.assertEquals("http://localhost:8080/", driver.getCurrentUrl());
        }

        // TODO:
        @Test
        @DisplayName("Checking that the specified student is correctly selected")
        void checkingThatTheSpecifiedStudentIsCorrectlySelected() {
            TrainerTraineeFeedbackFormPage trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "JaneDoe");
            Assertions.assertEquals("Jane Doe", 1);
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

        @Test
        @DisplayName("Checking that clicking on a specified week correctly selects that week")
        void checkingThatClickingOnASpecifiedWeekCorrectlySelectsThatWeek() {
            Assertions.assertTrue(trainerHomePage.isChosenWeekDisplayingAsCurrentlySelected(2));
        }
    }

    @Nested
    @DisplayName("Manage group page tests")
    class ManageGroupPageTests {

        @Test
        @DisplayName("Checking that manage group button takes the user to the correct page")
        void checkingThatManageGroupButtonTakesTheUserToTheCorrectPage() {
            ManageGroupPage manageGroupPage = trainerHomePage.clickManageGroupButton();

            Assertions.assertEquals("http://localhost:8080/group", driver.getCurrentUrl());
        }

        //TODO: Test incomplete, unable to click the delete trainee button
        @Test
        @DisplayName("Checking if a selected student is successfully removed")
        void checkingIfASelectedStudentIsSuccessfullyRemoved() {
            ManageGroupPage manageGroupPage = trainerHomePage.clickManageGroupButton();
            manageGroupPage.removeStudent("Alasdair Malcolm");
            Assertions.assertFalse(manageGroupPage.isTraineeRemoved("Golam Choudhury"));
        }

        // TODO: Not able to type the names in the fields, see method in ManageGroupPageImpl
        @Test
        @DisplayName("Checking if a new trainee is successfully added")
        void checkingIfANewTraineeIsSuccessfullyAdded() {
            ManageGroupPage manageGroupPage = trainerHomePage.clickManageGroupButton();
            manageGroupPage.addStudent("Jack", "Ingham");
            Assertions.assertTrue(manageGroupPage.isStudentPresent("Jack Ingham"));
        }
    }

    @Nested
    @DisplayName("TrainerTrainee Tests")
    class TrainerTraineeTests {

        @Test
        @DisplayName("Check that the technical grade is set AND saved as expected")
        void checkThatTheTechnicalGradeIsSetAndSavedAsExpected() {
            TrainerTraineeFeedbackFormPageImpl trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "Bob Smith");
            trainerTraineeFeedbackFormPage.setTechnicalGrade('D');
            trainerTraineeFeedbackFormPage.saveForm();
            trainerHomePage.selectTraineeName(2, "Bob Smith");
            Assertions.assertEquals("D", driver.findElement(By.name("technicalGrade")).findElement(By.xpath("//option[@selected=\"selected\"]")).getText());
        }

        @Test
        @DisplayName("Check that the consultant grade is set AND saved as expected")
        void checkThatTheConsultantGradeIsSetAndSavedAsExpected() {
            TrainerTraineeFeedbackFormPageImpl trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "Bob Smith");
            trainerTraineeFeedbackFormPage.setConsultantGrade('D');
            trainerTraineeFeedbackFormPage.saveForm();
            trainerHomePage.selectTraineeName(2, "Bob Smith");
            Assertions.assertEquals("D", driver.findElement(By.name("consultantGrade")).findElement(By.xpath("//option[@selected=\"selected\"]")).getText());
        }

        @Test
        @DisplayName("Check that clicking the Consultant Grade title opens the Competencies Page")
        void checkThatClickingTheConsultantGradeTitleOpensTheCompetenciesPage() {
            TrainerTraineeFeedbackFormPageImpl trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "Bob Smith");
            if (trainerTraineeFeedbackFormPage.getSimpleName() != null) {
                CompetenciesPage competenciesPage = trainerTraineeFeedbackFormPage.clickConsultantGrade();
            }
            Assertions.assertEquals("http://localhost:8080/competencies", driver.getCurrentUrl());
        }

        @Test
        @DisplayName("Check that the Submit Form button works for Trainers")
            //This test will likely NOT WORK if the trainee driver (driver2) is run headless.
        void checkThatTheSubmitFormButtonWorks() {

            TrainerTraineeFeedbackFormPageImpl trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "Jane Doe");
            trainerTraineeFeedbackFormPage.submitForm("Trainer");
            WebDriver driver2;
            driver2 = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
            driver2.get("http://localhost:8080/");
            LoginPageImpl loginPage2 = new LoginPageImpl(driver2, "trainee");
            TraineeHomePage traineeHomePage = (TraineeHomePage) loginPage2.login(PropertiesLoader.getEmail("trainee"), PropertiesLoader.getPassword("trainee"));

            TraineeTraineeFeedbackFormPage traineeTraineeFeedbackFormPage = (TraineeTraineeFeedbackFormPage) traineeHomePage.clickFeedbackFormForWeek(2);
            String testText = "hello, how are you?";
            boolean interactable = true;
            try {
                traineeTraineeFeedbackFormPage.editStopCommentBox(testText);
            } catch (ElementNotInteractableException e) {
                interactable = false;
            }
            Assertions.assertFalse(interactable);
        }
    }

    @Nested
    @DisplayName("TrainerTrainer tests")
    class TrainerTrainerTests {
        int week = 2;
        String name = "Jane Doe";

        @Test
        @DisplayName("Check comment inputs are working")
        void checkCommentInputsWork() {
            String stopComment = "Stop being bad";
            String startComment = "Start being good";
            String contComment = "Keep being OK";

            Assertions.assertTrue(trainerHomePage
                    .selectTraineeName(week, name)
                    .clickOnTrainer()
                    .enterStopStartContComments(stopComment, startComment, contComment)
                    .checkAllCommentsHaveBeenInputSuccessfully(stopComment, startComment, contComment));
        }
    }
}