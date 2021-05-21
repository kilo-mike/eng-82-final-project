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

import java.util.EnumSet;
import java.util.Properties;

public class AddTrainerPageTest {
    private static Properties properties;
    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";
    private final String adminPropertyName = "admin_name";
    private final String trainersFirstName = "Shelly";
    private final String trainersLastName = "Brown";
    private LoginPageImpl loginPage;
    private AdminHomePageImpl adminHomePage;
    private AddTrainerPageImpl addTrainerPage;

    private static WebDriver driver;
    private static WebDriverFactory webDriverFactory;

    @BeforeAll
    static void setupAll(){
        properties = new Properties();
        Utility.loadProperties(properties);
        webDriverFactory = new WebDriverFactory();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        loginPage = new LoginPageImpl(driver);
        adminHomePage = new AdminHomePageImpl(driver);
    }

//    //TEST WILL FAIL!!!!! As a method isn't working properly!
//    @ParameterizedTest
//    @ValueSource(strings = {"No Group"})
//    @DisplayName("Can you select a group?")
//    void canYouSelectAGroup(String group) {
//        loginPage.enterEmail(driver, adminPropertyUsername, properties);
//        loginPage.enterPassword(driver, adminPropertyPassword, properties);
//        loginPage.login(driver, properties.getProperty(adminPropertyName));
//        adminHomePage.addTrainer().selectGroup(group);//TODO SELECT GROUP NEEDS FIXING IN AddTrainerPageImpl
//        Assertions.assertEquals(group, driver.findElement(By.id("addTrainerGroup")).getAttribute("value"));
//    }

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
    @AfterEach
    void closeBrowser() {
        driver.close();
    }


    @AfterAll
    static void tearDownAll() {
        webDriverFactory.endAllServices();
    }
}
