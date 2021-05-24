package refactor.components.pages.trainer;

import refactor.components.pages.trainer.feedbackpages.TrainerTraineeFeedbackFormPage;
import refactor.components.pages.trainer.feedbackpages.TrainerTraineeFeedbackFormPageImpl;

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
