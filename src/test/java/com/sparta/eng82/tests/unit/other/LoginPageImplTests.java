package com.sparta.eng82.tests.unit.other;


import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.accesspages.LogoutPageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPageImplTests {

    private WebDriver driver;
    private static WebDriverFactory webDriverFactory;

    private LoginPageImpl loginPage;
    private LogoutPageImpl logoutPage;
    private AdminHomePageImpl adminHomePage;
    private TrainerHomePageImpl trainerHomePage;
    private TraineeHomePageImpl traineeHomePage;

    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";
    private final String adminPropertyName = "admin_name";

    private final String trainerPropertyUsername = "trainer_username";
    private final String trainerPropertyPassword = "trainer_password";
    private final String trainerPropertyName = "trainer_name";

    private final String traineePropertyUsername = "trainee_username";
    private final String traineePropertyPassword = "trainee_password";
    private final String traineePropertyName = "trainee_name";

    private static Properties properties;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
        properties = new Properties();
        Utility.loadProperties(properties);
    }

    @Nested
    @DisplayName("Admin tests")
    class AdminTests {
        @BeforeEach
        void setup() {
            driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
            loginPage = new LoginPageImpl(driver);
            logoutPage = new LogoutPageImpl(driver);
            adminHomePage = new AdminHomePageImpl(driver);
        }


        @Test
        @DisplayName("Enter email test")
        void enterEmailTest() {
            loginPage.enterEmail(driver, adminPropertyUsername, properties);
            Assertions.assertEquals(properties.getProperty(adminPropertyUsername), driver.findElement(new By.ById("username")).getAttribute("value"));
        }

        @Test
        @DisplayName("Enter password test")
        void enterPasswordTest() {
            loginPage.enterPassword(driver, adminPropertyPassword, properties);
            Assertions.assertEquals(properties.getProperty(adminPropertyPassword), driver.findElement(new By.ById("password")).getAttribute("value"));

        }

        @Test
        @DisplayName("Login test")
        void loginTest() {
            Assertions.assertNull(loginPage.login(driver, properties.getProperty(adminPropertyName)));
        }

        @Test
        @DisplayName("Login test with entered email and password")
        void loginTestWithEnteredEmailAndPassword() {
            loginPage.enterEmail(driver, adminPropertyUsername, properties);
            loginPage.enterPassword(driver, adminPropertyPassword, properties);
            loginPage.login(driver, properties.getProperty(adminPropertyName));
            Assertions.assertFalse(driver.getCurrentUrl().endsWith("/login"));
        }

        @Test
        @DisplayName("Login attempt test")
        void loginAttemptTest() {
            Assertions.assertTrue(loginPage.loginAttempt(driver, adminPropertyName, adminPropertyUsername, adminPropertyPassword, properties));
        }

        @RepeatedTest(10)
        @DisplayName("Logout check message for admin")
        void logoutCheckMessageForAdmin() {
            loginPage.enterEmail(driver, adminPropertyUsername, properties)
                    .enterPassword(driver, adminPropertyPassword, properties)
                    .login(driver, properties.getProperty(adminPropertyName));

            logoutPage = (LogoutPageImpl) adminHomePage.logOut(driver);

            Assertions.assertTrue(logoutPage.isLogoutMessageShowing());
        }

        @AfterEach
        void tearDown() {
            driver.quit();
        }
    }

    @Nested
    @DisplayName("Trainer tests")
    class TrainerTests {
        @BeforeEach
        void setup() {
            driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);

            loginPage = new LoginPageImpl(driver);
            trainerHomePage = new TrainerHomePageImpl(driver);
        }

        @RepeatedTest(10)
        @DisplayName("Logout check message for trainer")
        void logoutCheckMessageForTrainer() {
            loginPage.enterEmail(driver, trainerPropertyUsername, properties)
                    .enterPassword(driver, trainerPropertyPassword, properties)
                    .login(driver, properties.getProperty(trainerPropertyName));

            logoutPage = (LogoutPageImpl) trainerHomePage.logOut(driver);

            Assertions.assertTrue(logoutPage.isLogoutMessageShowing());

        }

        @Test
        @DisplayName("Login attempt test trainer")
        void loginAttemptTestTrainer() {
            Assertions.assertTrue(loginPage.loginAttempt(driver, trainerPropertyName, trainerPropertyUsername, trainerPropertyPassword, properties));
        }

        @AfterEach
        void tearDown() {
            driver.quit();
        }
    }

    @Nested
    @DisplayName("Trainee tests")
    class TraineeTests {
        @BeforeEach
        void setup() {
            driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);

            loginPage = new LoginPageImpl(driver);
            traineeHomePage = new TraineeHomePageImpl(driver);
        }

        @Test
        @DisplayName("Login attempt test trainee")
        void loginAttemptTestTrainee() {
            Assertions.assertTrue(loginPage.loginAttempt(driver, traineePropertyName, traineePropertyUsername, traineePropertyPassword, properties));
        }

        @RepeatedTest(10)
        @DisplayName("Logout check message for trainee")
        void logoutCheckMessageForTrainee() {
            loginPage.enterEmail(driver, traineePropertyUsername, properties)
                    .enterPassword(driver, traineePropertyPassword, properties)
                    .login(driver, properties.getProperty(traineePropertyName));

            logoutPage = (LogoutPageImpl) traineeHomePage.logOut(driver);

            Assertions.assertTrue(logoutPage.isLogoutMessageShowing());
        }

        @AfterEach
        void tearDown() {
            driver.quit();
        }

    }
}
