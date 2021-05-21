package com.sparta.eng82.interfaces.pages.navpages.trainer;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddStreamPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddTraineePage;

public interface ManageGroupPage extends NavPage {

    ManageGroupPage removeTrainee(String traineeName);

    AddTraineePage addTrainee();

    AddGroupPage addGroup();

    AddStreamPage addStream();

    boolean isTraineeRemoved(String traineeName);

    void clickRemoveButton(int studentIndex);

    void removeStudent(String studentName);

    boolean isStudentPresent(String studentName);
}
