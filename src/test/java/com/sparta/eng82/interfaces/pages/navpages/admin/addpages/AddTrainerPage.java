package com.sparta.eng82.interfaces.pages.navpages.admin.addpages;

import com.sparta.eng82.interfaces.pages.navpages.admin.AdminHomePage;

public interface AddTrainerPage {

    AddTrainerPage enterFirstName(String firstName);

    AddTrainerPage enterSecondName(String lastName);

    AddTrainerPage selectGroup(String groupName);

    AdminHomePage addNewTrainer();
}
