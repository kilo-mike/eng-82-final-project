package refactor.components.pages.trainer.addpages;

import refactor.components.pages.trainer.ManageGroupPage;

public interface AddTraineePage {

    AddTraineePage assignGroup(String groupName);

    AddTraineePage enterFirstName(String firstName);

    AddTraineePage enterLastName(String lastName);

    ManageGroupPage createNewTrainee();

    boolean isTraineeCreated();
}
