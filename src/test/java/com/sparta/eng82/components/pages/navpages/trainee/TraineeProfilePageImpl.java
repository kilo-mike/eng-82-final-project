package com.sparta.eng82.components.pages.navpages.trainee;

import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeProfilePage;
import org.openqa.selenium.WebDriver;

public class TraineeProfilePageImpl implements TraineeProfilePage {

    WebDriver driver;

    public TraineeProfilePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean isTechnicalGradeValid() {
        // TODO
        return false;
    }

    @Override
    public boolean isConsultantGradeValid() {
        // TODO
        return false;
    }

    @Override
    public boolean areBothGradesValid() {
        // TODO
        return false;
    }

    @Override
    public boolean isAverageGradeCorrect() {
        // TODO
        return false;
    }

    @Override
    public boolean isSubmissionDateCorrect() {
        // TODO
        return false;
    }
}
