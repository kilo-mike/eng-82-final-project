package com.sparta.eng82.components.pages.accesspages;

import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.accesspages.ChangePasswordPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChangePasswordPageImpl implements ChangePasswordPage {

    private final By currentPassword = new By.ByName("currentPassword");
    private final By newPassword = new By.ByName("newPassword");
    private final By confirmPassword = new By.ByName("confirmPassword");
    private final By changePasswordButton = new By.ByName("Change");

    private final String adminHomeClassName = "AdminHomePageImpl";
    private final String traineeHomeClassName = "TraineeHomePageImpl";
    private final String trainerHomeClassName = "TrainerHomePageImpl";

    WebDriver driver;
    private final String simpleName;


    public ChangePasswordPageImpl(WebDriver driver, String simpleName) {
        this.driver = driver;
        this.simpleName = simpleName;
    }

    @Override
    public ChangePasswordPage enterCurrentPassword(String password) {
        driver.findElement(currentPassword).sendKeys(password);
        return this;
    }

    @Override
    public ChangePasswordPage enterNewPassword(String password) {
        driver.findElement(newPassword).sendKeys(password);
        return this;
    }

    @Override
    public ChangePasswordPage enterConfirmPassword(String password) {
        driver.findElement(confirmPassword).sendKeys(password);
        return this;
    }

    @Override
    public Page clickChange() {
        driver.findElement(changePasswordButton).click();
        switch (simpleName) {
            case adminHomeClassName:
                return new AdminHomePageImpl(driver);
            case traineeHomeClassName:
                return new TraineeHomePageImpl(driver);
            case trainerHomeClassName:
                return new TrainerHomePageImpl(driver);
        }
        return null;
    }

    @Override
    public boolean changePasswordAttempt(String currentPassword, String newPassword, String confirmPassword) {
        enterCurrentPassword(confirmPassword).enterNewPassword(newPassword).enterConfirmPassword(confirmPassword).clickChange();
        return !getUrl(driver).endsWith("change-password");
    }
}
