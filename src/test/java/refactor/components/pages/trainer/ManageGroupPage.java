package refactor.components.pages.trainer;

import refactor.components.pages.trainer.addpages.AddGroupPage;
import refactor.components.pages.trainer.addpages.AddStreamPage;
import refactor.components.pages.trainer.addpages.AddTraineePage;

public interface ManageGroupPage {

    ManageGroupPage removeTrainee(String traineeName);

    AddTraineePage addTrainee();

    AddGroupPage addGroup();

    AddStreamPage addStream();

    boolean isTraineeRemoved(String traineeName);

    void clickRemoveButton(int studentIndex);

    void removeStudent(String studentName);

    void addStudent(String firstName, String lastName);

    boolean isStudentPresent(String studentName);
}
