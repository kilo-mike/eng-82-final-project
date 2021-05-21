package com.sparta.eng82.interfaces.pages.navpages;

import com.sparta.eng82.components.pages.navpages.CompetenciesPageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.tests.unit.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public interface FeedbackFormPage extends NavPage {

    /**
     * @param grade can be either "A", "B", "C" or "D"
     */
    default NavPage setTechnicalGrade(WebDriver driver, char grade) {
        Select drpTechnicalGrade = new Select(driver.findElement(new By.ByName("technicalGrade")));
        drpTechnicalGrade.selectByVisibleText(String.valueOf(grade));
        return this;
    }


    default NavPage setConsultantGrade(WebDriver driver, char grade) {
        Select drpConsultantGrade = new Select(driver.findElement(new By.ByName("consultantGrade")));
        drpConsultantGrade.selectByVisibleText(String.valueOf(grade));
        return this;
    }

    default CompetenciesPage clickConsultantGrade(WebDriver driver) {
        Utility.timedMouseClicker(driver, 500, new By.ByLinkText("Consultant Grade"));
        return new CompetenciesPageImpl(driver);
    }


    default NavPage saveForm(WebDriver driver) {
        Utility.timedMouseClicker(driver, 500, new By.ById("saveBtn"));
        return this;
    }

    /**
     * @param simpleName can be either "Trainer", "Trainee"
     */

    default NavPage submitForm(WebDriver driver, String simpleName) {
        Utility.timedMouseClicker(driver, 500, new By.ById("submitBtn"));
        switch (simpleName) {
            case "Trainee":
                return new TraineeHomePageImpl(driver);
            case "Trainer":
                return new TrainerHomePageImpl(driver);
        }
        return null;
    }

    default String getName(WebDriver driver, String name) {
        String[] extractedName = driver.findElement(new By.ByXPath("//*[@id=\"feedbackText\"]/div/h1")).getText().split("/");
        return extractedName[1].trim();
    }

    default String getWeek(WebDriver driver) {
        By textField = new By.ByXPath("//*[@id=\"feedbackText\"]/div/h1");
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(textField));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String[] extractedWeek = driver.findElement(textField).getText().split("/");
        return extractedWeek[1].trim();
    }
}
