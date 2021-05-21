//package com.sparta.eng82.components.pages.accesspages;
//
//import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
//import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
//import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
//import com.sparta.eng82.interfaces.pages.NavPage;
//import com.sparta.eng82.interfaces.pages.accesspages.ChangePasswordPage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class ChangePasswordPageImpl implements ChangePasswordPage {
//
//    private final By currentPassword = new By.ByName("currentPassword");
//    private final By newPassword = new By.ByName("newPassword");
//    private final By confirmPassword = new By.ByName("confirmPassword");
//    private final By changePasswordButton = new By.ById("loginBtn");
//
//    WebDriver driver;
//
//
//    public ChangePasswordPageImpl(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    @Override
//    public ChangePasswordPage enterCurrentPassword(String password) {
//        driver.findElement(currentPassword).sendKeys(password);
//        return this;
//    }
//
//    @Override
//    public ChangePasswordPage enterNewPassword(String password) {
//        driver.findElement(newPassword).sendKeys(password);
//        return this;
//    }
//
//    @Override
//    public ChangePasswordPage enterConfirmPassword(String password) {
//        driver.findElement(confirmPassword).sendKeys(password);
//        return this;
//    }
//
//    /**
//     * @param user can be either "admin", "trainer" or "trainee"
//     */
//    @Override
//    public NavPage clickChange(String user) {
//        driver.findElement(changePasswordButton).click();
//        switch (user) {
//            case "admin":
//                return new AdminHomePageImpl(driver, user);
//            case "trainer":
//                return new TrainerHomePageImpl(driver, user);
//            case "trainee":
//                return new TraineeHomePageImpl(driver, user);
//        }
//        return null;
//    }
//
//    @Override
//    public boolean changePasswordAttempt(String user, String currentPassword, String newPassword, String confirmPassword) {
//        enterCurrentPassword(confirmPassword).enterNewPassword(newPassword).enterConfirmPassword(confirmPassword).clickChange(user);
//        return !getUrl().endsWith("change-password");
//    }
//}
