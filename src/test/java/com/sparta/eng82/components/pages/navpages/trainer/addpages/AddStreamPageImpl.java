package com.sparta.eng82.components.pages.navpages.trainer.addpages;

import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddStreamPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddStreamPageImpl implements AddStreamPage {

    WebDriver driver;

    public AddStreamPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public AddStreamPage enterStreamName() {
        driver.findElement(By.name("streamName")).c
        return null;
    }

    @Override
    public AddStreamPage enterStreamDescription() {
        return null;
    }

    @Override
    public AddStreamPage enterStreamDuration(int weeks) {
        return null;
    }

    @Override
    public ManageGroupPage createNewStream() {
        return null;
    }

    @Override
    public boolean isStreamCreated() {
        return false;
    }
}
