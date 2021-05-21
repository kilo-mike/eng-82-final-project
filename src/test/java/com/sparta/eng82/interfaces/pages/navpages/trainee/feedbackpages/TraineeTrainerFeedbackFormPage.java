package com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeFeedbackFormPage;

public interface TraineeTrainerFeedbackFormPage extends TraineeFeedbackFormPage, NavPage {

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
