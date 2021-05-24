package refactor.components.pages.trainer.addpages;

public interface AddTraineePage {

    AddTraineePage assignGroup(String groupName);

    AddTraineePage enterFirstName(String firstName);

    AddTraineePage enterLastName(String lastName);

    ManageGroupPage createNewTrainee();

    boolean isTraineeCreated();
}
