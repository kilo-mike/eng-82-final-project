package com.sparta.eng82.tests.unit.other;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.tests.unit.frameworkutil.PropertiesUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class CompetenciesPageImplTests {

    private static WebDriverFactory webDriverFactory;
    private static Properties properties;
    private WebDriver driver;
    private LoginPageImpl loginPage;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
        properties = new Properties();
        PropertiesUtil.loadProperties(properties);
    }

    @AfterAll
    static void tearDownAll() {
        webDriverFactory.endAllServices();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        loginPage = new LoginPageImpl(driver);
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Navigate to competencies page")
    void navigateToCompetenciesPage(String user) {
        loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToCompetenciesPage(driver);

        Assertions.assertTrue(driver.getCurrentUrl().endsWith("competencies"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that analytics section exists")
    void checkThatAnalyticsSectionExists(String user) {
        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToCompetenciesPage(driver)
                .hasAnalyticSection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that independent section exists")
    void checkThatIndependentSectionExists(String user) {
        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToCompetenciesPage(driver)
                .hasIndependentSection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that determined section exists")
    void checkThatDeterminedSectionExists(String user) {
        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToCompetenciesPage(driver)
                .hasDeterminedSection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that professional section exists")
    void checkThatProfessionalSectionExists(String user) {
        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToCompetenciesPage(driver)
                .hasProfessionalSection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that studious section exists")
    void checkThatStudiousSectionExists(String user) {
        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToCompetenciesPage(driver)
                .hasStudiousSection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "trainer", "trainee"})
    @DisplayName("Check that imaginative section exists")
    void checkThatImaginativeSectionExists(String user) {
        Assertions.assertTrue(loginPage.enterEmail(driver, user + "_username", properties)
                .enterPassword(driver, user + "_password", properties)
                .login(driver, user + "_name")
                .goToCompetenciesPage(driver)
                .hasImaginativeSection());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
