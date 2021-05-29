package com.sparta.eng82.tests.unit.trainee;



import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeProfilePageImpl;

import java.util.EnumSet;

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
