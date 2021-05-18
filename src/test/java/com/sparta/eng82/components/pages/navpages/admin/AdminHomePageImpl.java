package com.sparta.eng82.components.pages.navpages.admin;

import com.sparta.eng82.components.pages.navpages.admin.addpages.AddTrainerPageImpl;
import com.sparta.eng82.interfaces.pages.navpages.admin.AdminHomePage;
import com.sparta.eng82.interfaces.pages.navpages.admin.addpages.AddTrainerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminHomePageImpl implements AdminHomePage {

    WebDriver driver;

    private final By mainContent = new By.ById("main-content");
    private final By redButton = new By.ByClassName("btn bg-color-red");

    public AdminHomePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public AddTrainerPage addTrainer() {
        driver.findElement(mainContent).findElement(redButton).click();
        return new AddTrainerPageImpl(driver);
    }

    @Override
    public boolean isTrainerAdded(String firstName, String lastName, String group) {
        if (driver.findElement(mainContent).findElement(new By.ByLinkText(firstName)).isDisplayed()
                && driver.findElement(mainContent).findElement(new By.ByLinkText(lastName)).isDisplayed()
                && driver.findElement(mainContent).findElement(new By.ByLinkText(group)).isDisplayed())
        {
            return true;
        }
        return false;
    }

    @Override
    public String[] getAllTrainersAvailable() {
        return new String[0];
    }
}
