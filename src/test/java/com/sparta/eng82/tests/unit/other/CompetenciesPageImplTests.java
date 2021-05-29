package com.sparta.eng82.tests.unit.other;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.other.LoginPageImpl;

public class CompetenciesPageImplTests {

    private static WebDriverFactory webDriverFactory;
    private WebDriver driver;

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
        Assertions.assertTrue(new LoginPageImpl(driver, user).driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToCompetenciesPage()
                .isOnCompetenciesPage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that analytics section exists")
    void checkThatAnalyticsSectionExists(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToCompetenciesPage()
                .hasAnalyticSection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that independent section exists")
    void checkThatIndependentSectionExists(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToCompetenciesPage()
                .hasIndependentSection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that determined section exists")
    void checkThatDeterminedSectionExists(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToCompetenciesPage()
                .hasDeterminedSection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that professional section exists")
    void checkThatProfessionalSectionExists(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToCompetenciesPage()
                .hasProfessionalSection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that studious section exists")
    void checkThatStudiousSectionExists(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToCompetenciesPage()
                .hasStudiousSection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that imaginative section exists")
    void checkThatImaginativeSectionExists(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToCompetenciesPage()
                .hasImaginativeSection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that has all sections")
    void checkThatHasAllSections(String user) {
        Assertions.assertTrue(new LoginPageImpl(driver, user)
                .driverGet()
                .enterEmail()
                .enterPassword()
                .clickLogin()
                .goToCompetenciesPage()
                .hasAllSections());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
