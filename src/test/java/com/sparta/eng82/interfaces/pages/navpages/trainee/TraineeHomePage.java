package com.sparta.eng82.interfaces.pages.navpages.trainee;

import com.sparta.eng82.interfaces.pages.NavPage;

public interface TraineeHomePage extends NavPage {

    TraineeFeedbackFormPage clickCurrentWeek();

    TraineeFeedbackFormPage clickFeedbackFormForWeek(int week);

    String getCurrentTrafficLight();

    String getTrafficLightForWeek(int week);

    int getCurrentWeek();

    boolean areAllPreviousWeeksShown();

    boolean areAllWeeksPriorToCurrentWeek();

    String getName();

    String getStream();

    String getGroup();

    String getTrainer();
}
