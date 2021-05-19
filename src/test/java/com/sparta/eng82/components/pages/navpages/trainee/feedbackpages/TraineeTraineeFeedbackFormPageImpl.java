package com.sparta.eng82.components.pages.navpages.trainee.feedbackpages;

import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTraineeFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTrainerFeedbackFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TraineeTraineeFeedbackFormPageImpl implements TraineeTraineeFeedbackFormPage {

    private final By trainerButton = new By.ByLinkText("Trainer");
    private final By startButton = new By.ByLinkText("Start");
    private final By stopButton = new By.ByLinkText("Stop");
    private final By continueButton = new By.ByLinkText("Cont.");
    private final By continueTextBox = new By.ById("continueTrainee");
    private final By startTextBox = new By.ById("startTrainee");
    private final By stopTextBox = new By.ById("stopTrainee");
    //private final By stopTextBox = new By.ById("stopTrainee");

    WebDriver driver;

    public TraineeTraineeFeedbackFormPageImpl(WebDriver driver) {
        this.driver = driver;

    }


    @Override
    public boolean checkBoxesCanBeEditedBeforeSubmitting() {
        if(driver.findElement(By.id("submitBtn")).isDisplayed()) {
            clickOnStart();
            enterStartComments("Start Test");
            if(!driver.findElement(startTextBox).getText().equals("Start Test")){
                return false;
            }
            clickOnCont();
            enterContComments("Continue Test");
            if(!driver.findElement(continueTextBox).getText().equals("Continue Test")){
                return false;
            }
            clickOnStop();
            enterStopComments("Stop Test");
            if(!driver.findElement(stopTextBox).getText().equals("Stop Test")){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkGradesCanBeSelectedBeforeSubmitting() {
//        if(driver.findElement(By.id("submitBtn")).isDisplayed()) {
//            clickOnStart();
//            driver.findElement(By.id("techGrade")).click();
//            if(!driver.findElement(startTextBox).getText().equals("Start Test")){
//                return false;
//            }
//            clickOnCont();
//            enterContComments("Continue Test");
//            if(!driver.findElement(continueTextBox).getText().equals("Continue Test")){
//                return false;
//            }
//            clickOnStop();
//            enterStopComments("Stop Test");
//            if(!driver.findElement(stopTextBox).getText().equals("Stop Test")){
//                return false;
//            }
//        }
        return true;
    }

    @Override
    public boolean checkBoxesPersistAfterClickingSave() {
        return false;
    }

    @Override
    public boolean checkGradesPersistsAfterClickingSave() {
        return false;
    }

    @Override
    public boolean checkBoxesPersistAfterClickingSubmit() {
        return false;
    }

    @Override
    public boolean checkGradesPersistsAfterClickingSubmit() {
        return false;
    }

    @Override
    public boolean checkBoxesLockAfterClickingSubmit() {
        return false;
    }

    @Override
    public boolean checkGradesLockAfterClickingSubmit() {
        return false;
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickOnStop() {
        driver.findElement(stopButton).click();
        return new TraineeTraineeFeedbackFormPageImpl(driver);
    }

    @Override
    public TraineeTraineeFeedbackFormPage enterStopComments(String comments) {
        driver.findElement(stopTextBox).sendKeys(comments);
        return new TraineeTraineeFeedbackFormPageImpl(driver);
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickOnStart() {
        driver.findElement(startButton).click();
        return new TraineeTraineeFeedbackFormPageImpl(driver);
    }

    @Override
    public TraineeTraineeFeedbackFormPage enterStartComments(String comments) {
        driver.findElement(startTextBox).sendKeys(comments);
        return new TraineeTraineeFeedbackFormPageImpl(driver);
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickOnCont() {
        driver.findElement(continueButton).click();
        return new TraineeTraineeFeedbackFormPageImpl(driver);
    }

    @Override
    public TraineeTraineeFeedbackFormPage enterContComments(String comments) {
        driver.findElement(continueTextBox).sendKeys(comments);
        return new TraineeTraineeFeedbackFormPageImpl(driver);
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickOnTrainer() {
        driver.findElement(trainerButton).click();
        return new TraineeTrainerFeedbackFormPageImpl(driver);
    }
}
