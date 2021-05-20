package com.sparta.eng82.interfaces.pages.navpages;

import com.sparta.eng82.components.pages.navpages.CompetenciesPageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.interfaces.pages.NavPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Select drpConsultantGrade = new Select(driver.findElement(new By.ByName("ConsultantGrade")));
        drpConsultantGrade.selectByVisibleText(String.valueOf(grade));
        return this;
    }

    default CompetenciesPage clickConsultantGrade(WebDriver driver) {
        driver.findElement(new By.ByLinkText("Consultant Grade")).click();
        return new CompetenciesPageImpl(driver);
    }


    default NavPage saveForm(WebDriver driver) {
        driver.findElement(new By.ById("saveBtn")).click();
        return this;
    }

    /**
     * @param simpleName can be either "Trainer", "Trainee"
     */

    default NavPage submitForm(WebDriver driver, String simpleName) {
        driver.findElement(new By.ById("submitBtn")).click();
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
        String[] extractedWeek = driver.findElement(new By.ByXPath("//*[@id=\"feedbackText\"]/div/h1")).getText().split("/");
        return extractedWeek[1].trim();
    }
}
