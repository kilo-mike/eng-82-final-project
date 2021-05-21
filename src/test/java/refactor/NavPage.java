package refactor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.frameworkutil.ActionClicker;
import refactor.pages.LoginPageImpl;

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

//    public Page goToHomePage() {
//        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector(".bi-list"));
//        driver.findElement(By.linkText("Home")).click();
//        if (AdminHomePageImpl.class.equals(this.getClass())) {
//            return new AdminHomePageImpl(driver);
//        } else if (TrainerHomePageImpl.class.equals(this.getClass())) {
//            return new TrainerHomePageImpl(driver);
//        } else if (TraineeHomePageImpl.class.equals(this.getClass())) {
//            return new TraineeHomePageImpl(driver);
//        }
//        return null;
//    }
//
//    public ProfilePage goToProfilePage() {
//        // TODO ? maybe ? competencies -> profile etc, extend if statement with ORs
//        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector(".bi-list"));
//        driver.findElement(By.linkText("Profile")).click();
//        if (AdminHomePageImpl.class.equals(this.getClass())) {
//            return new AdminProfilePageImpl(driver);
//        } else if (TrainerHomePageImpl.class.equals(this.getClass())) {
//            return new TrainerProfilePageImpl(driver);
//        } else if (TraineeHomePageImpl.class.equals(this.getClass())) {
//            return new TraineeProfilePageImpl(driver);
//        }
//        return null;
//    }
//
//    public CompetenciesPage goToCompetenciesPage() {
//        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector(".bi-list"));
//        driver.findElement(By.linkText("Behavioural Competencies")).click();
//        return new CompetenciesPageImpl(driver);
//    }

    public LoginPageImpl logOut() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector(".bi-list"));
        driver.findElement(By.id("logoutBtn")).click();
        return new LoginPageImpl(driver, user);
    }
}
