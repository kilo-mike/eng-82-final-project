package com.sparta.eng82.interfaces.pages.navpages.trainer;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.CompetenciesPage;

public interface TrainerFeedbackFormPage extends NavPage {

    /**
     * @param grade can be either "A", "B", "C" or "D"
     */
    TrainerFeedbackFormPage setTechnicalGrade(char grade);

    TrainerFeedbackFormPage setConsultantGrade(char grade);

    TrainerFeedbackFormPage enterTrainerComments(String comments);

    CompetenciesPage clickConsultantGrade();

    TrainerHomePage saveForm();

    TrainerHomePage submitForm();
}
