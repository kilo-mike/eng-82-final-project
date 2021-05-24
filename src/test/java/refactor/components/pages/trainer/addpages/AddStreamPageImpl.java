package refactor.components.pages.trainer.addpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.pages.trainer.ManageGroupPage;
import refactor.components.pages.trainer.ManageGroupPageImpl;

public class AddStreamPageImpl implements AddStreamPage {

    private final By createNewStreamButton = new By.ByLinkText("Create New Stream");
    WebDriver driver;
    private final String user;

    public AddStreamPageImpl(WebDriver driver,String user) {

        this.driver = driver;
        this.user = user;
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
        return new ManageGroupPageImpl(driver, user);
    }

    @Override
    public boolean isStreamCreated() {
        return false;
    }
}
