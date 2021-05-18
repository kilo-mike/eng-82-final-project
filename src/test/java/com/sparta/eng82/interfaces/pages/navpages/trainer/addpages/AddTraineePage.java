package com.sparta.eng82.interfaces.pages.navpages.trainer.addpages;

import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;

public interface AddTraineePage {

    AddTraineePage assignGroup(String groupName);

    AddTraineePage enterFirstName(String firstName);

    AddTraineePage enterSecondName(String secondName);

    ManageGroupPage createNewTrainee();
}