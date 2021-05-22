package refactor.tests.unit.other;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import refactor.NavPage;
import refactor.frameworkutil.WebDriverFactory;
import refactor.frameworkutil.WebDriverTypes;
import refactor.pages.other.LoginPageImpl;

public class CompetenciesPageImplTests {

    private static WebDriverFactory webDriverFactory;
    private WebDriver driver;
    private LoginPageImpl loginPage;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
    }

    @AfterAll
    static void tearDownAll() {
        webDriverFactory.endAllServices();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Navigate to competencies page")
    void navigateToCompetenciesPage(String user) {
        NavPage navPage = new LoginPageImpl(driver, user).driverGet().enterEmail()
                .enterPassword()
                .clickLogin()
                .goToCompetenciesPage();

        Assertions.assertTrue(navPage.isOnCompetenciesPage());
    }

//    @ParameterizedTest
//    @ValueSource(strings = {"admin", "trainer", "trainee"})
//    @DisplayName("Check that analytics section exists")
//    void checkThatAnalyticsSectionExists(String user) {
//        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
//                .enterPassword(driver, user + "_password", properties)
//                .login(driver, user + "_name")
//                .goToCompetenciesPage(driver)
//                .hasAnalyticSection());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"admin", "trainer", "trainee"})
//    @DisplayName("Check that independent section exists")
//    void checkThatIndependentSectionExists(String user) {
//        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
//                .enterPassword(driver, user + "_password", properties)
//                .login(driver, user + "_name")
//                .goToCompetenciesPage(driver)
//                .hasIndependentSection());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"admin", "trainer", "trainee"})
//    @DisplayName("Check that determined section exists")
//    void checkThatDeterminedSectionExists(String user) {
//        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
//                .enterPassword(driver, user + "_password", properties)
//                .login(driver, user + "_name")
//                .goToCompetenciesPage(driver)
//                .hasDeterminedSection());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"admin", "trainer", "trainee"})
//    @DisplayName("Check that professional section exists")
//    void checkThatProfessionalSectionExists(String user) {
//        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
//                .enterPassword(driver, user + "_password", properties)
//                .login(driver, user + "_name")
//                .goToCompetenciesPage(driver)
//                .hasProfessionalSection());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"admin", "trainer", "trainee"})
//    @DisplayName("Check that studious section exists")
//    void checkThatStudiousSectionExists(String user) {
//        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
//                .enterPassword(driver, user + "_password", properties)
//                .login(driver, user + "_name")
//                .goToCompetenciesPage(driver)
//                .hasStudiousSection());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"admin", "trainer", "trainee"})
//    @DisplayName("Check that imaginative section exists")
//    void checkThatImaginativeSectionExists(String user) {
//        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
//                .enterPassword(driver, user + "_password", properties)
//                .login(driver, user + "_name")
//                .goToCompetenciesPage(driver)
//                .hasImaginativeSection());
//    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
