package com.sparta.eng82.components.pages.other;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.NavPage;
import com.sparta.eng82.components.frameworkutil.PropertiesLoader;
import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.trainer.TrainerHomePageImpl;

public class ChangePasswordPageImpl implements ChangePasswordPage {

    private final By byCurrentPassword = new By.ByName("currentPassword");
    private final By byNewPassword = new By.ByName("newPassword");
    private final By byConfirmPassword = new By.ByName("confirmPassword");
    private final By byChangePasswordButton = new By.ById("loginBtn");

    private final WebDriver driver;
    private final String user;


    public ChangePasswordPageImpl(WebDriver driver, String user) {
        this.driver = driver;
        this.user = user;
    }

    @Override
    public ChangePasswordPage enterCurrentPassword(String password) {
        driver.findElement(byCurrentPassword).sendKeys(password);
        return this;
    }

    @Override
    public ChangePasswordPage enterCurrentPassword(){
        driver.findElement(byCurrentPassword).sendKeys(PropertiesLoader.getPassword(user));
        return this;
    }

    @Override
    public ChangePasswordPage enterNewPassword(String password) {
        driver.findElement(byNewPassword).sendKeys(password);
        return this;
    }

    @Override
    public ChangePasswordPage enterConfirmPassword(String password) {
        driver.findElement(byConfirmPassword).sendKeys(password);
        return this;
    }

    /**
     * @param user can be either "admin", "trainer" or "trainee"
     */
    @Override
    public NavPage clickChange(String user) {
        driver.findElement(byChangePasswordButton).click();
        switch (user) {
            case "admin":
                return new AdminHomePageImpl(driver, user);
            case "trainer":
                return new TrainerHomePageImpl(driver, user);
            case "trainee":
                return new TraineeHomePageImpl(driver, user);
        }
        return null;
    }

    @Override
    public boolean changePasswordAttempt(String newPassword, String confirmPassword ) {
        enterCurrentPassword().enterNewPassword(newPassword).enterConfirmPassword(confirmPassword).clickChange(user);
        return !getUrl().endsWith("change-password");
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public int lengthOfCurrentPasswordInputValue(){
       return driver.findElement(byCurrentPassword).getAttribute("value").length();
    }

    @Override
    public int lengthOfNewPasswordInputValue(){
        return driver.findElement(byNewPassword).getAttribute("value").length();
    }

    @Override
    public int lengthOfConfirmPasswordInputValue(){
        return driver.findElement(byConfirmPassword).getAttribute("value").length();
    }
}
