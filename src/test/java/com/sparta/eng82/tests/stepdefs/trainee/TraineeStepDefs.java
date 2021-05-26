package com.sparta.eng82.tests.stepdefs.trainee;

import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeProfilePageImpl;
import com.sparta.eng82.tests.stepdefs.stepdefutil.DriverManager;
import com.sparta.eng82.tests.stepdefs.stepdefutil.Pages;
import io.cucumber.java.ca.Cal;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

public class TraineeStepDefs {


    @Given("I am logged in as a trainee")
    public void iAmLoggedInAsATrainee() {
        Pages.traineeHomePage = (TraineeHomePageImpl) new LoginPageImpl(DriverManager.driver, "trainee").driverGet().login();
    }

    @When("I am on the homepage")
    public void iAmOnTheHomepage() {
    }


    @Then("I should see the stream info")
    public void iShouldSeeTheStreamInfo() {
        Assertions.assertEquals("Java SDET", Pages.traineeHomePage.getStream());
    }

    @Then("I should see the group info")
    public void iShouldSeeTheGroupInfo() {
        Assertions.assertEquals("Engineering 80", Pages.traineeHomePage.getGroup());
    }

    @Then("I should see the trainer info")
    public void iShouldSeeTheTrainerInfo() {
        Assertions.assertEquals("Manish Gadhvi", Pages.traineeHomePage.getTrainer());
    }


    @Then("I should see a selectable list of all the 1-1 sheets from previous weeks")
    public void iShouldSeeASelectableListOfAllTheSheetsFromPreviousWeeks() {
        Assertions.assertTrue(Pages.traineeHomePage.areAllPreviousWeeksShown());
    }

    @When("The trainee views their profile")
    public void theTraineeViewsTheirProfile() {
        Pages.traineeProfilePage = (TraineeProfilePageImpl) Pages.traineeHomePage.goToProfilePage();
    }

    @Then("The trainee will be able to see their average grades over time")
    public void theTraineeWillBeAbleToSeeTheirAverageGradesOverTime() {
        Assertions.assertTrue(Pages.traineeProfilePage.areBothGradesValid());
    }



    @When("I click on the feedback for week {int}")
    public void iClickOnTheFeedbackForWeek(int arg0) {
        Pages.traineeTraineeFeedbackFormPage = Pages.traineeHomePage.clickFeedbackFormForWeek(arg0);
    }

    @Then("I will only be able to see information pertaining to week {int}")
    public void iWillOnlyBeAbleToSeeInformationPertainingToWeek(int arg0) {
        Assertions.assertEquals(Pages.traineeTraineeFeedbackFormPage.getWeek(), "Week "+arg0);
    }

    @Then("I will be able to see the status of my feedback form using the traffic light")
    public void iWillBeAbleToSeeTheStatusOfMyFeedbackFormUsingTheTrafficLight() {
        Assertions.assertTrue(Arrays.stream(new String[]{"Green", "Amber", "Red"}).anyMatch(s -> s.contains(Pages.traineeHomePage.getCurrentTrafficLight())));
    }

    @Then("I am able to add a comment in the stop box")
    public void iAmAbleToAddACommentInTheStopBox() {
        Pages.traineeHomePage = (TraineeHomePageImpl) Pages.traineeTraineeFeedbackFormPage.setStopCommentBox("this is a test");
        Pages.traineeTraineeFeedbackFormPage = Pages.traineeHomePage.clickFeedbackFormForWeek(Pages.traineeHomePage.getCurrentWeekInt());
        Assertions.assertEquals("this is a test", Pages.traineeTraineeFeedbackFormPage.getStopCommentBox());
    }

    @Then("I am able to add a comment in the start box")
    public void iAmAbleToAddACommentInTheStartBox() {
        Pages.traineeHomePage = (TraineeHomePageImpl) Pages.traineeTraineeFeedbackFormPage.setStartCommentBox("this is a test");
        Pages.traineeTraineeFeedbackFormPage = Pages.traineeHomePage.clickFeedbackFormForWeek(Pages.traineeHomePage.getCurrentWeekInt());
        Assertions.assertEquals("this is a test", Pages.traineeTraineeFeedbackFormPage.getStartCommentBox());
    }

