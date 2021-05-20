package com.sparta.eng82.components.pages.navpages.trainer.feedbackpages;

import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.feedbackpages.TrainerTraineeFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.feedbackpages.TrainerTrainerFeedbackFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainerTrainerFeedbackFormPageImpl implements TrainerTrainerFeedbackFormPage {

    private final By trainerCommentsTextField = new By.ById("trainerComments");
    private final By stopButton = new By.ByLinkText("Stop");
    private final By startButton = new By.ByLinkText("Start");
    private final By continueButton = new By.ByLinkText("Cont.");
    private final By traineeButton = new By.ByLinkText("Trainee");
    private final By stopTrainerTextField = new By.ById("stopTrainer");
    private final By startTrainerTextField = new By.ById("startTrainer");
    private final By continueTrainerTextField = new By.ById("continueTrainer");

    WebDriver driver;

    public TrainerTrainerFeedbackFormPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public TrainerFeedbackFormPage enterTrainerComments(String comments) {
        driver.findElement(trainerCommentsTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage clickOnStop() {
        driver.findElement(stopButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage enterStopComments(String comments) {
        driver.findElement(stopTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage clickOnStart() {
        driver.findElement(startButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage enterStartComments(String comments) {
        driver.findElement(startTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage clickOnCont() {
        driver.findElement(continueButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage enterContComments(String comments) {
        driver.findElement(continueTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPage clickOnTrainee() {
        driver.findElement(traineeButton).click();
        return new TrainerTraineeFeedbackFormPageImpl(driver, this.getClass().getSimpleName());
    }
}
