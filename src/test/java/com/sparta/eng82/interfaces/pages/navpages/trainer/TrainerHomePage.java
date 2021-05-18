package com.sparta.eng82.interfaces.pages.navpages.trainer;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.feedbackpages.TrainerTraineeFeedbackFormPage;

public interface TrainerHomePage extends NavPage {

    ManageGroupPage manageGroupButton();

    TrainerTraineeFeedbackFormPage selectTraineeName(int week, String traineeName);

    boolean menuDropdownDisplays();
}
