package com.sparta.eng82.components.pages.trainer;

import com.sparta.eng82.components.NavPage;
import com.sparta.eng82.components.frameworkutil.ActionClicker;
import com.sparta.eng82.components.frameworkutil.PropertiesLoader;
import com.sparta.eng82.components.pages.trainer.feedbackpages.TrainerTraineeFeedbackFormPageImpl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TrainerHomePageImpl extends NavPage implements TrainerHomePage {

    private final By manageGroupButton = new By.ByLinkText("Manage Group");
    private final By weekListName = new By.ByXPath("/html/body/section/div/div/div/select");
    private By traineeNameTable;
    private By traineeNameFinder;
    private By weekName;
    private String userFullName;

    WebDriver driver;
    String user;

    public TrainerHomePageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public ManageGroupPage manageGroupButton() {
        driver.findElement(manageGroupButton).click();
        return new ManageGroupPageImpl(driver, user);
    }

    @Override
    public TrainerTraineeFeedbackFormPageImpl selectTraineeName(int week, String traineeName) {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.tagName("select"));
        WebElement weekDropDown = driver.findElement(By.xpath("/html/body/section/div/div/div/select"));
        Select select = new Select(weekDropDown);
        select.selectByValue(Integer.toString(week));

        for (WebElement element : driver.findElements(By.tagName("td"))) {
            if (element.getText().equals(traineeName)) {
                try {
                    element.click();
                    break;
                } catch (ElementNotInteractableException e) {
                    break;
                }
            }
        }
        return new TrainerTraineeFeedbackFormPageImpl(driver, user);
    }

    @Override
    public boolean menuDropdownDisplays() {
        return false;
    }

    @Override
    public boolean isUserDisplayNameCorrect() {
        String userDisplayName = driver.findElement(By.cssSelector(".pb-3:nth-child(2)")).getText().substring(6);
        return (PropertiesLoader.getName("trainer").equals(userDisplayName));
    }

    @Override
    public boolean mainNavigationMenuAppears() {
        String navBarShowing = "navbar-collapse bg-color-main collapse show";
        driver.findElement(By.cssSelector(".bi-list")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String navBarStatus = driver.findElement(By.id("navbarNav")).getAttribute("class");

        return navBarStatus.equals(navBarShowing);
    }

    @Override
    public boolean isNavigationMenuVisibilityChangingAfterClick() {
        String navBarChanging = "navbar-collapse bg-color-main collapsing";
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.cssSelector(".bi-list"));
        String navBarStatus = driver.findElement(By.id("navbarNav")).getAttribute("class");

        return navBarStatus.equals(navBarChanging);
    }

    @Override
    public boolean isChosenWeekDisplayingAsCurrentlySelected(int week) {
        WebElement weekDropDown = driver.findElement(By.cssSelector(".form-select"));
        Select select = new Select(weekDropDown);
        select.selectByValue(Integer.toString(week));
        String isSelectedString = select.getOptions().get(week - 1).getAttribute("selected");

        return isSelectedString.equals("true");
    }

    @Override
    public ManageGroupPage clickManageGroupButton() {
        ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.linkText("Manage Group"));
        return new ManageGroupPageImpl(driver, user);
    }

    public boolean areTraineesVisible(){

        WebElement weekDropDown = driver.findElement(By.cssSelector(".form-select"));
        Select select = new Select(weekDropDown);
        String weekNumber = String.valueOf(select.getFirstSelectedOption().getText());
        String[] weekNumbers =  weekNumber.substring(5).split(" ");
        boolean found = true;

        try{
            driver.findElement(By.id("traineeTable" + weekNumbers[0]));
        }
        catch(NoSuchElementException e){
            found = false;
        }

        return found;
    }





}
