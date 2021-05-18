package com.sparta.eng82.interfaces.pages.navpages.admin;

import com.sparta.eng82.interfaces.pages.NavPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface AdminHomePage extends NavPage {

    AdminHomePage addTrainer();

    boolean isTrainerAdded(String firstName, String lastName, String group);
    
    String[] getAllTrainersAvailable();
}
