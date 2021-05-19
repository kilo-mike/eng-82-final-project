package com.sparta.eng82.interfaces.pages.navpages;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.accesspages.ChangePasswordPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public interface ProfilePage extends NavPage {

    default ChangePasswordPage changePassword(WebDriver driver) {
        return new ChangePasswordPageImpl(driver);
    }

    default String getName(WebDriver driver) {
        return driver.findElement(new By.ByClassName("h5")).findElement(By.className("p-2 text-end")).getText();
    }

    default boolean checkNameMatches(Properties loginProperties, WebDriver driver) {
        return loginProperties.containsValue(getName(driver));
    }

    default String getEmail(WebDriver driver) {
        return driver.findElements(By.tagName("tbody")).get(1).findElement(By.className("p-2 text-end")).getText();
    }

    default boolean checkEmailMatches(Properties loginProperties, WebDriver driver) {
        return loginProperties.containsValue(getEmail(driver));

    }
}