    @Then("I am able to add a comment in the continue box")
    public void iAmAbleToAddACommentInTheContinueBox() {
        Pages.traineeHomePage = (TraineeHomePageImpl) Pages.traineeTraineeFeedbackFormPage.setContinueCommentBox("this is a test");
        Pages.traineeTraineeFeedbackFormPage = Pages.traineeHomePage.clickFeedbackFormForWeek(Pages.traineeHomePage.getCurrentWeekInt());
        Assertions.assertEquals("this is a test", Pages.traineeTraineeFeedbackFormPage.getContinueCommentBox());
    }

    @Given("I am logged in as an {string}")
    public void iAmLoggedInAsAn(String arg0) {
    }

    @And("I have created a new trainee profile for {string} {string} within the group {string}")
    public void iHaveCreatedANewTraineeProfileForWithinTheGroup(String firstName, String lastName, String groupName) {
        Pages.trainerHomePage.clickManageGroupButton().addTrainee().assignGroup(groupName).enterFirstName(firstName).enterLastName(lastName).createNewTrainee();
    }

    @And("The trainer logs out")
    public void theTrainerLogsOut() {
        Pages.trainerHomePage.logOut();
    }

    @When("The trainee signs in")
    public void theTraineeSignsIn() {
        Pages.traineeHomePage = (TraineeHomePageImpl) new LoginPageImpl(DriverManager.driver, "trainee").login();
    }

    @Then("They are prompted to change the default Password")
    public void theyArePromptedToChangeTheDefaultPassword() {
        Assertions.assertTrue(Pages.loginPage.getUrl().endsWith("/change-password"));
    }

    @Given("I am viewing a feedback form that is completed")
    public void iAmViewingAFeedbackFormThatIsCompleted() {
        Pages.traineeTraineeFeedbackFormPage = Pages.traineeHomePage.clickFeedbackFormForWeek(1);
    }

    @When("The Trainee types into the comment section")
    public void theTraineeTypesIntoTheCommentSection() {
    }

    @Then("The Trainee will be unable to add a new comment to the stop box as the trainee is locked out of editing after completion")
    public void theTraineeWillBeUnableToAddANewCommentToTheStopBoxAsTheTraineeIsLockedOutOfEditingAfterCompletion() {
        Assertions.assertTrue(Pages.traineeTraineeFeedbackFormPage.isStopCommentBoxDisabled());
    }

    @Then("The Trainee will be unable to add a new comment to the start box as the trainee is locked out of editing after completion")
    public void theTraineeWillBeUnableToAddANewCommentToTheStartBoxAsTheTraineeIsLockedOutOfEditingAfterCompletion() {
        Assertions.assertTrue(Pages.traineeTraineeFeedbackFormPage.isStartCommentBoxDisabled());
    }

    @Then("The Trainee will be unable to add a new comment to the continue box as the trainee is locked out of editing after completion")
    public void theTraineeWillBeUnableToAddANewCommentToTheContinueBoxAsTheTraineeIsLockedOutOfEditingAfterCompletion() {
        Assertions.assertTrue(Pages.traineeTraineeFeedbackFormPage.isContinueCommentBoxDisabled());
    }

    @And("I have not submitted my form")
    public void iHaveNotSubmittedMyForm() {
        Assertions.assertEquals("Amber", Pages.traineeHomePage.getCurrentTrafficLight());
    }

    @When("The end of thursday passes")
    public void theEndOfThursdayPasses() {
        Assertions.assertEquals(5,Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
    }

    @Then("The traffic light will turn red")
    public void theTrafficLightWillTurnRed() {
        Assertions.assertEquals("Red", Pages.traineeHomePage.getCurrentTrafficLight());
    }
}
