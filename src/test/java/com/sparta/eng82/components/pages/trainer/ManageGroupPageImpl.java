package com.sparta.eng82.components.pages.trainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.sparta.eng82.components.NavPage;
import com.sparta.eng82.components.frameworkutil.ActionClicker;
import com.sparta.eng82.components.pages.trainer.addpages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManageGroupPageImpl extends NavPage implements ManageGroupPage {

    private final By removeButton = new By.ByLinkText("Remove");
    private final By deleteTrainerButton = new By.ByXPath("\"(//button[@type='submit'])[5]\"");
    private final By addTraineeButton = new By.ByLinkText("Add Trainee");
    private final By addGroupButton = new By.ByLinkText("Add Group");
    private final By addStreamButton = new By.ByLinkText("Add Stream");
    private final By listClassName = new By.ByClassName("list-group");
    private By removeButtonIdentifier;

    private final WebDriver driver;
    private final String user;

    public ManageGroupPageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
    }

    @Override
    public AddTraineePage addTrainee() {
        driver.findElement(addTraineeButton).click();
        return new AddTraineePageImpl(driver, user);

    }

    @Override
    public AddGroupPage addGroup() {
        driver.findElement(addGroupButton).click();
        return new AddGroupPageImpl(driver,user);

    }

    @Override
    public AddStreamPage addStream() {
        driver.findElement(addStreamButton).click();
        return new AddStreamPageImpl(driver,user);
    }

    // TODO
    @Override
    public boolean isTraineeRemoved(String traineeName) {
        removeTrainee(traineeName);
        boolean isPresent = isStudentPresent(traineeName);
        return !isPresent;
    }

    @Override
    public void clickRemoveButton(int studentIndex) {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector(".btn:nth-child(" + studentIndex + ")"));
    }


    @Override
    public ManageGroupPageImpl removeTrainee(String studentName) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> students = driver.findElements(By.className("list-group-item-action"));
        int studentPosition = 0;
        for (WebElement student:students) {
            String name = student.getText();
            if (name.equals(studentName)) {
                studentPosition = students.indexOf(student) + 1;
                break;
            }
        }
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector(".btn:nth-child(" + (studentPosition * 2) + ")"));
        ActionClicker.timedMouseClicker(driver,ActionClicker.TIME, By.xpath("(//button[@type='submit'])[5]"));

        return this;
    }

    @Override
    public boolean isStudentPresent(String studentName) {
        List<WebElement> students = driver.findElements(By.className("list-group-item-action"));
        boolean isPresent = false;
        for (WebElement student: students) {
            if (studentName.equals(student.getText())){
                isPresent = true;
            }
            break;
        }
        return isPresent;
    }

    @Override
    public ManageGroupPageImpl addStudent(String firstName, String lastName) {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector("form > .my-3:nth-child(2)"));
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        Select select = new Select(driver.findElement(By.id("traineeGroup")));
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        select.selectByVisibleText("Engineering 80");
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.findElement(By.id("traineeFirstName")).sendKeys(firstName);
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.findElement(By.id("traineeLastName")).sendKeys(lastName);
        ActionClicker.timedMouseClicker(driver,ActionClicker.TIME,By.cssSelector("#addNewTrainee .btn"));

        return new ManageGroupPageImpl(driver, "trainer");
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
