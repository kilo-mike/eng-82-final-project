package com.sparta.eng82.components.pages.admin;

import com.sparta.eng82.components.frameworkutil.ActionClicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class EditTrainerPageImpl implements EditTrainerPage {

    private final WebDriver driver;
    private final String user;
    private int rowCount;

    public EditTrainerPageImpl(WebDriver driver, String user, int rowCount) {
        this.driver = driver;
        this.user = user;
        this.rowCount = rowCount;
    }

    @Override
    public EditTrainerPageImpl editFirstName(String firstName) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ByXPath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[1]/div/input")).clear();
        driver.findElement(new By.ByXPath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[1]/div/input")).sendKeys(firstName);

        return this;
    }

    @Override
    public EditTrainerPageImpl editLastName(String lastName) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(new By.ByXPath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[2]/div/input")).clear();
        driver.findElement(new By.ByXPath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[2]/div/input")).sendKeys(lastName);
        return this;
    }

    @Override
    public EditTrainerPageImpl editGroup(String groupName) {
//        new Select(driver.findElement(By.id("editTrainerGroup"))).selectByVisibleText(groupName);
//        return this;
        // This will only work for jakub matyjewicz
        WebElement groupOptions = driver.findElement(By.xpath("(//select[@id='editTrainerGroup'])["+rowCount+"]"));
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Select select = new Select(groupOptions);
        select.selectByVisibleText("hola");
        return this;

    }

    @Override
    public EditTrainerPageImpl tickForRemove() {
        driver.findElement(By.xpath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[2]/div/input[2]")).click();
//        ActionClicker.timedMouseClicker(driver,ActionClicker.TIME,By.xpath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[2]/div/input[2]"));
        return this;
    }

    @Override
    public AdminHomePageImpl saveChanges() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.xpath("//*[@id=\"adminEditTrainerModal111\"]/div/div/div[3]/input[1]"));
        return new AdminHomePageImpl(driver, user);
    }

    @Override
    public AdminHomePageImpl removeTrainer() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.xpath("//*[@id=\"adminEditTrainerModal111\"]/div/div/div[3]/input[2]"));
        return new AdminHomePageImpl(driver, user);
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public AdminHomePageImpl resetTrainerInfo(String firstName, String lastName) {
        editFirstName(firstName);
        editLastName(lastName);
        editGroup("No Group");
        saveChanges();
        return new AdminHomePageImpl(driver, user);
    }



    public boolean checkFirstNameInputValueCorrect(String input) {
        return driver.findElement(By.xpath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[1]/div/input")).getAttribute("value").equals(input);
    }

    public boolean checkLastNameInputValueCorrect(String input) {
        return driver.findElement(By.xpath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[2]/div/input")).getAttribute("value").equals(input);
    }

    public boolean checkGroupNameSelectValueCorrect(String input) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[1]/div[3]/div/select/option[1]"));
        return webElement.getAttribute("selected").equals("true") && webElement.getAttribute("label").equals(input);
    }

    public boolean checkIfTickBoxIsTicked() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div/div[6]/div/div/div[2]/form[2]/div/input[2]")).isSelected();
    }

    public boolean checkIfAllInputsHaveBeenEntered(String firstName, String lastName, String groupName) {
        editFirstName(firstName).editLastName(lastName).editGroup(groupName);
        return checkFirstNameInputValueCorrect(firstName)
                && checkLastNameInputValueCorrect(lastName)
               && checkGroupNameSelectValueCorrect(groupName);
    }

}
