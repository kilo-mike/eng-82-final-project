package refactor.tests.unit.admin;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import refactor.components.frameworkutil.WebDriverFactory;
import refactor.components.frameworkutil.WebDriverTypes;
import refactor.components.pages.admin.AddTrainerPageImpl;
import refactor.components.pages.admin.AdminHomePageImpl;
import refactor.components.pages.other.LoginPageImpl;

import java.util.Properties;

public class AdminHomePageTests {
    private static Properties properties;
    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";
    private final String adminPropertyName = "admin_name";
    private WebDriver driver;
    private static WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;
    private AdminHomePageImpl adminHomePage;
    private AddTrainerPageImpl addTrainerPage;
    private final String userAdmin = "admin";



    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();

    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        adminHomePage = (AdminHomePageImpl) new LoginPageImpl(driver, userAdmin).driverGet().enterEmail().enterPassword().clickLogin();
    }

    @Test
    @DisplayName("Add trainer test")
    void addTrainerTest() {
        Assertions.assertEquals(AddTrainerPageImpl.class, adminHomePage.addTrainer().getClass());
    }

    @Test
    @DisplayName("Is trainer added Test")
    void isTrainerAddedTest() {
        adminHomePage.addTrainer()
                .enterFirstName("test2")
                .enterSecondName("ssss")
                .selectGroup("No Group")
                .addNewTrainer();
        Assertions.assertTrue(adminHomePage.isTrainerAdded("test2", "ssss", "Not Assigned"));

    }

    @Test
    @DisplayName("Is the size of the return list with all the trainers right ")
    void isTheSizeOfTheReturnListWithAllTheTrainersRight() {
        Assertions.assertTrue(adminHomePage.getAllTrainersAvailable(6));
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @AfterAll
    static void tearDownAll() {
        webDriverFactory.endAllServices();
    }

}