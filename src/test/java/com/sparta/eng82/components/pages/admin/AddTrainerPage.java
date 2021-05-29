package com.sparta.eng82.components.pages.admin;


public interface AddTrainerPage {
    
    AddTrainerPage enterFirstName(String firstName);

    AddTrainerPage enterSecondName(String lastName);

    AddTrainerPage selectGroup(String groupName);

    AdminHomePage addNewTrainer();
}
