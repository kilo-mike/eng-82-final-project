package com.sparta.eng82.interfaces.pages.navpages;

import com.sparta.eng82.interfaces.pages.NavPage;

public interface FeedbackFormPage extends NavPage {

    /**
     * @param grade can be either "A", "B", "C" or "D"
     */
    NavPage setTechnicalGrade(char grade);

    NavPage setConsultantGrade(char grade);

    CompetenciesPage clickConsultantGrade();

    NavPage saveForm();

    NavPage submitForm();

    String getName();

    String getWeek();
}
