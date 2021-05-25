package refactor.tests.unit.trainer;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import refactor.components.frameworkutil.WebDriverFactory;
import refactor.components.frameworkutil.WebDriverTypes;
import refactor.components.pages.other.LoginPageImpl;
import refactor.components.pages.trainer.TrainerHomePageImpl;
import refactor.components.pages.trainer.feedbackpages.TrainerTrainerFeedbackFormPageImpl;

public class TrainerTrainerTests {

    private WebDriver driver;
    private static WebDriverFactory webDriverFactory;
    private final int week = 2;
    private final String name = "Jane Doe";
    private final String stopComment = "Stop being bad";
    private final String startComment = "Start being good";
    private final String contComment = "Keep being OK";
    private final String trainerComment = "Not bad!";

    private static TrainerTrainerFeedbackFormPageImpl trainerTrainerFeedbackFormPage;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        trainerTrainerFeedbackFormPage = ((TrainerHomePageImpl) new LoginPageImpl(driver, "trainer").login())
                .selectTraineeName(week, name)
                .clickOnTrainer();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @AfterAll
    static void tearDownAll() {
        webDriverFactory.endAllServices();
    }

    @Test
    @DisplayName("Check trainer section is visible")
    void checkTrainerSectionIsVisible() {
        Assertions.assertTrue(trainerTrainerFeedbackFormPage.isTrainerDisplayed());
    }

    @Test
    @DisplayName("Check if clicking on trainee section works")
    void checkIfClickingOnTraineeSectionWorks() {
        Assertions.assertTrue(trainerTrainerFeedbackFormPage.clickOnTrainee().isTraineeDisplayed());
    }

    @Test
    @DisplayName("Check comment inputs are working")
    void checkCommentInputsWork() {
        Assertions.assertTrue(trainerTrainerFeedbackFormPage
                .enterAllComments(stopComment, startComment, contComment, trainerComment)
                .checkAllCommentsHaveBeenInputSuccessfully(stopComment, startComment, contComment, trainerComment));
    }

    @Nested
    @DisplayName("Check save feature")
    class SaveFeature {
        @Test
        @DisplayName("Check save feature works")
        void checkSaveFeatureWorks() {
            Assertions.assertTrue(trainerTrainerFeedbackFormPage
                    .checkSaveFeatureWorks(week, name, stopComment, startComment, contComment, trainerComment));
        }

        @AfterEach
        void tearDown() {
            trainerTrainerFeedbackFormPage.clearCommentsAndSave();
        }
    }
}
