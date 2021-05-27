package com.sparta.eng82.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.frameworkutil.ActionClicker;
import com.sparta.eng82.components.frameworkutil.Users;
import com.sparta.eng82.components.pages.ProfilePage;
import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.admin.AdminProfilePageImpl;
import com.sparta.eng82.components.pages.other.CompetenciesPageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeProfilePageImpl;
import com.sparta.eng82.components.pages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.components.pages.trainer.TrainerProfilePageImpl;

import java.util.concurrent.TimeUnit;

public abstract class NavPage implements Page {

    private WebDriver driver;
    private String user;

    public NavPage(WebDriver driver, String user) {
        this.driver = driver;
        this.user = user;
    }

    public boolean isOnCompetenciesPage() {
        return driver.getCurrentUrl().endsWith("competencies");
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
