package com.sparta.eng82.components.pages.accesspages;

import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.frameworkutil.PropertiesLoader;
import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import com.sparta.eng82.tests.unit.frameworkutil.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageImpl implements LoginPage {

    private final WebDriver driver;
    private final String user;

    public LoginPageImpl(WebDriver driver, String user) {
        this.driver = driver;
        this.user = user;
        driver.get("http://localhost:8080/login");
    }

    @Override
    public LoginPage enterEmail() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("username")).sendKeys(PropertiesLoader.USER_PROPERTIES.getProperty(user + "_username"));
        return this;
    }

    @Override
    public LoginPage enterEmail(String email) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("username")).sendKeys(email);
        return this;
    }

    @Override
    public LoginPage enterPassword() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("password")).sendKeys(properties.getProperty(user + "_password"));
        return this;
    }

    @Override
    public LoginPage enterPassword(String password) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("password")).sendKeys(password);
        return this;
    }

    @Override
    public NavPage login() {
        driver.findElement(new By.ById("loginBtn")).click();
        switch (user) {
            case "admin":
                return new AdminHomePageImpl(driver);
            case "trainer":
                return new TrainerHomePageImpl(driver);
            case "trainee":
                return new TraineeHomePageImpl(driver);
        }
        return null;
    }

    @Override
    public boolean loginAttempt() {
        enterEmail().enterPassword().login();
        return driver.getCurrentUrl().endsWith("/");
    }

    @Override
    public boolean wrongPasswordAttempt() {
        enterEmail().enterPassword().login();
        return driver.getCurrentUrl().endsWith("login?error");
    }
}
