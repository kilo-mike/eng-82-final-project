package com.sparta.eng82.interfaces.pages.navpages.trainee;

import com.sparta.eng82.interfaces.pages.NavPage;

public interface TraineeHomePage extends NavPage {

    TraineeFeedbackFormPage clickCurrentWeek();

    TraineeFeedbackFormPage clickFeedbackFormForWeek(int week);

    //TODO Set up traffic light enum?
    String getCurrentTrafficLight();

    String getTrafficLightForWeek(int week);


}
