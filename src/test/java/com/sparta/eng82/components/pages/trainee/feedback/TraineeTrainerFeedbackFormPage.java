package com.sparta.eng82.components.pages.trainee.feedback;

import com.sparta.eng82.components.pages.trainee.TraineeFeedbackFormPage;

public interface TraineeTrainerFeedbackFormPage extends TraineeFeedbackFormPage {

    TraineeTraineeFeedbackFormPage clickOnTrainee();

    TraineeTrainerFeedbackFormPage clickStopTab();

    String getStopCommentBox();

    TraineeTrainerFeedbackFormPage setStopCommentBox(String comments);

    TraineeTrainerFeedbackFormPage editStopCommentBox(String comments);

    TraineeTrainerFeedbackFormPage deleteStopCommentBox();

    boolean isStopCommentBoxEmpty();

    boolean isStopCommentBoxDisabled();


    TraineeTrainerFeedbackFormPage clickStartTab();

    String getStartCommentBox();

    TraineeTrainerFeedbackFormPage setStartCommentBox(String comments);

    TraineeTrainerFeedbackFormPage editStartCommentBox(String comments);

    TraineeTrainerFeedbackFormPage deleteStartCommentBox();

    boolean isStartCommentBoxEmpty();

    boolean isStartCommentBoxDisabled();


    TraineeTrainerFeedbackFormPage clickContinueTab();

    String getContinueCommentBox();

    TraineeTrainerFeedbackFormPage setContinueCommentBox(String comments);

    TraineeTrainerFeedbackFormPage editContinueCommentBox(String comments);

    TraineeTrainerFeedbackFormPage deleteContinueCommentBox();

    boolean isContinueCommentBoxEmpty();

    boolean isContinueCommentBoxDisabled();


    String getTrainerCommentBox();

    TraineeTrainerFeedbackFormPage setTrainerCommentBox(String comments);

    TraineeTrainerFeedbackFormPage deleteTrainerCommentBox();

    boolean isTrainerCommentBoxEmpty();

    boolean isTrainerCommentBoxDisabled();
}
