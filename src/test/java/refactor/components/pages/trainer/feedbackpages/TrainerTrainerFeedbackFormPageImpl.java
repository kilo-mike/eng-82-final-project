package refactor.components.pages.trainer.feedbackpages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.pages.FeedbackFormPage;

public class TrainerTrainerFeedbackFormPageImpl extends FeedbackFormPage implements TrainerTrainerFeedbackFormPage {

    private final By trainerButton = new By.ByXPath("/html/body/div[2]/div/div/form/div[1]/label[2]");
    private final By trainerCommentsTextField = new By.ById("trainerComments");
    private final By trainerStopButton = new By.ByXPath("/html/body/div[2]/div/div/form/div[3]/div[1]/label[1]");
    private final By trainerStartButton = new By.ByXPath("/html/body/div[2]/div/div/form/div[3]/div[1]/label[2]");
    private final By trainerContinueButton = new By.ByXPath("/html/body/div[2]/div/div/form/div[3]/div[1]/label[3]");
    private final By stopTrainerTextField = new By.ById("stopTrainer");
    private final By startTrainerTextField = new By.ById("startTrainer");
    private final By continueTrainerTextField = new By.ById("continueTrainer");


    private final By traineeButton = new By.ByLinkText("Trainee");

    private final WebDriver driver;
    private final String user;

    public TrainerTrainerFeedbackFormPageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
        this.user = user;
    }


    @Override
    public TrainerTrainerFeedbackFormPageImpl enterTrainerComments(String comments) {
        driver.findElement(trainerCommentsTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl clickOnTrainer() {
        driver.findElement(trainerButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl clickOnStop() {
        driver.findElement(trainerStopButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl enterTrainerStopComments(String comments) {
        driver.findElement(stopTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl clickOnStart() {
        driver.findElement(trainerStartButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl enterTrainerStartComments(String comments) {
        driver.findElement(startTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl clickOnCont() {
        driver.findElement(trainerContinueButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPageImpl enterTrainerContComments(String comments) {
        driver.findElement(continueTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPageImpl clickOnTrainee() {
        driver.findElement(traineeButton).click();
        return new TrainerTraineeFeedbackFormPageImpl(driver, this.getClass().getSimpleName());
    }


    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getStopInputValue() {
        return driver.findElement(By.id("stopTrainer")).getAttribute("value");
    }

    public String getStartInputValue() {
        return driver.findElement(By.id("startTrainer")).getAttribute("value");
    }

    public String getContInputValue() {
        return driver.findElement(By.id("continueTrainer")).getAttribute("value");
    }

    public boolean checkAllCommentsHaveBeenInputSuccessfully(String stopComment, String startComment, String continueComment) {
        return getStopInputValue().equals(stopComment) && getStartInputValue().equals(startComment) && getContInputValue().equals(continueComment);
    }
}
