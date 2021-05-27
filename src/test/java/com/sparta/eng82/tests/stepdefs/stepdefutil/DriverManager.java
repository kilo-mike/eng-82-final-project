package com.sparta.eng82.tests.stepdefs.stepdefutil;

import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriverFactory webDriverFactory;
    public static WebDriver driverDoNotSubmit;
    public static WebDriver driverSubmissionsOnly;

    public static void setUp() {
        webDriverFactory = new WebDriverFactory();
        driverSubmissionsOnly = webDriverFactory.getWebDriver(WebDriverTypes.CHROME); //only use this for checking submitted forms and submitting the form
        driverDoNotSubmit = webDriverFactory.getWebDriver(WebDriverTypes.CHROME); //admins and trainers should use this for all their tests, and some trainee tests

    }

    public static void tearDown() {
        webDriverFactory.endAllServices();
    }
}
