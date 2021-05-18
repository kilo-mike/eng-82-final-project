package com.sparta.eng82.interfaces.pages.navpages.trainer.feedbackpages;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerFeedbackFormPage;

public interface TrainerTrainerFeedbackFormPage extends TrainerFeedbackFormPage, NavPage {

    TrainerTrainerFeedbackFormPage clickOnStop();

    TrainerTrainerFeedbackFormPage enterStopComments(String comments);

    TrainerTraineeFeedbackFormPage clickOnStart();

    TrainerTrainerFeedbackFormPage enterStartComments(String comments);

    TrainerTraineeFeedbackFormPage clickOnCont();

    TrainerTrainerFeedbackFormPage enterContComments(String comments);

    TrainerTraineeFeedbackFormPage clickOnTrainee();
}
