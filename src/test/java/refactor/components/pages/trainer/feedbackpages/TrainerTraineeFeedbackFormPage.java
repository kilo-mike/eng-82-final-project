package refactor.components.pages.trainer.feedbackpages;


public interface TrainerTraineeFeedbackFormPage extends TrainerFeedbackFormPage, NavPage {

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
