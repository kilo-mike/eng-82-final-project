package com.sparta.eng82.tests.unit.admin;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.admin.addpages.AddTrainerPageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AddTainerPageTest {
    private static WebDriver driver;
    private static Properties properties;
    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";
    private final String adminPropertyName = "admin_name";
    private final String trainersFirstName = "Shelly";
    private final String trainersLastName = "Brown";
    private WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;
    private AdminHomePageImpl adminHomePage;
    private AddTrainerPageImpl addTrainerPage;

    @BeforeAll
    static void setupAll() {
        properties = new Properties();
        Utility.loadProperties(properties);
    }

    @AfterAll
    static void teardownAll() {
        driver.quit();
    }

    @BeforeEach
    void setup() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
        loginPage = new LoginPageImpl(driver);
        adminHomePage = new AdminHomePageImpl(driver);
    }

    //TEST WILL FAIL!!!!! As a method isn't working properly!
    @ParameterizedTest
    @ValueSource(strings = {"hola", "No Group"})
    @DisplayName("Can you select a group?")
    void canYouSelectAGroup(String group) {
        loginPage.enterEmail(driver, adminPropertyUsername, properties);
        loginPage.enterPassword(driver, adminPropertyPassword, properties);
        loginPage.login(driver, properties.getProperty(adminPropertyName));
        adminHomePage.addTrainer().selectGroup(group);//TODO SELECT GROUP NEEDS FIXING IN AddTrainerPageImpl
        Assertions.assertEquals(group, driver.findElement(By.id("addTrainerGroup")).getAttribute("value"));
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Nested
    class DoesTextShowUpInTextBox {
        @Test
        @DisplayName("Does text in first name show up?")
        void doesTextInFirstNameShowUp() {
            loginPage.enterEmail(driver, adminPropertyUsername, properties);
            loginPage.enterPassword(driver, adminPropertyPassword, properties);
            loginPage.login(driver, properties.getProperty(adminPropertyName));
            adminHomePage.addTrainer().enterFirstName(trainersFirstName);
            Assertions.assertEquals(trainersFirstName, driver.findElement(By.id("addtrainerFirstName")).getAttribute("value"));
        }

        @Test
        @DisplayName("Does text in last name show up?")
        void doesTextInLastNameShowUp() {
            loginPage.enterEmail(driver, adminPropertyUsername, properties);
            loginPage.enterPassword(driver, adminPropertyPassword, properties);
            loginPage.login(driver, properties.getProperty(adminPropertyName));
            adminHomePage.addTrainer().enterSecondName(trainersLastName);
            Assertions.assertEquals(trainersLastName, driver.findElement(By.id("addtrainerLastName")).getAttribute("value"));
        }
    }
}
