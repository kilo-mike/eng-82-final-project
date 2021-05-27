package com.sparta.eng82.components.pages.trainee.feedback;

import com.sparta.eng82.components.frameworkutil.ActionClicker;
import com.sparta.eng82.components.pages.FeedbackFormPage;
import com.sparta.eng82.components.pages.trainee.TraineeHomePage;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;

public class TraineeTraineeFeedbackFormPageImpl extends FeedbackFormPage implements TraineeTraineeFeedbackFormPage {
    private final By traineeButton = new By.ByXPath("//label");
    private final By trainerButton = new By.ByXPath("//label[2]");

    private final By traineeStopButton = new By.ByXPath("//div[2]/div/label");
    private final By traineeStartButton = new By.ByXPath("//div[2]/div/label[2]");
    private final By traineeContinueButton = new By.ByXPath("//label[3]");

    private final By traineeStopCommentBox = new By.ById("stopTrainee");
    private final By traineeStartCommentBox = new By.ById("startTrainee");
    private final By traineeContinueCommentBox = new By.ById("continueTrainee");

    private final By traineeTechnicalGrade = new By.ById("techGrade");
    private final By traineeConsultantGrade = new By.ById("consultGrade");

    private final By trainersCommentBox = new By.ById("trainerComments");

    private final By submitButton = new By.ById("submitBtn");
    private final By saveButton = new By.ById("saveBtn");

    private WebDriver driver;
    private final String user;

    public TraineeTraineeFeedbackFormPageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
    }

    @Override
    public TraineeTrainerFeedbackFormPageImpl clickOnTrainer() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, trainerButton);
        return new TraineeTrainerFeedbackFormPageImpl(driver, user);
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickStopTab() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, traineeStopButton);
        return this;
    }

    @Override
    public String getStopCommentBox() {
        clickStopTab();
        return driver.findElement(traineeStopCommentBox).getText();
    }

    @Override
    public TraineeHomePage setStopCommentBox(String comments) {
        clickStopTab();
        driver.findElement(traineeStopCommentBox).clear();
        driver.findElement(traineeStopCommentBox).sendKeys(comments);
        this.saveForm();
        return new TraineeHomePageImpl(driver, user);
    }

    @Override
    public TraineeHomePage editStopCommentBox(String comments) {
        clickStopTab();
        driver.findElement(traineeStopCommentBox).sendKeys(comments);
        this.saveForm();
        return new TraineeHomePageImpl(driver, user);
    }

    @Override
    public TraineeHomePage deleteStopCommentBox() {
        clickStopTab();
        driver.findElement(traineeStopCommentBox).clear();
        this.saveForm();
        return new TraineeHomePageImpl(driver, user);
    }

    @Override
    public boolean isStopCommentBoxEmpty() {
        clickStopTab();
        return driver.findElement(traineeStopCommentBox).getText().isEmpty();
    }

    @Override
    public boolean isStopCommentBoxDisabled() {
        clickStopTab();
        return driver.findElement(traineeStopCommentBox).isEnabled();
    }

    @Override
    public boolean isStopCommentBoxEnabledBeforeSubmission() {
        if (driver.findElement(submitButton).isDisplayed()) {
            clickStopTab();
            return driver.findElement(traineeStopCommentBox).isEnabled();
        }
        return false;
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickStartTab() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, traineeStartButton);
        return this;
    }

    @Override
    public String getStartCommentBox() {
        clickStartTab();
        return driver.findElement(traineeStartCommentBox).getText();
    }

    @Override
    public TraineeHomePage setStartCommentBox(String comments) {
        clickStartTab();
        driver.findElement(traineeStartCommentBox).clear();
        driver.findElement(traineeStartCommentBox).sendKeys(comments);
        this.saveForm();
        return new TraineeHomePageImpl(driver, user);
    }

    @Override
    public TraineeHomePage editStartCommentBox(String comments) {
        clickStartTab();
        driver.findElement(traineeStartCommentBox).sendKeys(comments);
        this.saveForm();
        return new TraineeHomePageImpl(driver, user);
    }

    @Override
    public TraineeHomePage deleteStartCommentBox() {
        clickStartTab();
        driver.findElement(traineeStartCommentBox).clear();
        this.saveForm();
        return new TraineeHomePageImpl(driver, user);
    }

    @Override
    public boolean isStartCommentBoxEmpty() {
        clickStartTab();
        return driver.findElement(traineeStartCommentBox).getText().isEmpty();
    }

    @Override
    public boolean isStartCommentBoxDisabled() {
        clickStartTab();
        return driver.findElement(traineeStartCommentBox).isEnabled();
    }

    @Override
    public boolean isStartCommentBoxEnabledBeforeSubmission() {
        clickStartTab();
        if (driver.findElement(submitButton).isDisplayed()) {
            return driver.findElement(traineeStartCommentBox).isEnabled();
        }
        return false;
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickContinueTab() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, traineeContinueButton);
        return this;
    }

    @Override
    public String getContinueCommentBox() {
        clickContinueTab();
        return driver.findElement(traineeContinueCommentBox).getText();
    }

    @Override
    public TraineeHomePage setContinueCommentBox(String comments) {
        clickContinueTab();
        driver.findElement(traineeContinueCommentBox).clear();
        driver.findElement(traineeContinueCommentBox).sendKeys(comments);
        this.saveForm();
        return new TraineeHomePageImpl(driver, user);
    }

    @Override
    public TraineeHomePage editContinueCommentBox(String comments) {
        clickContinueTab();
        driver.findElement(traineeContinueCommentBox).sendKeys(comments);
        this.saveForm();
        return new TraineeHomePageImpl(driver, user);
    }

    @Override
    public TraineeHomePage deleteContinueCommentBox() {
        clickContinueTab();
        driver.findElement(traineeContinueCommentBox).clear();
        this.saveForm();
        return new TraineeHomePageImpl(driver, user);
    }

    @Override
    public boolean isContinueCommentBoxEmpty() {
        clickContinueTab();
        return driver.findElement(traineeContinueCommentBox).getText().isEmpty();
    }

    @Override
    public boolean isContinueCommentBoxDisabled() {
        clickContinueTab();
        return driver.findElement(traineeContinueCommentBox).isEnabled();
    }

    @Override
    public boolean isContinueCommentBoxEnabledBeforeSubmission() {
        if (driver.findElement(submitButton).isDisplayed()) {
            return driver.findElement(traineeContinueCommentBox).isEnabled();
        }
        return false;
    }

    @Override
    public String getTrainerCommentBox() {
        return driver.findElement(trainersCommentBox).getText();
    }

    public TraineeHomePage setTrainerCommentBox(String comments) {
        driver.findElement(trainersCommentBox).clear();
        driver.findElement(trainersCommentBox).sendKeys(comments);
        this.saveForm();
        return new TraineeHomePageImpl(driver, user);
    }

    public TraineeHomePage deleteTrainerCommentBox() {
        driver.findElement(trainersCommentBox).clear();
        this.saveForm();
        return new TraineeHomePageImpl(driver, user);
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
        if (!(driver.findElement(submitButton).isDisplayed())) {
            return isStopCommentBoxDisabled() && isStartCommentBoxDisabled() && isContinueCommentBoxDisabled();
        }
        return false;
    }

    @Override
    public boolean doGradesLockAfterClickingSubmit(char grade) {
        if (!(driver.findElement(submitButton).isDisplayed())) {
            return isTechnicalGradeDisabled() && isConsultantGradeDisabled();
        }
        return false;
    }

    @Override
    public String getTechnicalGrade() {
        return driver.findElement(traineeTechnicalGrade).getText();
    }

    @Override
    public String getConsultantGrade() {
        return driver.findElement(traineeConsultantGrade).getText();
    }

    @Override
    public boolean isTechnicalGradeDisabled() {
        return !driver.findElement(traineeTechnicalGrade).isEnabled();
    }

    @Override
    public boolean isConsultantGradeDisabled() {
        return !driver.findElement(traineeConsultantGrade).isEnabled();
    }

    @Override
    public String getUrl() {
        return null;
    }

    public TraineeTraineeFeedbackFormPageImpl clickOnStopAndSetComment(String comments) {
        clickStopTab();
        driver.findElement(traineeStopCommentBox).clear();
        driver.findElement(traineeStopCommentBox).sendKeys(comments);
        return this;
    }

    public TraineeTraineeFeedbackFormPageImpl clickOnStartAndSetComment(String comments) {
        clickStartTab();
        driver.findElement(traineeStartCommentBox).clear();
        driver.findElement(traineeStartCommentBox).sendKeys(comments);
        return this;
    }

    public TraineeTraineeFeedbackFormPageImpl clickOnContAndSetComments(String comments) {
        clickContinueTab();
        driver.findElement(traineeContinueCommentBox).clear();
        driver.findElement(traineeContinueCommentBox).sendKeys(comments);
        return this;
    }


    public boolean checkIfDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public boolean areTraineeCommentBoxesInteractive() {
        try {
            clickOnStartAndSetComment("test").clickOnContAndSetComments("test").clickOnStopAndSetComment("test");
        } catch (InvalidElementStateException e) {
            return false;
        }
        return true;
    }
}

