package refactor.tests.unit.trainee;



import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import refactor.components.frameworkutil.WebDriverFactory;
import refactor.components.frameworkutil.WebDriverTypes;
import refactor.components.pages.other.LoginPageImpl;
import refactor.components.pages.trainee.TraineeHomePage;
import refactor.components.pages.trainee.TraineeHomePageImpl;
import refactor.components.pages.trainee.TraineeProfilePageImpl;

import java.util.EnumSet;
import java.util.Properties;

public class TraineeProfilePageTests {

    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private static EnumSet<WebDriverTypes> normalTypes;
    private static EnumSet<WebDriverTypes> headlessTypes;

    private TraineeProfilePageImpl traineeProfilePage;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
        normalTypes = EnumSet.of(WebDriverTypes.CHROME, WebDriverTypes.EDGE);
        headlessTypes = EnumSet.of(WebDriverTypes.CHROME_HEADLESS);

    }

    @BeforeEach
    void setup() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        traineeProfilePage = (TraineeProfilePageImpl) new LoginPageImpl(driver, "trainee").login().goToProfilePage();
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }


    @AfterAll
    static void tearDown() {
        webDriverFactory.endAllServices();
    }


    private static EnumSet<WebDriverTypes> getNormalTypes() {
        return normalTypes;
    }

    private static EnumSet<WebDriverTypes> getHeadlessTypes() {
        return headlessTypes;
    }


    @Test
    @DisplayName("is Technical Grade Valid Test")
    void isTechnicalGradeValidTest() {
        Assertions.assertTrue(traineeProfilePage.isTechnicalGradeValid());
    }

    @Test
    @DisplayName("is Consultant Grade Valid Test")
    void isConsultantGradeValidTest() {
        Assertions.assertTrue(traineeProfilePage.isTechnicalGradeValid());
    }

    @Test
    @DisplayName("is Both Grades Valid Test")
    void isBothGradesValidTest() {
        Assertions.assertTrue(traineeProfilePage.areBothGradesValid());

    }
}
