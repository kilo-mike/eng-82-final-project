package com.sparta.eng82.interfaces.pages.trainer;

import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.ProfilePage;
import org.openqa.selenium.WebDriver;

public interface TrainerHomePage extends Page {

    public ManageGroupPage manageGroupButton();

    public TrainerFeedbackFormPage selectTraineeName();

    public boolean menuDropdownDisplays();
}
