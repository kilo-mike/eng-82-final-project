package com.sparta.eng82.components.pages.trainee.feedback;

import com.sparta.eng82.components.pages.trainee.TraineeFeedbackFormPage;

public interface TraineeTrainerFeedbackFormPage extends TraineeFeedbackFormPage {

    TraineeTraineeFeedbackFormPage clickOnTrainee();

    TraineeTrainerFeedbackFormPage clickStopTab();

    String getStopCommentBox();

    boolean isStopCommentBoxEmpty();

    boolean isStopCommentBoxDisabled();

    TraineeTrainerFeedbackFormPage clickStartTab();

    String getStartCommentBox();

    boolean isStartCommentBoxEmpty();

    boolean isStartCommentBoxDisabled();

    TraineeTrainerFeedbackFormPage clickContinueTab();

    String getContinueCommentBox();

    boolean isContinueCommentBoxEmpty();

    boolean isContinueCommentBoxDisabled();

    String getTrainerCommentBox();

    boolean isTrainerCommentBoxEmpty();

    boolean isTrainerCommentBoxDisabled();
}
