package com.sparta.eng82.tests.unit.trainee;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeHomePage;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.EnumSet;
import java.util.Properties;

public class TraineeProfilePageTests {

    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private static EnumSet<WebDriverTypes> normalTypes;
    private static EnumSet<WebDriverTypes> headlessTypes;

    private static Properties properties;
    private final String traineePropertyUsername = "trainee_username";
    private final String traineePropertyPassword = "trainee_password";
    private final String traineePropertyName = "trainee_name";

    private LoginPageImpl loginPage;
    private TraineeHomePage traineeHomePage;

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
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        driver.get("http://localhost:8080/");
        loginPage = new LoginPageImpl(driver);
        loginPage.enterEmail(driver, traineePropertyUsername, properties).enterPassword(driver, traineePropertyPassword, properties);
        traineeHomePage = (TraineeHomePage) loginPage.login(driver, traineePropertyName);
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

    }

    @Test
    @DisplayName("is Consultant Grade Valid Test")
    void isConsultantGradeValidTest() {

    }

    @Test
    @DisplayName("is Both Grades Valid Test")
    void isBothGradesValidTest() {

    }
}
