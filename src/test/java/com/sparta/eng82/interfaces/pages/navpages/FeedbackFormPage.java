package com.sparta.eng82.interfaces.pages.navpages;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.TrainerHomePage;

public interface FeedbackFormPage extends NavPage {

    /**
     * @param grade can be either "A", "B", "C" or "D"
     */
    TrainerFeedbackFormPage setTechnicalGrade(char grade);

    TrainerFeedbackFormPage setConsultantGrade(char grade);

    CompetenciesPage clickConsultantGrade();

    TrainerHomePage saveForm();

    TrainerHomePage submitForm();
}
