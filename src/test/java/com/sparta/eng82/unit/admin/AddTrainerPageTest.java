package com.sparta.eng82.unit.admin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;

public class AddTrainerPageTest {
    private final String user = "admin";
    private final String trainersFirstName = "Shelly";
    private final String trainersLastName = "Brown";
    private AdminHomePageImpl adminHomePage;

    private static WebDriver driver;
    private static WebDriverFactory webDriverFactory;

    @BeforeAll
    static void setupAll(){
        webDriverFactory = new WebDriverFactory();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        adminHomePage = (AdminHomePageImpl) new LoginPageImpl(driver, user).login();
    }

    @ParameterizedTest
    @ValueSource(strings = {"No Group"})
    @DisplayName("Can you select a group?")
    void canYouSelectAGroup(String group) {
        adminHomePage.addTrainer().enterFirstName(trainersFirstName).enterSecondName(trainersLastName).selectGroup(group);
        Assertions.assertEquals("-1", driver.findElement(By.id("addTrainerGroup")).getAttribute("value"));
    }

    @Nested
    class DoesTextShowUpInTextBox {
        @Test
        @DisplayName("Does text in first name show up?")
        void doesTextInFirstNameShowUp() {
            adminHomePage.addTrainer().enterFirstName(trainersFirstName);
            Assertions.assertEquals(trainersFirstName, driver.findElement(By.id("addtrainerFirstName")).getAttribute("value"));
        }

        @Test
        @DisplayName("Does text in last name show up?")
        void doesTextInLastNameShowUp() {
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
