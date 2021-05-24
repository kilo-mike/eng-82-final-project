package refactor.components.pages.trainer.feedbackpages;

public interface TrainerTrainerFeedbackFormPage extends TrainerFeedbackFormPage, NavPage {

    TrainerTrainerFeedbackFormPage clickOnStop();

    TrainerTrainerFeedbackFormPage enterStopComments(String comments);

    TrainerTrainerFeedbackFormPage clickOnStart();

    TrainerTrainerFeedbackFormPage enterStartComments(String comments);

    TrainerTrainerFeedbackFormPage clickOnCont();

    TrainerTrainerFeedbackFormPage enterContComments(String comments);

    TrainerTraineeFeedbackFormPage clickOnTrainee();
}
