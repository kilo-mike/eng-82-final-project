package com.sparta.eng82.components.webdriver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

//TODO Remove this for final release - just for testing currently

public class WebDriverTests {

    static WebDriver driver;

    @ParameterizedTest
    @EnumSource(WebDriverTypes.class)
    void testAllDriverTypes(WebDriverTypes webDriverType){
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(webDriverType);
        driver.manage().window().setSize(new Dimension(375,812));
        driver.get("http://localhost:8080");
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
