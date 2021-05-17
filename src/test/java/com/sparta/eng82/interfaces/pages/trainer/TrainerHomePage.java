package com.sparta.eng82.interfaces.pages.trainer;

import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.ProfilePage;
import org.openqa.selenium.WebDriver;

public interface TrainerHomePage extends Page {

    public ManageGroupPageImpl manageGroupButton();

    public TrainerFeedbackFormPageImpl selectTraineeName();

    public boolean menuDropdownDisplays();
}
