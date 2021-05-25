package com.sparta.eng82.tests.stepdefs;

import com.sparta.eng82.components.Page;
import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.tests.stepdefs.stepdefutil.DriverManager;
import com.sparta.eng82.tests.stepdefs.stepdefutil.Pages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class TraineeHomepageStepDefs {


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
}
