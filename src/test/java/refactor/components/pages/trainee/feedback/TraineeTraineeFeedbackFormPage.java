package refactor.components.pages.trainee.feedback;

import refactor.components.pages.trainee.TraineeFeedbackFormPage;
import refactor.components.pages.trainee.TraineeHomePage;
import refactor.components.pages.trainee.feedback.TraineeTrainerFeedbackFormPage;

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
