package com.sparta.eng82.tests.stepdefs.stepdefutil;

import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriverFactory webDriverFactory;
    public static WebDriver driverDoNotSubmit;
    public static WebDriver driverSubmissionsOnly;
    public static WebDriver driverNotTrainee;

    public static void setUp() {
        webDriverFactory = new WebDriverFactory();
        driverDoNotSubmit = webDriverFactory.getWebDriver(WebDriverTypes.CHROME_HEADLESS);
        driverSubmissionsOnly = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
      //  driverNotTrainee = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
    }

    public static void tearDown() {
        webDriverFactory.endAllServices();
    }
}
