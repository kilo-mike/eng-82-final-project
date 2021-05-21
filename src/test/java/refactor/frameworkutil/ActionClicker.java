package refactor.frameworkutil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClicker {
    public static final long TIME = 500;

    public static void timedMouseClicker(WebDriver driver, long timeMilli, By by) {
        new Actions(driver).moveToElement(driver.findElement(by))
                .click()
                .pause(timeMilli)
                .click()
                .build()
                .perform();
    }
}
