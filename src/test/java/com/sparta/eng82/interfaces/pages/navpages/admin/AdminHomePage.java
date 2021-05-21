package com.sparta.eng82.interfaces.pages.navpages.admin;

import com.sparta.eng82.interfaces.pages.NavPage;
import com.sparta.eng82.interfaces.pages.navpages.admin.addpages.AddTrainerPage;

public interface AdminHomePage extends NavPage {

    AddTrainerPage addTrainer();

    boolean isTrainerAdded(String firstName, String lastName, String group);

    boolean getAllTrainersAvailable(int howManyTrainers);
}
