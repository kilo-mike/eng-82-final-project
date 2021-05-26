package com.sparta.eng82.components.pages.trainer.addpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sparta.eng82.components.pages.trainer.ManageGroupPage;
import com.sparta.eng82.components.pages.trainer.ManageGroupPageImpl;

public class AddStreamPageImpl implements AddStreamPage {

    private final By createNewStreamButton = new By.ByLinkText("Create New Stream");
    WebDriver driver;
    private final String user;

    public AddStreamPageImpl(WebDriver driver,String user) {

        this.driver = driver;
        this.user = user;
    }

    @Override
    public AddStreamPageImpl enterStreamName(String streamName) {
        driver.findElement(By.cssSelector(".col-md-3 > .form-control")).sendKeys(streamName);
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
        return new ManageGroupPageImpl(driver, user);
    }

    @Override
    public boolean isStreamCreated() {
        return false;
    }

    public boolean isStreamNameCorrect(String streamName) {
        return driver.findElement(By.name("streamName")).getText().equals(streamName);
    }
}
