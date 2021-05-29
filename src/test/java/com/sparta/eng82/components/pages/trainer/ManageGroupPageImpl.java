package com.sparta.eng82.components.pages.trainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.sparta.eng82.components.NavPage;
import com.sparta.eng82.components.frameworkutil.ActionClicker;
import com.sparta.eng82.components.pages.trainer.addpages.*;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManageGroupPageImpl extends NavPage implements ManageGroupPage {

    private final By removeButton = new By.ByLinkText("Remove");
    private final By deleteTrainerButton = new By.ByXPath("\"(//button[@type='submit'])[5]\"");
    private final By addTraineeButton = new By.ByXPath("//form/button");
    private final By addGroupButton = new By.ByCssSelector(".my-3:nth-child(3)");
    private final By addStreamButton = new By.ByCssSelector("form > .btn:nth-child(4)");
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
    public AddTraineePageImpl addTrainee() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, addTraineeButton);
        return new AddTraineePageImpl(driver, user);

    }

    @Override
    public AddGroupPageImpl addGroup() {
        //driver.findElement(addGroupButton).click();
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, addGroupButton);
        return new AddGroupPageImpl(driver,user);

    }

    @Override
    public AddStreamPageImpl addStream() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, addStreamButton);
        return new AddStreamPageImpl(driver,user);
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
        return this;
    }

    public ManageGroupPageImpl confirmTraineeDeletion() {
        ActionClicker.timedMouseClicker(driver,ActionClicker.TIME, By.xpath("(//button[@type='submit'])[5]"));

        return new ManageGroupPageImpl(driver, "trainer");
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
