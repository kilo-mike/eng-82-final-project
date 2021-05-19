package com.sparta.eng82.components.pages.navpages.trainer.feedbackpages;

import com.sparta.eng82.components.pages.navpages.CompetenciesPageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.accesspages.LoginPage;
import com.sparta.eng82.interfaces.pages.navpages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.navpages.ProfilePage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerHomePage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.feedbackpages.TrainerTraineeFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.feedbackpages.TrainerTrainerFeedbackFormPage;
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
    public TrainerTrainerFeedbackFormPage clickOnTrainer() {
        driver.findElement(trainerButton).click();
        return new TrainerTrainerFeedbackFormPageImpl(driver);
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
