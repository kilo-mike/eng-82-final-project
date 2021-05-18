package com.sparta.eng82.interfaces.pages.navpages.trainee;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.FeedbackFormPage;

public interface TraineeFeedbackFormPage extends FeedbackFormPage, NavPage {

    boolean checkBoxesCanBeEditedBeforeSubmitting();

    boolean checkGradesCanBeSelectedBeforeSubmitting();

    boolean checkBoxesPersistAfterClickingSave();

    boolean checkGradesPersistsAfterClickingSave();

    boolean checkBoxesPersistAfterClickingSubmit();

    boolean checkGradesPersistsAfterClickingSubmit();

    boolean checkBoxesLockAfterClickingSubmit();

    boolean checkGradesLockAfterClickingSubmit();

}
