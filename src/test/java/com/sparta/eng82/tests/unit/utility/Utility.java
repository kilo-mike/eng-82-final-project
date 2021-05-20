package com.sparta.eng82.tests.unit.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utility {
    public static void loadProperties(Properties properties) {
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void timedMouseClicker(WebDriver driver, long timeMilli, By by) {
        new Actions(driver).moveToElement(driver.findElement(by))
                .click()
                .pause(timeMilli)
                .click()
                .build()
                .perform();
    }
}
