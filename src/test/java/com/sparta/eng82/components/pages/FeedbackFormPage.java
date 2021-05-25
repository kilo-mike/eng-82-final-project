package com.sparta.eng82.components.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.sparta.eng82.components.NavPage;
import com.sparta.eng82.components.frameworkutil.ActionClicker;
import com.sparta.eng82.components.pages.other.CompetenciesPage;
import com.sparta.eng82.components.pages.other.CompetenciesPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.trainer.TrainerHomePageImpl;

import java.util.concurrent.TimeUnit;

public abstract class FeedbackFormPage extends NavPage {

    private final WebDriver driver;
    private final String user;

    public FeedbackFormPage(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
    }

    public NavPage setTechnicalGrade( char grade) {
        Select drpTechnicalGrade = new Select(driver.findElement(new By.ByName("technicalGrade")));
        drpTechnicalGrade.selectByVisibleText(String.valueOf(grade));
        return this;
    }

    public NavPage setConsultantGrade( char grade) {
        Select drpConsultantGrade = new Select(driver.findElement(new By.ByName("consultantGrade")));
        drpConsultantGrade.selectByVisibleText(String.valueOf(grade));
        return this;
    }

    public CompetenciesPage clickConsultantGrade() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, new By.ByLinkText("Consultant Grade"));
        return new CompetenciesPageImpl(driver,user);
    }


    public NavPage saveForm() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, new By.ById("saveBtn"));
        return this;
    }

    /**
     * @param simpleName can be either "Trainer", "Trainee"
     */
    public NavPage submitForm( String simpleName) {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, new By.ById("submitBtn"));
        switch (simpleName) {
            case "Trainee":
                return new TraineeHomePageImpl(driver, user);
            case "Trainer":
                return new TrainerHomePageImpl(driver, user);
        }
        return null;
    }
    public String getName( String name) {
        String[] extractedName = driver.findElement(new By.ByXPath("//*[@id=\"feedbackText\"]/div/h1")).getText().split("/");
        return extractedName[1].trim();
    }

    public String getWeek() {
        By textField = new By.ByXPath("//*[@id=\"feedbackText\"]/div/h1");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String[] extractedWeek = driver.findElement(textField).getText().split("/");
        return extractedWeek[1].trim();
    }
}
