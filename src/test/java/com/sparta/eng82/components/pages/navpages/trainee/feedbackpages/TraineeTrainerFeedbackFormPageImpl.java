package com.sparta.eng82.components.pages.navpages.trainee.feedbackpages;

import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTraineeFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTrainerFeedbackFormPage;

public class TraineeTrainerFeedbackFormPageImpl implements TraineeTrainerFeedbackFormPage {


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
    public TraineeTrainerFeedbackFormPage clickOnStop() {
        return null;
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickOnStart() {
        return null;
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickOnCont() {
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickOnTrainee() {
        return null;
    }
}
