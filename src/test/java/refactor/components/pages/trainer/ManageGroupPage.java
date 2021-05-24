package refactor.components.pages.trainer;

import refactor.components.pages.trainer.addpages.AddGroupPage;
import refactor.components.pages.trainer.addpages.AddStreamPage;
import refactor.components.pages.trainer.addpages.AddTraineePage;

public interface ManageGroupPage {

    AddTraineePage addTrainee();

    AddGroupPage addGroup();

    AddStreamPage addStream();

    boolean isTraineeRemoved(String traineeName);

    void clickRemoveButton(int studentIndex);

    ManageGroupPageImpl removeTrainee(String studentName);

    ManageGroupPageImpl addStudent(String firstName, String lastName);

    boolean isStudentPresent(String studentName);
}
