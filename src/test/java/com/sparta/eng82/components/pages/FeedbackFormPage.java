package com.sparta.eng82.components.pages;

import com.sparta.eng82.components.NavPage;
import com.sparta.eng82.components.frameworkutil.ActionClicker;
import com.sparta.eng82.components.pages.other.CompetenciesPage;
import com.sparta.eng82.components.pages.other.CompetenciesPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.trainer.TrainerHomePageImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class FeedbackFormPage extends NavPage {

    private final WebDriver driver;
    private final String user;

    public FeedbackFormPage(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
    }

    public NavPage setTechnicalGrade(char grade) {
        Select drpTechnicalGrade = new Select(driver.findElement(By.name("technicalGrade")));
        drpTechnicalGrade.selectByVisibleText(String.valueOf(grade));
        return this;
    }

    public NavPage setConsultantGrade(char grade) {
        Select drpConsultantGrade = new Select(driver.findElement(By.name("consultantGrade")));
        drpConsultantGrade.selectByVisibleText(String.valueOf(grade));
        return this;
    }

    public CompetenciesPage clickConsultantGrade() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.linkText("Consultant Grade"));
        return new CompetenciesPageImpl(driver, user);
    }


    public NavPage saveForm() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.id("saveBtn"));
        return this;
    }

    public NavPage submitForm() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.id("submitBtn"));
        switch (user) {
            case "trainee":
                return new TraineeHomePageImpl(driver, user);
            case "trainer":
                return new TrainerHomePageImpl(driver, user);
        }
        return null;
    }

    public String getName(String name) {
        String[] extractedName = driver.findElement(By.xpath("//*[@id=\"feedbackText\"]/div/h1")).getText().split("/");
        return extractedName[1].trim();
    }

    public String getWeek() {
        By textField = new By.ByXPath("//*[@id=\"feedbackText\"]/div/h1");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String[] extractedWeek = driver.findElement(textField).getText().split("/");
        return extractedWeek[1].trim();
    }
}
