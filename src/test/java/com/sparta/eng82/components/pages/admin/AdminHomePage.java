package com.sparta.eng82.components.pages.admin;


public interface AdminHomePage {

    AddTrainerPage addTrainer();

    boolean isTrainerAdded(String firstName, String lastName, String group);

    boolean getAllTrainersAvailable(int howManyTrainers);
}
