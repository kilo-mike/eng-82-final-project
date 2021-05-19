package com.sparta.eng82.tests.unit.other;


import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPageImplTests {

    private WebDriver driver;
    private WebDriverFactory webDriverFactory;
    private LoginPageImpl loginPage;

    private final String adminPropertyUsername = "admin_username";
    private final String adminPropertyPassword = "admin_password";

    private static Properties properties;

    @BeforeAll
    static void setupAll() {
        properties = new Properties();
        Utility.loadProperties(properties);
    }

    @BeforeEach
    void setup() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        loginPage = new LoginPageImpl(driver);
    }

    @Test
    @DisplayName("enterEmailTest")
    void enterEmailTest() {
        loginPage.enterEmail(adminPropertyUsername, properties);
        Assertions.assertEquals(driver.findElement(new By.ById("username")).getAttribute("value"), properties.getProperty(adminPropertyUsername));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
