package com.sparta.eng82.components.pages.navpages.trainee;

import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeFeedbackFormPage;
import com.sparta.eng82.interfaces.pages.navpages.trainee.TraineeHomePage;
import org.openqa.selenium.WebDriver;

public class TraineeHomePageImpl implements TraineeHomePage {

    WebDriver driver;

    public TraineeHomePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public TraineeFeedbackFormPage clickCurrentWeek() {
        return null;
    }

    @Override
    public TraineeFeedbackFormPage clickFeedbackFormForWeek(int week) {
        return null;
    }

    @Override
    public int getCurrentWeek() {
        return 0;
    }

    @Override
    public boolean areAllPreviousWeeksShown() {
        return false;
    }

    @Override
    public boolean areAllWeeksPriorToCurrentWeek() {
        return false;
    }

    @Override
    public String getCurrentTrafficLight() {
        return null;
    }

    @Override
    public String getTrafficLightForWeek(int week) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getStream() {
        return null;
    }

    @Override
    public String getGroup() {
        return null;
    }

    @Override
    public String getTrainer() {
        return null;
    }
}
