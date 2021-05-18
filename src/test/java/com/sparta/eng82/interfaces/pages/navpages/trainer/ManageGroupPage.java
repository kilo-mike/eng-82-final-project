package com.sparta.eng82.interfaces.pages.navpages.trainer;

import com.sparta.eng82.interfaces.pages.NavPage;

public interface ManageGroupPage extends NavPage {

    ManageGroupPage removeTrainee(String traineeName);

    AddTraineePage addTrainee();

    AddGroupPage addGroup();

    AddStreamPage addStream();

    boolean isTraineeRemoved(String traineeName);

}
