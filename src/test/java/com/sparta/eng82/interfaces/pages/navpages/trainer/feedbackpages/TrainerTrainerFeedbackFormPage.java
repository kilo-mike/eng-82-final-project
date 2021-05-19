package com.sparta.eng82.interfaces.pages.navpages.trainer.feedbackpages;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerFeedbackFormPage;

public interface TrainerTrainerFeedbackFormPage extends TrainerFeedbackFormPage, NavPage {

    TrainerTrainerFeedbackFormPage clickOnStop();

    TrainerTrainerFeedbackFormPage enterStopComments(String comments);

    TrainerTrainerFeedbackFormPage clickOnStart();

    TrainerTrainerFeedbackFormPage enterStartComments(String comments);

    TrainerTrainerFeedbackFormPage clickOnCont();

    TrainerTrainerFeedbackFormPage enterContComments(String comments);

    TrainerTrainerFeedbackFormPage clickOnTrainee();
}
