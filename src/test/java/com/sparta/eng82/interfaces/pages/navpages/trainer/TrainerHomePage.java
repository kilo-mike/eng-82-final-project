package com.sparta.eng82.interfaces.pages.navpages.trainer;

import com.sparta.eng82.interfaces.pages.NavPage;

public interface TrainerHomePage extends NavPage {

    ManageGroupPage manageGroupButton();

    TrainerFeedbackFormPage selectTraineeName();

    boolean menuDropdownDisplays();
}
