package com.sparta.eng82.components.pages.navpages.trainer.addpages;

import com.sparta.eng82.components.pages.navpages.trainer.ManageGroupPageImpl;
import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddStreamPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddStreamPageImpl implements AddStreamPage {

    WebDriver driver;

    private By createNewStreamButton = new By.ByLinkText("Create New Stream");

    public AddStreamPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public AddStreamPage enterStreamName(String streamName) {
        driver.findElement(By.name("streamName")).sendKeys(streamName);
        return this;
    }

    @Override
    public AddStreamPage enterStreamDescription(String streamDescription) {
        driver.findElement(By.name("streamDescription")).sendKeys(streamDescription);
        return this;
    }

    @Override
    public AddStreamPage enterStreamDuration(int numberOfWeeks) {
        driver.findElement(By.linkText(numberOfWeeks + " weeks"));
        return this;
    }

    @Override
    public ManageGroupPage createNewStream() {
        driver.findElement(createNewStreamButton).click();
        return new ManageGroupPageImpl(driver);
    }

    @Override
    public boolean isStreamCreated() {
        return false;
    }
}