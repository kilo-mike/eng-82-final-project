package com.sparta.eng82.interfaces.pages.navpages.trainee;

import com.sparta.eng82.interfaces.pages.NavPage;

public interface TraineeFeedbackFormPage extends NavPage {

    boolean checkBoxesCanBeEditedBeforeSubmitting();
    boolean checkGradesCanBeSelectedBeforeSubmitting();

    boolean checkBoxesPersistAfterClickingSave();
    boolean checkGradesPersistsAfterClickingSave();

    boolean checkBoxesPersistAfterClickingSubmit();
    boolean checkGradesPersistsAfterClickingSubmit();

    boolean checkBoxesLockAfterClickingSubmit();
    boolean checkGradesLockAfterClickingSubmit();






}
