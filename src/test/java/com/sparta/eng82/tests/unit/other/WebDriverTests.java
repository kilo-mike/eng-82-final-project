package com.sparta.eng82.tests.unit.other;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.frameworkutil.DeviceTypes;
import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;

import java.util.EnumSet;



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

    @Test
    @DisplayName("Testing a specific window size")
    void testingASpecificWindowSize() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME, 500, 1000);
        driver.get("http://localhost:8080");
        boolean widthCheck = driver.manage().window().getSize().width >= 500;
        boolean heightCheck = driver.manage().window().getSize().height >= 1000;
        Assertions.assertTrue(heightCheck && widthCheck);
    }

    @ParameterizedTest
    @EnumSource(DeviceTypes.class)
    @DisplayName("Testing all devices")
    void testingAllDevices(DeviceTypes device) {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME, device);
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
