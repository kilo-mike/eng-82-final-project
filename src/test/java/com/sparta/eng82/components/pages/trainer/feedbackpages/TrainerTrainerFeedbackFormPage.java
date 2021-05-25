package com.sparta.eng82.components.pages.trainer.feedbackpages;

import com.sparta.eng82.components.pages.trainer.TrainerFeedbackFormPage;
import com.sparta.eng82.components.pages.trainer.TrainerHomePageImpl;

public interface TrainerTrainerFeedbackFormPage extends TrainerFeedbackFormPage {

    TrainerTrainerFeedbackFormPageImpl clickOnTrainer();

    TrainerTrainerFeedbackFormPageImpl clickOnStop();

    TrainerTrainerFeedbackFormPageImpl enterTrainerStopComments(String comments);

    TrainerTrainerFeedbackFormPageImpl clickOnStart();

    TrainerTrainerFeedbackFormPageImpl enterTrainerStartComments(String comments);

    TrainerTrainerFeedbackFormPageImpl clickOnCont();

    TrainerTrainerFeedbackFormPageImpl enterTrainerContComments(String comments);

    TrainerTraineeFeedbackFormPageImpl clickOnTrainee();

    TrainerHomePageImpl clickSave();

    TrainerHomePageImpl clickSubmit();
}
