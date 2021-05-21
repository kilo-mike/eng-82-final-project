package com.sparta.eng82.interfaces.pages.accesspages;

import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.NavPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public interface LoginPage extends Page {

    default LoginPage enterEmail(WebDriver driver, String userPropertyUsername, Properties properties) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("username")).sendKeys(properties.getProperty(userPropertyUsername));
        return this;
    }

    default LoginPage enterEmail(WebDriver driver, String email) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("username")).sendKeys(email);
        return this;
    }

    default LoginPage enterPassword(WebDriver driver, String userPropertyPassword, Properties properties) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("password")).sendKeys(properties.getProperty(userPropertyPassword));
        return this;
    }

    default LoginPage enterPassword(WebDriver driver, String password) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("password")).sendKeys(password);
        return this;
    }

    /**
     * @param userPropertyName can be either "admin_name", "trainer_name" or "trainee_name"
     */
    default NavPage login(WebDriver driver, String userPropertyName) {
        driver.findElement(new By.ById("loginBtn")).click();
        switch (userPropertyName) {
            case "admin_name":
                return new AdminHomePageImpl(driver);
            case "trainer_name":
                return new TrainerHomePageImpl(driver);
            case "trainee_name":
                return new TraineeHomePageImpl(driver);
        }
        return null;
    }

    default boolean loginAttempt(WebDriver driver, String userPropertyName, String userPropertyUsername, String userPropertyPassword, Properties properties) {
        enterEmail(driver, userPropertyUsername, properties).enterPassword(driver, userPropertyPassword, properties).login(driver, userPropertyName);
        return driver.getCurrentUrl().endsWith("/");
    }

    default boolean wrongPasswordAttempt(WebDriver driver,String userPropertyUsername, String userPropertyName, String wrongPassword, Properties properties){
        enterEmail(driver, userPropertyUsername, properties).enterPassword(driver, wrongPassword).login(driver, userPropertyName);
        return driver.getCurrentUrl().endsWith("login?error");
    }
}
