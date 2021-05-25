package com.sparta.eng82.components.pages.trainee.feedback;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.pages.FeedbackFormPage;

public class TraineeTrainerFeedbackFormPageImpl extends FeedbackFormPage implements TraineeTrainerFeedbackFormPage {

    private WebDriver driver;
    private String user;

    private final By traineeButton = new By.ByXPath("//label");
    private final By trainerButton = new By.ByXPath("//label[2]");

    private final By trainerStopButton = By.xpath("//div[3]/div/label");
    private final By trainerStartButton = By.id("//div[3]/div/label[2]");
    private final By trainerContinueButton = By.id("//div[3]/div/label[3]");

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
        driver.findElement(trainerStopButton);
        return this;
    }

    @Override
    public String getStopCommentBox() {
        clickStopTab();
        return driver.findElement(trainerStopCommentBox).getText();
    }

    @Override
    public TraineeTrainerFeedbackFormPage setStopCommentBox(String comments) {
        clickStopTab();
        deleteStopCommentBox();
        driver.findElement(trainerStopCommentBox).sendKeys(comments);
        return this;
    }

    @Override
    public TraineeTrainerFeedbackFormPage editStopCommentBox(String comments) {
        clickStopTab();
        driver.findElement(trainerStopCommentBox).sendKeys(comments);
        return this;
    }

    @Override
    public TraineeTrainerFeedbackFormPage deleteStopCommentBox() {
        clickStopTab();
        driver.findElement(trainerStopCommentBox).clear();
        return this;
    }

    @Override
    public boolean isStopCommentBoxEmpty() {
        clickStopTab();
        return driver.findElement(trainerStopCommentBox).getText().isEmpty();
    }

    @Override
    public boolean isStopCommentBoxDisabled() {
        clickStopTab();
        return !driver.findElement(trainerStopCommentBox).isEnabled();
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickStartTab() {
        driver.findElement(trainerStartButton).click();
        return this;
    }

    @Override
    public String getStartCommentBox() {
        clickStartTab();
        return driver.findElement(trainerStartCommentBox).getText();
    }

    @Override
    public TraineeTrainerFeedbackFormPage setStartCommentBox(String comments) {
        clickStartTab();
        deleteStartCommentBox();
        driver.findElement(trainerStartCommentBox).sendKeys(comments);
        return this;
    }

    @Override
    public TraineeTrainerFeedbackFormPage editStartCommentBox(String comments) {
        clickStartTab();
        driver.findElement(trainerStartCommentBox).sendKeys(comments);
        return this;
    }

    @Override
    public TraineeTrainerFeedbackFormPage deleteStartCommentBox() {
        clickStartTab();
        driver.findElement(trainerStartCommentBox).clear();
        return this;
    }

    @Override
    public boolean isStartCommentBoxEmpty() {
        clickStartTab();
        return driver.findElement(trainerStartCommentBox).getText().isEmpty();
    }

    @Override
    public boolean isStartCommentBoxDisabled() {
        clickStartTab();
        return !driver.findElement(trainerStartCommentBox).isEnabled();
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickContinueTab() {
        driver.findElement(trainerContinueButton).click();
        return this;
    }

    @Override
    public String getContinueCommentBox() {
        clickContinueTab();
        return driver.findElement(trainerContinueCommentBox).getText();
    }

    @Override
    public TraineeTrainerFeedbackFormPage setContinueCommentBox(String comments) {
        clickContinueTab();
        deleteContinueCommentBox();
        driver.findElement(trainerContinueCommentBox).sendKeys(comments);
        return this;
    }

    @Override
    public TraineeTrainerFeedbackFormPage editContinueCommentBox(String comments) {
        clickContinueTab();
        driver.findElement(trainerContinueCommentBox).sendKeys(comments);
        return this;
    }

    @Override
    public TraineeTrainerFeedbackFormPage deleteContinueCommentBox() {
        driver.findElement(trainerContinueCommentBox).clear();
        return this;
    }

    @Override
    public boolean isContinueCommentBoxEmpty() {
        return driver.findElement(trainerContinueCommentBox).getText().isEmpty();
    }

    @Override
    public boolean isContinueCommentBoxDisabled() {
        return !driver.findElement(trainerContinueCommentBox).isEnabled();
    }

    @Override
    public String getTrainerCommentBox() {
        return driver.findElement(trainersCommentBox).getText();
    }

    @Override
    public TraineeTrainerFeedbackFormPage setTrainerCommentBox(String comments) {
        deleteTrainerCommentBox();
        driver.findElement(trainersCommentBox).sendKeys(comments);
        return this;
    }

    @Override
    public TraineeTrainerFeedbackFormPage deleteTrainerCommentBox() {
        driver.findElement(trainersCommentBox).clear();
        return this;
    }

    @Override
    public boolean isTrainerCommentBoxEmpty() {
        return driver.findElement(trainersCommentBox).getText().isEmpty();
    }

    @Override
    public boolean isTrainerCommentBoxDisabled() {
        return !driver.findElement(trainersCommentBox).isEnabled();
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

