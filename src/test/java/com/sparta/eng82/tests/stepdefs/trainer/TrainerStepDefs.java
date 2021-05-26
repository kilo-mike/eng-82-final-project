package com.sparta.eng82.tests.stepdefs.trainer;

import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.tests.stepdefs.stepdefutil.DriverManager;
import com.sparta.eng82.tests.stepdefs.stepdefutil.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class TrainerStepDefs {

    @Given("I am logged in as a trainer")
    public void iAmLoggedInAsATrainer() {
        Pages.trainerHomePage = (TrainerHomePageImpl) new LoginPageImpl(DriverManager.driver, "trainer").driverGet().login();

    }

    @When("I am on the trainer homepage")
    public void iAmOnTheTrainerHomepage() {
        Pages.trainerHomePage.goToHomePage();
    }

    @Then("I should see a selectable list of my trainees")
    public void iShouldSeeASelectableListOfMyTrainees() {
        Assertions.assertTrue(Pages.trainerHomePage.areTraineesVisible());
    }


}
