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
        Select drpConsultantGrade = new Select(driver.findElement(new By.ByName("technicalGrade")));
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


    default NavPage submitForm(WebDriver driver) {
        driver.findElement(new By.ById("submitBtn")).click();
        if (TrainerHomePageImpl.class.equals(this.getClass())) {
            return new TrainerHomePageImpl(driver);
        } else if (TraineeHomePageImpl.class.equals(this.getClass())) {
            return new TraineeHomePageImpl(driver);
        }
        return null;
    }


    default String getName(WebDriver driver, String name) {
        String extractedName = driver.findElement(new By.ByClassName("mt-5 fw-bold text-center")).getText();
        Pattern pattern = Pattern.compile("(.*?)/");
        Matcher matcher = pattern.matcher(extractedName);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    default String getWeek(WebDriver driver, int week) {
        String extractedWeek = driver.findElement(new By.ByClassName("mt-5 fw-bold text-center")).getText();
        Pattern pattern = Pattern.compile("/ (.*?)");
        Matcher matcher = pattern.matcher(extractedWeek);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
