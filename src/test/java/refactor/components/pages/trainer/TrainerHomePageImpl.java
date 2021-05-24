package refactor.components.pages.trainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import refactor.components.NavPage;
import refactor.components.frameworkutil.ActionClicker;
import refactor.components.pages.trainer.feedbackpages.TrainerTraineeFeedbackFormPage;
import refactor.components.pages.trainer.feedbackpages.TrainerTraineeFeedbackFormPageImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TrainerHomePageImpl extends NavPage implements TrainerHomePage {

    private final By manageGroupButton = new By.ByLinkText("Manage Group");
    private final By weekListName = new By.ByXPath("//select[@class=\"form-select mt-3 mb-3\"]");
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


    {
        try {
            InputStream input = new FileInputStream("src/test/resources/login.properties");
            Properties properties = new Properties();
            properties.load(input);
            userFullName = properties.getProperty("trainer_name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ManageGroupPage manageGroupButton() {
        driver.findElement(manageGroupButton).click();
        return new ManageGroupPageImpl(driver,user);
    }

    @Override
    public TrainerTraineeFeedbackFormPageImpl selectTraineeName(int week, String traineeName) {
        weekName = new By.ByXPath("//option[@value='" + week + "']");
        traineeNameFinder = new By.ByXPath("//td[\"" + traineeName + "\"]");

        driver.findElement(weekListName).findElement(weekName).click();
        try{
            ActionClicker.timedMouseClicker(driver, 500, By.xpath(".//*[@id='traineeTable2']/tbody/tr/td[contains(.,'" + traineeName + "')]"));
        }
        catch(NoSuchElementException e){
            // Make sure to check for/expect this output if a trainee is not present.
            System.out.println("The trainee " + traineeName + " does not exist.");
            return new TrainerTraineeFeedbackFormPageImpl(driver, null);
        }
        return new TrainerTraineeFeedbackFormPageImpl(driver, this.getClass().getSimpleName());
    }

    //TODO: Delete this
    public TrainerTraineeFeedbackFormPage selectJaneDoe() {
        ActionClicker.timedMouseClicker(driver, 500, new By.ByCssSelector("#traineeTable2 td:nth-child(1)"));
        return new TrainerTraineeFeedbackFormPageImpl(driver, this.getClass().getSimpleName());
    }

    @Override
    public boolean menuDropdownDisplays() {
        return false;
    }

    @Override
    public boolean isUserDisplayNameCorrect() {
        String userDisplayName = driver.findElement(By.cssSelector(".pb-3:nth-child(2)")).getText().substring(6);
        return (userFullName.equals(userDisplayName));
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
        ActionClicker.timedMouseClicker(driver, 400, By.cssSelector(".bi-list"));
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
        ActionClicker.timedMouseClicker(driver, 400, By.linkText("Manage Group"));
        return new ManageGroupPageImpl(driver, user);
    }


}
