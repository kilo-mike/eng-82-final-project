package com.sparta.eng82.components.pages.trainee.feedback;

import com.sparta.eng82.components.pages.trainee.TraineeFeedbackFormPage;
import com.sparta.eng82.components.pages.trainee.TraineeHomePage;

public interface TraineeTraineeFeedbackFormPage extends TraineeFeedbackFormPage {

    TraineeTrainerFeedbackFormPage clickOnTrainer();

    TraineeTraineeFeedbackFormPage clickStopTab();

    String getStopCommentBox();

    TraineeHomePage setStopCommentBox(String comments);

    TraineeHomePage editStopCommentBox(String comments);

    TraineeHomePage deleteStopCommentBox();

    boolean isStopCommentBoxEmpty();

    boolean isStopCommentBoxDisabled();

    boolean isStopCommentBoxEnabledBeforeSubmission();

    TraineeTraineeFeedbackFormPage clickStartTab();

    String getStartCommentBox();

    TraineeHomePage setStartCommentBox(String comments);

    TraineeHomePage editStartCommentBox(String comments);

    TraineeHomePage deleteStartCommentBox();

    boolean isStartCommentBoxEmpty();

    boolean isStartCommentBoxDisabled();

    boolean isStartCommentBoxEnabledBeforeSubmission();

    TraineeTraineeFeedbackFormPage clickContinueTab();

    String getContinueCommentBox();

    TraineeHomePage setContinueCommentBox(String comments);

    TraineeHomePage editContinueCommentBox(String comments);

    TraineeHomePage deleteContinueCommentBox();

    boolean isContinueCommentBoxEmpty();

    boolean isContinueCommentBoxDisabled();

    boolean isContinueCommentBoxEnabledBeforeSubmission();

    String getTrainerCommentBox();

    TraineeHomePage setTrainerCommentBox(String comments);

    TraineeHomePage deleteTrainerCommentBox();

    boolean isTrainerCommentBoxEmpty();

    boolean isTrainerCommentBoxDisabled();


}
