package refactor.components.pages.trainer.feedbackpages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import refactor.components.NavPage;
import refactor.components.pages.FeedbackFormPage;
import refactor.components.pages.trainer.TrainerFeedbackFormPage;

public class TrainerTrainerFeedbackFormPageImpl extends FeedbackFormPage implements TrainerTrainerFeedbackFormPage {

    private final By trainerCommentsTextField = new By.ById("trainerComments");
    private final By stopButton = new By.ByLinkText("Stop");
    private final By startButton = new By.ByLinkText("Start");
    private final By continueButton = new By.ByLinkText("Cont.");
    private final By traineeButton = new By.ByLinkText("Trainee");
    private final By stopTrainerTextField = new By.ById("stopTrainer");
    private final By startTrainerTextField = new By.ById("startTrainer");
    private final By continueTrainerTextField = new By.ById("continueTrainer");

    WebDriver driver;

    public TrainerTrainerFeedbackFormPageImpl(WebDriver driver, String user) {
        super(driver, user);
        this.driver = driver;
    }


    @Override
    public TrainerFeedbackFormPage enterTrainerComments(String comments) {
        driver.findElement(trainerCommentsTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage clickOnStop() {
        driver.findElement(stopButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage enterStopComments(String comments) {
        driver.findElement(stopTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage clickOnStart() {
        driver.findElement(startButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage enterStartComments(String comments) {
        driver.findElement(startTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage clickOnCont() {
        driver.findElement(continueButton).click();
        return this;
    }

    @Override
    public TrainerTrainerFeedbackFormPage enterContComments(String comments) {
        driver.findElement(continueTrainerTextField).sendKeys(comments);
        return this;
    }

    @Override
    public TrainerTraineeFeedbackFormPage clickOnTrainee() {
        driver.findElement(traineeButton).click();
        return new TrainerTraineeFeedbackFormPageImpl(driver, this.getClass().getSimpleName());
    }

    @Override
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
