package com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeFeedbackFormPage;

public interface TraineeTraineeFeedbackFormPage extends TraineeFeedbackFormPage, NavPage {

    TraineeTraineeFeedbackFormPage clickOnStop();

    TraineeTraineeFeedbackFormPage enterStopComments(String comments);

    TraineeTraineeFeedbackFormPage clickOnStart();

    TraineeTraineeFeedbackFormPage enterStartComments(String comments);

    TraineeTraineeFeedbackFormPage clickOnCont();

    TraineeTraineeFeedbackFormPage enterContComments(String comments);

    TraineeTrainerFeedbackFormPage clickOnTrainer();
}
