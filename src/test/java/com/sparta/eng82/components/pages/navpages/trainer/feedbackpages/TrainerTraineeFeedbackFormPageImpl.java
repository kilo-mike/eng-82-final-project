package com.sparta.eng82.components.pages.navpages.trainer.feedbackpages;

import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import com.sparta.eng82.interfaces.pages.navpages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.navpages.ProfilePage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerHomePage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.feedbackpages.TrainerTraineeFeedbackFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainerTraineeFeedbackFormPageImpl implements TrainerTraineeFeedbackFormPage {

    WebDriver driver;

    public TrainerTraineeFeedbackFormPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    private By technicalGradeField = new By.ById("techGrade");
    private By consultantGradeField = new By.ById("consultGrade");
    private By technicalGrades;
    private By consultantGrades;
    private By consultantGradeTitle = new By.ByLinkText("Consultant Grade");
    private By saveButton = new By.ById("saveBtn");
    private By submitButton = new By.ById("submitBtn");
    private By pageHeading = new By.ByClassName("mt-5 fw-bold text-center");
    private By trainerCommentsTextField = new By.ById("trainerComments");
    private By stopButton = new By.ByLinkText("Stop");
    private By startButton = new By.ByLinkText("Start");
    private By continueButton = new By.ByLinkText("Cont.");
    private By trainerButton = new By.ByLinkText("Trainer");

    @Override
    public TrainerFeedbackFormPage setTechnicalGrade(char grade) {
        technicalGrades = new By.ByLinkText(Character.toString(grade));

        driver.findElement(technicalGradeField).click();
        driver.findElement(technicalGrades).click();
        return this;
    }

    @Override
    public TrainerFeedbackFormPage setConsultantGrade(char grade) {
        consultantGrades = new By.ByLinkText(Character.toString(grade));

        driver.findElement(consultantGradeField).click();
        driver.findElement(consultantGrades).click();
        return this;
    }

    @Override
    public CompetenciesPage clickConsultantGradeTitle() {
        driver.findElement(consultantGradeTitle).click();
        return new CometenciesPageImpl(driver);
    }

    @Override
    public TrainerHomePage saveForm() {
        driver.findElement(saveButton).click();
        return new TrainerHomePageImpl(driver);
    }

    @Override
    public TrainerHomePage submitForm() {
        driver.findElement(submitButton).click();
        return new TrainerHomePageImpl(driver);
    }

    @Override
    public String getName() {
        String[] pageHeadingParts = driver.findElement(pageHeading).getText().split(" / ");
        return pageHeadingParts[0];
    }

    @Override
    public String getWeek() {
        String[] pageHeadingParts = driver.findElement(pageHeading).getText().split(" / ");
        return pageHeadingParts[1];
    }

    @Override
    public TrainerFeedbackFormPage enterTrainerComments(String comments) {
        driver.findElement(trainerCommentsTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPage clickOnStop() {
        driver.findElement(stopButton).click();
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPage clickOnStart() {
        driver.findElement(startButton).click();
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPage clickOnCont() {
        driver.findElement(continueButton).click();
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPage clickOnTrainer() {
        driver.findElement(trainerButton).click();
        return this;
    }

    @Override
    public boolean isTrainerCommentsEditable() {
        return false;
    }

    @Override
    public boolean isTraineeCommentsEditable() {
        return false;
    }

    @Override
    public boolean isTechnicalGradeValid() {
        return false;
    }

    @Override
    public boolean isConsultantGradeValid() {
        return false;
    }

    @Override
    public boolean isSaveButtonPresent() {
        return false;
    }

    @Override
    public boolean isSubmitButtonPresent() {
        return false;
    }
}
