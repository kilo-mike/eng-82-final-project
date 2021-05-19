package com.sparta.eng82.components.pages.navpages.admin.addpages;

import com.sparta.eng82.interfaces.pages.navpages.admin.AdminHomePage;
import com.sparta.eng82.interfaces.pages.navpages.admin.addpages.AddTrainerPage;
import org.openqa.selenium.WebDriver;

public class AddTrainerPageImpl implements AddTrainerPage {

    WebDriver driver;

    public AddTrainerPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public AddTrainerPage enterFirstName(String firstName) {
        return null;
    }

    @Override
    public AddTrainerPage enterSecondName(String lastName) {
        return null;
    }

    @Override
    public AddTrainerPage selectGroup(String groupName) {
        return null;
    }

    @Override
    public AdminHomePage addNewTrainer() {
        return null;
    }
}
