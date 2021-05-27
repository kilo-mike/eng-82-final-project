package com.sparta.eng82.tests.unit.trainer;

import com.sparta.eng82.components.frameworkutil.PropertiesLoader;
import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.other.CompetenciesPage;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.trainer.ManageGroupPage;
import com.sparta.eng82.components.pages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.components.pages.trainer.addpages.AddStreamPageImpl;
import com.sparta.eng82.components.pages.trainer.feedbackpages.TrainerTraineeFeedbackFormPageImpl;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    @DisplayName("Does getUrl method returns the correct url for homepage")
    void doesGetUrlMethodReturnsTheCorrectUrl() {
        Assertions.assertTrue(trainerHomePage.getUrl().endsWith(":8080"));
    }


    // TODO:
//    @Test
//    @DisplayName("Check that the correct form is selected when specifying a student")
//    void checkThatTheCorrectFormIsSelectedWhenSpecifyingAStudent() {
//        TrainerTraineeFeedbackFormPageImpl trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "Jane Doe");
//
//        Assertions.assertEquals("http://localhost:8080/feedback?id=4", trainerTraineeFeedbackFormPage.getUrl());
//    }

    @Nested
    @DisplayName("Tests for the Trainer profile page")
    class TrainerProfilePage {

        @Test
        @DisplayName("Checking the displayed name is correct for the user")
        void checkingTheDisplayedNameIsCorrectForTheUser() {
            Assertions.assertTrue(trainerHomePage
                    .goToProfilePage()
                    .checkNameMatches());
        }

        @Test
        @DisplayName("Checking the displayed email is correct for the user")
        void checkingTheDisplayedEmailIsCorrectForTheUser() {
            Assertions.assertTrue(trainerHomePage
                    .goToProfilePage()
                    .checkEmailMatches());
        }
    }
    
    @Nested
    @DisplayName("Add pages tests")
    class TrainerAddPagesTests {

        @Test
        @DisplayName("checking that new trainee is succesfully added")
        void checkingThatNewTraineeIsSuccesfullyAdded() {
            Assertions.assertTrue(trainerHomePage
                    .clickManageGroupButton()
                    .addTrainee()
                    .enterFirstName("Golam")
                    .enterLastName("Choudhury")
                    .assignGroup("Engineering 80")
                    .isTraineeCreated("Golam Choudhury"));
        }
        
        //TODO: 
        @Test
        @DisplayName("checking that new group is successfully added")
        void checkingThatNewGroupIsSuccessfullyAdded() {
            trainerHomePage.clickManageGroupButton()
                    .addGroup()
                    .enterGroupName("Engineering 1")
                    .enterGroupStartDate("01052021")
                    .selectStream("Java SDET")
                    .createNewGroup()
                    .addTrainee()
                    .isGroupCreated("Engineering 1");
            
        }
        
        @Test
        @DisplayName("Is chosen stream name correct")
        void isChosenStreamNameCorrect() {
            Assertions.assertTrue(trainerHomePage
                    .clickManageGroupButton()
                    .addStream()
                    .enterStreamName("Business Analyst")
                    .isStreamNameCorrect("Business Analyst"));
        }

        @Test
        @DisplayName("Is chosen week correct")
        void isChosenWeekCorrect() {
            AddStreamPageImpl addStreamPage = trainerHomePage
                    .clickManageGroupButton()
                    .addStream()
                    .enterStreamDuration(10);
            Assertions.assertFalse(driver
                    .findElement(By.name("streamDuration"))
                    .getAttribute("value")
                    .equals("10 weeks"));
        }

        @Test
        @DisplayName("Is chosen stream description correct")
        void isChosenStreamDescriptionCorrect() {
            AddStreamPageImpl addStreamPage = trainerHomePage
                    .manageGroupButton()
                    .addStream()
                    .enterStreamDescription("Testing");
            Assertions.assertEquals("Testing", driver.findElement(By.name("streamDescription")).getAttribute("value"));
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
//        @Test
//        @DisplayName("Checking that the specified student is correctly selected")
//        void checkingThatTheSpecifiedStudentIsCorrectlySelected() {
//            TrainerTraineeFeedbackFormPage trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "JaneDoe");
//            Assertions.assertEquals("Jane Doe", 1);
//        }

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

        @Test
        @DisplayName("Test are Trainees Visible")
        void testAreTraineesVisible() {
            Assertions.assertTrue(trainerHomePage.areTraineesVisible());
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

        @Test
        @DisplayName("Checking if specified trainee present")
        void checkingIfSpecifiedTraineePresent() {
            Assertions.assertTrue(trainerHomePage.clickManageGroupButton().isStudentPresent("Jane Doe"));
        }

        // TODO: The below two tests need to be reworked
        @Test
        @DisplayName("Checking if a selected student is successfully removed")
        void checkingIfASelectedStudentIsSuccessfullyRemoved() {
            ManageGroupPage manageGroupPage = trainerHomePage.clickManageGroupButton();
            manageGroupPage.removeTrainee("Golam Choudhury").confirmTraineeDeletion();
            Assertions.assertFalse(manageGroupPage.isStudentPresent("Golam Choudhury"));
        }

        @Test
        @DisplayName("Checking if a new trainee is successfully added")
        void checkingIfANewTraineeIsSuccessfullyAdded() {
            ManageGroupPage manageGroupPage = trainerHomePage.clickManageGroupButton();
            manageGroupPage.addStudent("Jack", "Ingham");

            Assertions.assertTrue(trainerHomePage.clickManageGroupButton().isStudentPresent("Jack Ingham"));
        }
    }

    @Nested
    @DisplayName("TrainerTrainee Tests")
    class TrainerTraineeTests {

        @Test
        @DisplayName("Check that the technical grade is set AND saved as expected")
        void checkThatTheTechnicalGradeIsSetAndSavedAsExpected() {
            TrainerTraineeFeedbackFormPageImpl trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "Jane Doe");
            trainerTraineeFeedbackFormPage.setTechnicalGrade('D');
            trainerTraineeFeedbackFormPage.saveForm();
            trainerHomePage.selectTraineeName(2, "Jane Doe");
            Assertions.assertEquals("D", driver.findElement(By.name("technicalGrade")).findElement(By.xpath("//option[@selected=\"selected\"]")).getText());
        }

        @Test
        @DisplayName("Check that the consultant grade is set AND saved as expected")
        void checkThatTheConsultantGradeIsSetAndSavedAsExpected() {
            TrainerTraineeFeedbackFormPageImpl trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "Jane Doe");
            trainerTraineeFeedbackFormPage.setConsultantGrade('D');
            trainerTraineeFeedbackFormPage.saveForm();
            trainerHomePage.selectTraineeName(2, "Jane Doe");
            Assertions.assertEquals("D", driver.findElement(By.name("consultantGrade")).findElement(By.xpath("//option[@selected=\"selected\"]")).getText());
        }

        @Test
        @DisplayName("Check that clicking the Consultant Grade title opens the Competencies Page")
        void checkThatClickingTheConsultantGradeTitleOpensTheCompetenciesPage() {
            TrainerTraineeFeedbackFormPageImpl trainerTraineeFeedbackFormPage = trainerHomePage.selectTraineeName(2, "Jane Doe");
            if (trainerTraineeFeedbackFormPage.getSimpleName() != null) {
                CompetenciesPage competenciesPage = trainerTraineeFeedbackFormPage.clickConsultantGrade();
            }
            Assertions.assertTrue(driver.getCurrentUrl().endsWith("/competencies"));
        }

        @Test
        @DisplayName("Check submit works as intended")
        void checkSubmitWorksAsIntended() {
            new TrainerHomePageImpl(driver, "trainer")
                    .selectTraineeName(3, "Jane Doe")
                    .submitForm()
                    .logOut();

            Assertions.assertFalse(((TraineeHomePageImpl) ((TraineeHomePageImpl) new LoginPageImpl(driver, "trainee")
                    .login(PropertiesLoader.getEmail("trainee"), PropertiesLoader.getPassword("trainee")))
                    .clickFeedbackFormForWeek(3)
                    .submitForm())
                    .clickFeedbackFormForWeek(3)
                    .areTraineeCommentBoxesInteractive());
        }
    }
}