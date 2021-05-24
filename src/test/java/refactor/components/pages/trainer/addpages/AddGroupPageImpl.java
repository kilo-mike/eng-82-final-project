package refactor.components.pages.trainer.addpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.pages.trainer.ManageGroupPage;
import refactor.components.pages.trainer.ManageGroupPageImpl;

public class AddGroupPageImpl implements AddGroupPage {

    private final By streamNameField = new By.ById("streamName");
    private final By groupNameField = new By.ById("groupName");
    private final By groupStartDateField = new By.ById("groupStartDate");
    private final By createNewGroupButton = new By.ByLinkText("Create New Group");
    private final By groupField = new By.ById("traineeGroup");
    WebDriver driver;
    private final String user;

    //private By addTraineeButton = new By.ByLinkText("Add Trainee");

    public AddGroupPageImpl(WebDriver driver, String user) {

        this.driver = driver;
        this.user = user;
    }

    //Changed the return types from AddGroupPage to void in the interface
    @Override
    public AddGroupPageImpl selectStream(String streamName) {
        driver.findElement(streamNameField).click();
        driver.findElement(By.linkText(streamName)).click();
        return this;
    }

    //Previously returned AddGroupPage
    @Override
    public AddGroupPageImpl enterGroupName(String groupName) {
        driver.findElement(groupNameField).sendKeys(groupName);
        return this;
    }

    //Previously returned AddGroupPage
    @Override
    public AddGroupPageImpl enterGroupStartDate(String startDate) {
        driver.findElement(groupStartDateField).sendKeys(startDate);
        return this;
    }

    @Override
    public ManageGroupPage createNewGroup() {
        driver.findElement(createNewGroupButton).click();
        return new ManageGroupPageImpl(driver, user);
    }

    // Added String arg
    //TODO: this
    @Override
    public boolean isGroupCreated(String groupName) {

        return false;
    }

    @Override
    public boolean isDuplicateGroupNameAllowed() {
        return false;
    }

    @Override
    public boolean isPastStartingDateAllowed() {
        return false;
    }

    @Override
    public boolean isEmptyStreamNameAllowed() {
        return false;
    }

    @Override
    public boolean isEmptyGroupNameAllowed() {
        return false;
    }

    @Override
    public boolean isGroupNameCharacterLimited() {
        return false;
    }
}
