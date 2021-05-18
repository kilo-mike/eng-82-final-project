package com.sparta.eng82.components.pages.navpages.admin;

import com.sparta.eng82.interfaces.pages.navpages.admin.AdminHomePage;
import org.openqa.selenium.WebDriver;

public class AdminHomePageImpl implements AdminHomePage {

    WebDriver driver;

    public AdminHomePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public AdminHomePage addTrainer() {
        return null;
    }

    @Override
    public boolean isTrainerAdded(String firstName, String lastName, String group) {
        return false;
    }

    @Override
    public String[] getAllTrainersAvailable() {
        return new String[0];
    }
}
