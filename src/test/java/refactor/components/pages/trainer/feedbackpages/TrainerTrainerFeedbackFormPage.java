package refactor.components.pages.trainer.feedbackpages;

import refactor.components.NavPage;
import refactor.components.pages.trainer.TrainerFeedbackFormPage;

public interface TrainerTrainerFeedbackFormPage extends TrainerFeedbackFormPage {

    TrainerTrainerFeedbackFormPage clickOnStop();

    TrainerTrainerFeedbackFormPage enterStopComments(String comments);

    TrainerTrainerFeedbackFormPage clickOnStart();

    TrainerTrainerFeedbackFormPage enterStartComments(String comments);

    TrainerTrainerFeedbackFormPage clickOnCont();

    TrainerTrainerFeedbackFormPage enterContComments(String comments);

    TrainerTraineeFeedbackFormPage clickOnTrainee();
}
