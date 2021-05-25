package com.sparta.eng82.components.pages.trainee.feedback;

import com.sparta.eng82.components.frameworkutil.ActionClicker;
import com.sparta.eng82.components.pages.FeedbackFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TraineeTrainerFeedbackFormPageImpl extends FeedbackFormPage implements TraineeTrainerFeedbackFormPage {

    private WebDriver driver;
    private String user;

    private final By traineeButton = new By.ByXPath("//label");
    private final By trainerButton = new By.ByXPath("//label[2]");

    private final By trainerStopButton = By.xpath("//div[3]/div/label");
    private final By trainerStartButton = By.xpath("//div[3]/div/label[2]");
    private final By trainerContinueButton = By.xpath("//div[3]/div/label[3]");

    private final By trainerStopCommentBox = By.id("stopTrainer");
    private final By trainerStartCommentBox = By.id("startTrainer");
    private final By trainerContinueCommentBox = By.id("continueTrainer");

    private final By trainerTechnicalGrade= By.id("techGrade");
    private final By trainerConsultantGrade = By.id("consultGrade");

    private final By submitButton = new By.ById("submitBtn");

    private final By trainersCommentBox = By.id("trainerComments");

    public TraineeTrainerFeedbackFormPageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickOnTrainee() {
        driver.findElement(traineeButton).click();
        return new TraineeTraineeFeedbackFormPageImpl(driver, user);
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickStopTab() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, trainerStopButton);
        return this;
    }

    @Override
    public String getStopCommentBox() {
        clickStopTab();
        return driver.findElement(trainerStopCommentBox).getText();
    }

    @Override
    public boolean isStopCommentBoxEmpty() {
        clickStopTab();
        return driver.findElement(trainerStopCommentBox).getText().isEmpty();
    }

    @Override
    public boolean isStopCommentBoxDisabled() {
        clickStopTab();
        return driver.findElement(trainerStopCommentBox).isEnabled();
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickStartTab() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, trainerStartButton);
        return this;
    }

    @Override
    public String getStartCommentBox() {
        clickStartTab();
        return driver.findElement(trainerStartCommentBox).getText();
    }

    @Override
    public boolean isStartCommentBoxEmpty() {
        clickStartTab();
        return driver.findElement(trainerStartCommentBox).getText().isEmpty();
    }

    @Override
    public boolean isStartCommentBoxDisabled() {
        clickStartTab();
        return driver.findElement(trainerStartCommentBox).isEnabled();
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickContinueTab() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, trainerContinueButton);
        return this;
    }

    @Override
    public String getContinueCommentBox() {
        clickContinueTab();
        return driver.findElement(trainerContinueCommentBox).getText();
    }

    @Override
    public boolean isContinueCommentBoxEmpty() {
        return driver.findElement(trainerContinueCommentBox).getText().isEmpty();
    }

    @Override
    public boolean isContinueCommentBoxDisabled() {
        return driver.findElement(trainerContinueCommentBox).isEnabled();
    }

    @Override
    public String getTrainerCommentBox() {
        return driver.findElement(trainersCommentBox).getText();
    }

    @Override
    public boolean isTrainerCommentBoxEmpty() {
        return driver.findElement(trainersCommentBox).getText().isEmpty();
    }

    @Override
    public boolean isTrainerCommentBoxDisabled() {
        return driver.findElement(trainersCommentBox).isEnabled();
    }

    @Override
    public boolean doCommentBoxesLockAfterClickingSubmit() {
        if(!(driver.findElement(submitButton).isDisplayed())){
            return isStopCommentBoxDisabled() && isStartCommentBoxDisabled() && isContinueCommentBoxDisabled();
        }
        return false;
    }

    @Override
    public boolean doGradesLockAfterClickingSubmit(char grade) {
        if(!(driver.findElement(submitButton).isDisplayed())){
            return isTechnicalGradeDisabled() && isConsultantGradeDisabled();
        }
        return false;
    }

    @Override
    public String getTechnicalGrade() {
        return driver.findElement(trainerTechnicalGrade).getText();
    }

    @Override
    public String getConsultantGrade() {
        return driver.findElement(trainerConsultantGrade).getText();
    }

    @Override
    public boolean isTechnicalGradeDisabled() {
        return !driver.findElement(trainerTechnicalGrade).isEnabled();
    }

    @Override
    public boolean isConsultantGradeDisabled() {
        return !driver.findElement(trainerConsultantGrade).isEnabled();
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}

