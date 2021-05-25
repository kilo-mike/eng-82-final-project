package com.sparta.eng82.components.pages.admin;

import com.sparta.eng82.components.Page;

public interface EditTrainerPage extends Page {
    EditTrainerPageImpl editFirstName(String firstName);

    EditTrainerPageImpl editLastName(String lastName);

    EditTrainerPageImpl editGroup(String groupName);

    EditTrainerPageImpl tickRemove();

    AdminHomePageImpl saveChanges();

    AdminHomePageImpl removeTrainer();

}
