package com.sparta.eng82.components.webdriver;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

//TODO Remove this for final release - just for testing currently

public class WebDriverTests {

    static WebDriver driver;
    static WebDriverFactory webDriverFactory;

    public static final EnumSet<WebDriverTypes> normalTypes = EnumSet.of(WebDriverTypes.CHROME, WebDriverTypes.EDGE);
    public static EnumSet<WebDriverTypes> headlessTypes = EnumSet.of(WebDriverTypes.CHROME_HEADLESS);

    @BeforeAll
    static void setup(){
        webDriverFactory = new WebDriverFactory();
    }

    @ParameterizedTest
    @MethodSource("normalTypesTest")
    @DisplayName("Test all normal types")
    void testAllDriverTypes(WebDriverTypes webDriverType){
        driver = webDriverFactory.getWebDriver(webDriverType);
        driver.get("http://localhost:8080");
        Assertions.assertEquals("http://localhost:8080/login", driver.getCurrentUrl());
    }

    private static Set<WebDriverTypes> normalTypesTest(){
        return normalTypes;
    }

    @ParameterizedTest
    @MethodSource("headlessTypesTest")
    @DisplayName("Testing headless")
    void testingHeadless(WebDriverTypes webDriverType) {
       driver = webDriverFactory.getWebDriver(webDriverType);
       driver.get("http://localhost:8080");
        Assertions.assertEquals("http://localhost:8080/login", driver.getCurrentUrl());
    }

    private static Set<WebDriverTypes> headlessTypesTest(){
        return headlessTypes;
    }

    @Test
    @DisplayName("Testing with one browser")
    void testingWithOneBrowser() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        driver.get("http://localhost:8080");
        Assertions.assertEquals("http://localhost:8080/login", driver.getCurrentUrl());
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
