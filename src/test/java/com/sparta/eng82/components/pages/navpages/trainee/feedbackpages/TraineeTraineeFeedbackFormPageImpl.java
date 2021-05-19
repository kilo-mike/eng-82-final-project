package com.sparta.eng82.components.pages.navpages.trainee.feedbackpages;

import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTraineeFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTrainerFeedbackFormPage;
import org.openqa.selenium.WebDriver;

public class TraineeTraineeFeedbackFormPageImpl implements TraineeTraineeFeedbackFormPage {

    WebDriver driver;

    public TraineeTraineeFeedbackFormPageImpl(WebDriver driver) {
        this.driver = driver;

    }


    @Override
    public boolean checkBoxesCanBeEditedBeforeSubmitting() {
        return false;
    }

    @Override
    public boolean checkGradesCanBeSelectedBeforeSubmitting() {
        return false;
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
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage enterStopComments(String comments) {
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickOnStart() {
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage enterStartComments(String comments) {
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickOnCont() {
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage enterContComments(String comments) {
        return null;
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickOnTrainer() {
        return null;
    }
}
