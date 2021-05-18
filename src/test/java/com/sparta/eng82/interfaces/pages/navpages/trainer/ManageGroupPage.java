package com.sparta.eng82.interfaces.pages.navpages.trainer;

import com.sparta.eng82.interfaces.pages.NavPage;

public interface ManageGroupPage extends NavPage {

    ManageGroupPage removeTrainee(String traineeName);

    ManageGroupPage addTrainee();

    ManageGroupPage addGroup();

    ManageGroupPage addStream();

}
