package com.sparta.eng82.tests.stepdefs.stepdefutil;

import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriverFactory webDriverFactory;
    public static WebDriver driver;

    public static void setUp() {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
    }

    public static void tearDown() {
        driver.quit();
        webDriverFactory.endAllServices();
    }
}
