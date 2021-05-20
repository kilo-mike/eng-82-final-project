package com.sparta.eng82.interfaces.pages;

import com.sparta.eng82.components.pages.accesspages.LogoutPageImpl;
import com.sparta.eng82.components.pages.navpages.CompetenciesPageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminProfilePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeProfilePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerProfilePageImpl;
import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import com.sparta.eng82.interfaces.pages.navpages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.navpages.ProfilePage;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface NavPage extends Page {

    default Page goToHomePage(WebDriver driver) {
        driver.findElement(By.id("menuBtn-container")).findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("Home")).click();
        if (AdminHomePageImpl.class.equals(this.getClass())) {
            return new AdminHomePageImpl(driver);
        } else if (TrainerHomePageImpl.class.equals(this.getClass())) {
            return new TrainerHomePageImpl(driver);
        } else if (TraineeHomePageImpl.class.equals(this.getClass())) {
            return new TraineeHomePageImpl(driver);
        }
        return null;
    }

    default ProfilePage goToProfilePage(WebDriver driver) {
        // TODO ? maybe ? competencies -> profile etc, extend if statement with ORs
        Utility.timedMouseClicker(driver, Utility.TIME, By.cssSelector(".bi-list"));
        driver.findElement(By.linkText("Profile")).click();
        if (AdminHomePageImpl.class.equals(this.getClass())) {
            return new AdminProfilePageImpl(driver);
        } else if (TrainerHomePageImpl.class.equals(this.getClass())) {
            return new TrainerProfilePageImpl(driver);
        } else if (TraineeHomePageImpl.class.equals(this.getClass())) {
            return new TraineeProfilePageImpl(driver);
        }
        return null;
    }

    default CompetenciesPage goToCompetenciesPage(WebDriver driver) {
        driver.findElement(By.id("menuBtn-container")).findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("Behavioural Competencies")).click();
        return new CompetenciesPageImpl(driver);
    }

    default LoginPage logOut(WebDriver driver) {
        Utility.timedMouseClicker(driver, Utility.TIME, By.cssSelector(".bi-list"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("logoutBtn"))).click();
        return new LogoutPageImpl(driver);
    }
}
