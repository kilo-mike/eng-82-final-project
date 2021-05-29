package com.sparta.eng82.components.pages.trainer;

import com.sparta.eng82.components.pages.trainer.feedbackpages.TrainerTraineeFeedbackFormPageImpl;

public interface TrainerHomePage {

    ManageGroupPage manageGroupButton();

    TrainerTraineeFeedbackFormPageImpl selectTraineeName(int week, String traineeName);

    boolean menuDropdownDisplays();

    boolean isUserDisplayNameCorrect();

    boolean mainNavigationMenuAppears();

    boolean isNavigationMenuVisibilityChangingAfterClick();

    boolean isChosenWeekDisplayingAsCurrentlySelected(int week);

    ManageGroupPage clickManageGroupButton();

}
