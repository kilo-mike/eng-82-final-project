package com.sparta.eng82.interfaces.pages;

import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;
import com.sparta.eng82.components.pages.navpages.CompetenciesPageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.admin.AdminProfilePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeProfilePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.ProfilePageImpl;
import com.sparta.eng82.components.pages.navpages.CompetenciesPageImpl;
import com.sparta.eng82.components.pages.accesspages.LoginPageImpl;

import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerProfilePageImpl;
import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import com.sparta.eng82.interfaces.pages.navpages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.navpages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface NavPage extends Page {

    default Page goToHomePage(WebDriver driver) {
        driver.findElement(new By.ById("navbar Nav")).findElement(new By.ByLinkText("Home")).click();
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
        driver.findElement(new By.ById("navbar Nav")).findElement(new By.ByLinkText("Profile")).click();
        if (AdminProfilePageImpl.class.equals(this.getClass())) {
            return new AdminProfilePageImpl(driver);
        } else if (TrainerProfilePageImpl.class.equals(this.getClass())) {
            return new TrainerProfilePageImpl(driver);
        } else if (TraineeProfilePageImpl.class.equals(this.getClass())) {
            return new TraineeProfilePageImpl(driver);
        }
        return null;
    }

    default CompetenciesPage goToCompetenciesPage(WebDriver driver) {
        driver.findElement(new By.ById("navbar Nav")).findElement(new By.ByLinkText("Behavioural Competencies")).click();
        return new CompetenciesPageImpl(driver);
    }

    default LoginPage logOut(WebDriver driver) {
        driver.findElement(new By.ById("navbar Nav")).findElement(new By.ById("logoutBtn")).click();
        return new LoginPageImpl(driver);
    }

}
