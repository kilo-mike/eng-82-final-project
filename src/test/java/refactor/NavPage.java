package refactor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.frameworkutil.ActionClicker;
import refactor.frameworkutil.Users;
import refactor.pages.ProfilePage;
import refactor.pages.access.CompetenciesPageImpl;
import refactor.pages.access.LoginPageImpl;
import refactor.pages.admin.AdminHomePageImpl;
import refactor.pages.admin.AdminProfilePageImpl;
import refactor.pages.trainee.TraineeHomePageImpl;
import refactor.pages.trainee.TraineeProfilePageImpl;
import refactor.pages.trainer.TrainerHomePageImpl;
import refactor.pages.trainer.TrainerProfilePageImpl;

public abstract class NavPage implements Page {

    private WebDriver driver;
    private String user;

    public NavPage(WebDriver driver, String user) {
        this.driver = driver;
        this.user = user;
    }

    public boolean isOnHomePage() {
        return driver.getCurrentUrl().endsWith("/");
    }

    public NavPage goToHomePage() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector(".bi-list"));
        driver.findElement(By.linkText("Home")).click();
        switch (user) {
            case Users.ADMIN:
                return new AdminHomePageImpl(driver, user);
            case Users.TRAINER:
                return new TrainerHomePageImpl(driver, user);
            case Users.TRAINEE:
                return new TraineeHomePageImpl(driver, user);
        }
        return null;
    }

    public ProfilePage goToProfilePage() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector(".bi-list"));
        driver.findElement(By.linkText("Profile")).click();
        switch (user) {
            case Users.ADMIN:
                return new AdminProfilePageImpl(driver, user);
            case Users.TRAINER:
                return new TrainerProfilePageImpl(driver, user);
            case Users.TRAINEE:
                return new TraineeProfilePageImpl(driver, user);
        }
        return null;
    }

    public CompetenciesPageImpl goToCompetenciesPage() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector(".bi-list"));
        driver.findElement(By.linkText("Behavioural Competencies")).click();
        return new CompetenciesPageImpl(driver, user);
    }

    public LoginPageImpl logOut() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector(".bi-list"));
        driver.findElement(By.id("logoutBtn")).click();
        return new LoginPageImpl(driver, user);
    }
}
