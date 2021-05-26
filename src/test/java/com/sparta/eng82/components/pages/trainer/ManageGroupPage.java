package com.sparta.eng82.components.pages.trainer;

import com.sparta.eng82.components.pages.trainer.addpages.*;

public interface ManageGroupPage {

    AddTraineePageImpl addTrainee();

    AddGroupPageImpl addGroup();

    AddStreamPageImpl addStream();

    boolean isTraineeRemoved(String traineeName);

    void clickRemoveButton(int studentIndex);

    ManageGroupPageImpl removeTrainee(String studentName);

    ManageGroupPageImpl addStudent(String firstName, String lastName);

    boolean isStudentPresent(String studentName);
}
