package refactor.components.pages.trainer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import refactor.components.NavPage;
import refactor.components.frameworkutil.ActionClicker;
import refactor.components.frameworkutil.PropertiesLoader;
import refactor.components.pages.trainer.feedbackpages.TrainerTraineeFeedbackFormPageImpl;

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
        weekName = new By.ByXPath("//option[@value='" + week + "']");
        traineeNameFinder = new By.ByXPath("//td[\"" + traineeName + "\"]");

        driver.findElement(weekListName).findElement(weekName).click();
        try {
            ActionClicker.timedMouseClicker(driver, ActionClicker.TIME, By.xpath(".//*[@id='traineeTable2']/tbody/tr/td[contains(.,'" + traineeName + "')]"));
        } catch (NoSuchElementException e) {
            // Make sure to check for/expect this output if a trainee is not present.
            System.out.println("The trainee " + traineeName + " does not exist.");
            return new TrainerTraineeFeedbackFormPageImpl(driver, null);
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


}
