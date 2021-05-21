package com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeFeedbackFormPage;

public interface TraineeTraineeFeedbackFormPage extends TraineeFeedbackFormPage, NavPage {

    TraineeTrainerFeedbackFormPage clickOnTrainer();

    TraineeTraineeFeedbackFormPage clickStopTab();
    String getStopCommentBox();
    TraineeTraineeFeedbackFormPage setStopCommentBox(String comments);
    TraineeTraineeFeedbackFormPage editStopCommentBox(String comments);
    TraineeTraineeFeedbackFormPage deleteStopCommentBox();
    boolean isStopCommentBoxEmpty();
    boolean isStopCommentBoxDisabled();
    boolean isStopCommentBoxEnabledBeforeSubmission();

    TraineeTraineeFeedbackFormPage clickStartTab();
    String getStartCommentBox();
    TraineeTraineeFeedbackFormPage setStartCommentBox(String comments);
    TraineeTraineeFeedbackFormPage editStartCommentBox(String comments);
    TraineeTraineeFeedbackFormPage deleteStartCommentBox();
    boolean isStartCommentBoxEmpty();
    boolean isStartCommentBoxDisabled();
    boolean isStartCommentBoxEnabledBeforeSubmission();

    TraineeTraineeFeedbackFormPage clickContinueTab();
    String getContinueCommentBox();
    TraineeTraineeFeedbackFormPage setContinueCommentBox(String comments);
    TraineeTraineeFeedbackFormPage editContinueCommentBox(String comments);
    TraineeTraineeFeedbackFormPage deleteContinueCommentBox();
    boolean isContinueCommentBoxEmpty();
    boolean isContinueCommentBoxDisabled();
    boolean isContinueCommentBoxEnabledBeforeSubmission();

    String getTrainerCommentBox();
    TraineeTraineeFeedbackFormPage setTrainerCommentBox(String comments);
    TraineeTraineeFeedbackFormPage deleteTrainerCommentBox();
    boolean isTrainerCommentBoxEmpty();
    boolean isTrainerCommentBoxDisabled();


}
