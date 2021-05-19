package com.sparta.eng82.components.pages.accesspages;

import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeProfilePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerProfilePageImpl;
import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPageImpl implements LoginPage {

    WebDriver driver;


    private final By emailTextBox = new By.ById("username");
    private final By passwordTextBox = new By.ById("password");
    private final By loginButton = new By.ById("loginBtn");

    private final String adminName = "admin_name";
    private final String trainerName = "trainer_name";
    private final String traineeName = "trainee_name";


    public LoginPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public LoginPage enterEmail(String userPropertyUsername, Properties properties) {
        driver.findElement(emailTextBox).sendKeys(properties.getProperty(userPropertyUsername));
        return new LoginPageImpl(driver);
    }

    @Override
    public LoginPage enterPassword(String userPropertyPassword, Properties properties) {
        driver.findElement(passwordTextBox).sendKeys(properties.getProperty(userPropertyPassword));
        return new LoginPageImpl(driver);
    }

    /**
     * @param userPropertyName can be either "admin_name", "trainer_name" or "trainee_name"
     */
    @Override
    public Page login(String userPropertyName) {
        driver.findElement(loginButton).click();

        switch (userPropertyName) {
            case adminName:
                return new AdminHomePageImpl(driver);
            case trainerName:
                return new TrainerProfilePageImpl(driver);
            case traineeName:
                return new TraineeProfilePageImpl(driver);
        }
        return null;
    }

    @Override
    public boolean loginAttempt(String userPropertyName, String userPropertyUsername, String userPropertyPassword, Properties properties) {
        enterEmail(userPropertyUsername, properties);
        enterPassword(userPropertyPassword, properties);
        login(userPropertyName);
        return driver.getCurrentUrl().endsWith("/");
    }

    @Override
    public boolean isLogoutMessageShowing() {
        return getUrl(driver).endsWith("?logout");
    }
}
