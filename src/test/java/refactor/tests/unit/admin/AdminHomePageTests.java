//package refactor.tests.unit.admin;
//
//
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.WebDriver;
//import refactor.components.frameworkutil.WebDriverFactory;
//import refactor.components.frameworkutil.WebDriverTypes;
//import refactor.components.pages.admin.AddTrainerPageImpl;
//import refactor.components.pages.admin.AdminHomePageImpl;
//import refactor.components.pages.other.LoginPageImpl;
//
//import java.util.Properties;
//
//public class AdminHomePageTests {
//    private static Properties properties;
//    private final String adminPropertyUsername = "admin_username";
//    private final String adminPropertyPassword = "admin_password";
//    private final String adminPropertyName = "admin_name";
//    private WebDriver driver;
//    private static WebDriverFactory webDriverFactory;
//    private LoginPageImpl loginPage;
//    private AdminHomePageImpl adminHomePage;
//    private AddTrainerPageImpl addTrainerPage;
//
//    @BeforeAll
//    static void setupAll() {
//        properties = new Properties();
//        PropertiesUtil.loadProperties(properties);
//    }
//
//    @BeforeEach
//    void setup() {
//        webDriverFactory = new WebDriverFactory();
//        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
//        loginPage = new LoginPageImpl(driver,user);
//        adminHomePage = new AdminHomePageImpl(driver);
//    }
//
//    @Test
//    @DisplayName("Add trainer test")
//    void addTrainerTest() {
//        loginPage.enterEmail(driver, adminPropertyUsername, properties);
//        loginPage.enterPassword(driver, adminPropertyPassword, properties);
//        loginPage.login(driver, properties.getProperty(adminPropertyName));
//        addTrainerPage = (AddTrainerPageImpl) adminHomePage.addTrainer();
//        Assertions.assertEquals(AddTrainerPageImpl.class, addTrainerPage.getClass());
//    }
//
//    @Test
//    @DisplayName("Is trainer added Test")
//    void isTrainerAddedTest() {
//
//        loginPage.enterEmail(driver, adminPropertyUsername, properties);
//        loginPage.enterPassword(driver, adminPropertyPassword, properties);
//        loginPage.login(driver, properties.getProperty(adminPropertyName));
//        adminHomePage.addTrainer().enterFirstName("test3")
//                .enterSecondName("test3")
//                .selectGroup("No Group")
//                .addNewTrainer();
//        Assertions.assertTrue(adminHomePage.isTrainerAdded("test3", "test3", "Not Assigned"));
//    }
//
//    @Test
//    @DisplayName("Is the size of the return list with all the trainers right ")
//    void isTheSizeOfTheReturnListWithAllTheTrainersRight() {
//        loginPage.enterEmail(driver, adminPropertyUsername, properties);
//        loginPage.enterPassword(driver, adminPropertyPassword, properties);
//        loginPage.login(driver, properties.getProperty(adminPropertyName));
//        Assertions.assertTrue(adminHomePage.getAllTrainersAvailable(7));
//    }
//
//
//    @AfterEach
//    void tearDown() {
//        driver.quit();
//    }
//
//    @AfterAll
//    static void tearDownAll(){
//        webDriverFactory.endAllServices();
//    }
//
//}