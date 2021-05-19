package com.sparta.eng82.components.pages.navpages.trainee.feedbackpages;

import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.external.LoginPage;
import com.sparta.eng82.interfaces.pages.navpages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.navpages.ProfilePage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTraineeFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.feedbackpages.TraineeTrainerFeedbackFormPage;
import org.openqa.selenium.WebDriver;

public class TraineeTraineeFeedbackFormPageImpl implements TraineeTraineeFeedbackFormPage {

    WebDriver driver;
    public TraineeTraineeFeedbackFormPageImpl(WebDriver driver) {
        this.driver = driver;

    }

    @Override
    public Page goToHomePage() {
        return null;
    }

    @Override
    public ProfilePage goToProfilePage() {
        return null;
    }

    @Override
    public CompetenciesPage goToCompetenciesPage() {
        return null;
    }

    @Override
    public LoginPage logOut() {
        return null;
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
    public TraineeTraineeFeedbackFormPage clickOnStop() {
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage enterStopComments(String comments) {
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickOnStart() {
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage enterStartComments(String comments) {
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage clickOnCont() {
        return null;
    }

    @Override
    public TraineeTraineeFeedbackFormPage enterContComments(String comments) {
        return null;
    }

    @Override
    public TraineeTrainerFeedbackFormPage clickOnTrainer() {
        return null;
    }
}
