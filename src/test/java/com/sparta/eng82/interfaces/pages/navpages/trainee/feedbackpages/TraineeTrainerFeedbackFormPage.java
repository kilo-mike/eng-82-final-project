package com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeFeedbackFormPage;

public interface TraineeTrainerFeedbackFormPage extends TraineeFeedbackFormPage, NavPage {

    TraineeTrainerFeedbackFormPage clickOnStop();

    TraineeTrainerFeedbackFormPage clickOnStart();

    TraineeTrainerFeedbackFormPage clickOnCont();

    TraineeTraineeFeedbackFormPage clickOnTrainee();
}
