package refactor.components.pages.trainer.feedbackpages;

import refactor.components.pages.trainer.TrainerFeedbackFormPage;

public interface TrainerTrainerFeedbackFormPage extends TrainerFeedbackFormPage {

    TrainerTrainerFeedbackFormPageImpl clickOnTrainer();

    TrainerTrainerFeedbackFormPageImpl clickOnStop();

    TrainerTrainerFeedbackFormPageImpl enterTrainerStopComments(String comments);

    TrainerTrainerFeedbackFormPageImpl clickOnStart();

    TrainerTrainerFeedbackFormPageImpl enterTrainerStartComments(String comments);

    TrainerTrainerFeedbackFormPageImpl clickOnCont();

    TrainerTrainerFeedbackFormPageImpl enterTrainerContComments(String comments);

    TrainerTraineeFeedbackFormPageImpl clickOnTrainee();
}
