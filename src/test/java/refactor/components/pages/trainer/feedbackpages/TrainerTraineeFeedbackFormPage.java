package refactor.components.pages.trainer.feedbackpages;


import refactor.components.NavPage;
import refactor.components.pages.trainer.TrainerFeedbackFormPage;

public interface TrainerTraineeFeedbackFormPage extends TrainerFeedbackFormPage {

    TrainerTraineeFeedbackFormPage clickOnStop();

    TrainerTraineeFeedbackFormPage clickOnStart();

    TrainerTraineeFeedbackFormPage clickOnCont();

    TrainerTrainerFeedbackFormPage clickOnTrainer();

    boolean isTrainerCommentsEditable();

    boolean isTraineeCommentsEditable();

    boolean isTechnicalGradeValid();

    boolean isConsultantGradeValid();

    boolean isSaveButtonPresent();

    boolean isSubmitButtonPresent();

    String getSimpleName();


}
