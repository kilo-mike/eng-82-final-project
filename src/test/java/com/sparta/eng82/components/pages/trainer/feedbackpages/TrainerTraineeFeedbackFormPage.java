package com.sparta.eng82.components.pages.trainer.feedbackpages;


import com.sparta.eng82.components.pages.trainer.TrainerFeedbackFormPage;

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
