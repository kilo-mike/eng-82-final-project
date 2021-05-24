package refactor.components.pages.trainer;

import refactor.components.pages.trainer.feedbackpages.TrainerTraineeFeedbackFormPage;

public interface TrainerHomePage {

    ManageGroupPage manageGroupButton();

    TrainerTraineeFeedbackFormPage selectTraineeName(int week, String traineeName);

    boolean menuDropdownDisplays();

    boolean isUserDisplayNameCorrect();

    boolean mainNavigationMenuAppears();

    boolean isNavigationMenuVisibilityChangingAfterClick();

    boolean isChosenWeekDisplayingAsCurrentlySelected(int week);

    ManageGroupPage clickManageGroupButton();

}
