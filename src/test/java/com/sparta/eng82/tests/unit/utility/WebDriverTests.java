package com.sparta.eng82.tests.unit.utility;

import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.EnumSet;

//TODO Remove this for final release - just for testing currently

public class WebDriverTests {

    static WebDriver driver;
    static WebDriverFactory webDriverFactory;
    private static EnumSet<WebDriverTypes> normalTypes;
    private static EnumSet<WebDriverTypes> headlessTypes;

    @BeforeAll
    static void setup() {
        webDriverFactory = new WebDriverFactory();
        normalTypes = EnumSet.of(WebDriverTypes.CHROME, WebDriverTypes.EDGE);
        headlessTypes = EnumSet.of(WebDriverTypes.CHROME_HEADLESS);
    }

    private static EnumSet<WebDriverTypes> getNormalTypes() {
        return normalTypes;
    }

    private static EnumSet<WebDriverTypes> getHeadlessTypes() {
        return headlessTypes;
    }

    @ParameterizedTest
    @MethodSource("getNormalTypes")
    @DisplayName("Test all normal types")
    void testAllDriverTypes(WebDriverTypes webDriverType) {
        driver = webDriverFactory.getWebDriver(webDriverType);
        driver.get("http://localhost:8080");
        Assertions.assertEquals("http://localhost:8080/login", driver.getCurrentUrl());
    }

    @ParameterizedTest
    @MethodSource("getHeadlessTypes")
    @DisplayName("Testing headless")
    void testingHeadless(WebDriverTypes webDriverType) {
        driver = webDriverFactory.getWebDriver(webDriverType);
        driver.get("http://localhost:8080");
        Assertions.assertEquals("http://localhost:8080/login", driver.getCurrentUrl());
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
        webDriverFactory.endAllServices();
    }
}
