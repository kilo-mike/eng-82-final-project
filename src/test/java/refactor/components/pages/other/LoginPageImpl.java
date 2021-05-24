package refactor.components.pages.other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.NavPage;
import refactor.components.Page;
import refactor.components.frameworkutil.PropertiesLoader;
import refactor.components.pages.admin.AdminHomePageImpl;
import refactor.components.pages.trainee.TraineeHomePageImpl;
import refactor.components.pages.trainer.TrainerHomePageImpl;

import java.util.concurrent.TimeUnit;

public class LoginPageImpl implements LoginPage {

    private final WebDriver driver;
    private final String user;

    public LoginPageImpl(WebDriver driver, String user) {
        this.driver = driver;
        this.user = user;
    }

    @Override
    public LoginPageImpl driverGet() {
        driver.get("http://localhost:8080/login");
        return this;
    }

    @Override
    public LoginPageImpl enterEmail() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("username")).sendKeys(PropertiesLoader.getEmail(user));
        return this;
    }

    @Override
    public LoginPageImpl enterEmail(String email) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("username")).sendKeys(email);
        return this;
    }

    @Override
    public LoginPageImpl enterPassword() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("password")).sendKeys(PropertiesLoader.getPassword(user));
        return this;
    }

    @Override
    public LoginPageImpl enterPassword(String password) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ById("password")).sendKeys(password);
        return this;
    }

    @Override
    public NavPage login() {
        return this.driverGet().enterEmail(user).enterPassword(user).login();
    }

    @Override
    public NavPage login(String email, String password) {
        return this.driverGet().enterEmail(email).enterPassword(password).login();
    }

    @Override
    public NavPage clickLogin() {
        driver.findElement(new By.ById("loginBtn")).click();
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
    public boolean loginAttempt() {
        enterEmail().enterPassword().clickLogin();
        return driver.getCurrentUrl().endsWith("/");
    }

    @Override
    public boolean loginAttempt(String email, String password) {
        enterEmail(email).enterPassword(password).clickLogin();
        return driver.getCurrentUrl().endsWith("/");
    }

    @Override
    public boolean wrongPasswordAttempt(String wrongPassword) {
        enterEmail().enterPassword(wrongPassword).clickLogin();
        return driver.getCurrentUrl().endsWith("login?error");
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public boolean isLogoutMessageShowing() {
        return getUrl().endsWith("?logout");
    }

    public String getEmailInputValue() {
        return driver.findElement(By.id("username")).getAttribute("value");
    }

    public String getPasswordInputValue() {
        return driver.findElement(By.id("password")).getAttribute("value");
    }

    public boolean isOnLoginPage() {
        return getUrl().endsWith("/login");
    }
}
