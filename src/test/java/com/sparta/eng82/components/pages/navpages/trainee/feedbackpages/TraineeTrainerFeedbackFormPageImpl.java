package com.sparta.eng82.components.pages.navpages.trainee.feedbackpages;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTraineeFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTrainerFeedbackFormPage;
import org.openqa.selenium.WebDriver;

public class TraineeTrainerFeedbackFormPageImpl implements TraineeTrainerFeedbackFormPage {
    WebDriver driver;

    public TraineeTrainerFeedbackFormPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public NavPage setTechnicalGrade(char grade) {
        return null;
    }

    @Override
    public NavPage setConsultantGrade(char grade) {
        return null;
    }

    @Override
    public CompetenciesPage clickConsultantGrade() {
        return null;
    }

    @Override
    public NavPage saveForm() {
        return null;
    }

    @Override
    public NavPage submitForm() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getWeek() {
        return null;
    }

    @Override
    public boolean checkBoxesCanBeEditedBeforeSubmitting() {
        return false;
    }

    @Override
    public boolean checkGradesCanBeSelectedBeforeSubmitting() {
        return false;
    }

    @Override
    public boolean checkBoxesPersistAfterClickingSave() {
        return false;
    }

    @Override
    public boolean checkGradesPersistsAfterClickingSave() {
        return false;
    }

    @Override
    public boolean checkBoxesPersistAfterClickingSubmit() {
        return false;
    }

    @Override
    public boolean checkGradesPersistsAfterClickingSubmit() {
        return false;
    }

    @Override
    public boolean checkBoxesLockAfterClickingSubmit() {
        return false;
    }

    @Override
    public boolean checkGradesLockAfterClickingSubmit() {
        return false;
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickOnStop() {
        return null;
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickOnStart() {
        return null;
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickOnCont() {
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickOnTrainee() {
        return null;
    }
}
