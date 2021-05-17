package com.sparta.eng82.interfaces.pages.trainee;

import com.sparta.eng82.interfaces.Page;

public interface TraineeHomePage extends Page {

    TraineeFeedbackFormPage clickCurrentWeek();
    TraineeFeedbackFormPage clickFeedbackFormForWee(int week);
    //TODO Set up traffic light enum?
    String getCurrentTrafficLight();
    String getTrafficLightForWeek(int week);






}
