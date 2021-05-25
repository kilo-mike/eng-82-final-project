package com.sparta.eng82.tests.stepdefs;

import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.tests.stepdefs.stepdefutil.DriverManager;
import com.sparta.eng82.tests.stepdefs.stepdefutil.Pages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class traineeStepDefs {

    @Before
    public void setUp() {
        DriverManager.setUp();
    }

    @After
    public void tearDown() {
        //DriverManager.tearDown();
    }

    @Given("I am logged in as an {string}")
    public void iAmLoggedInAsAn(String userType) {
        Pages.trainerHomePage = (TrainerHomePageImpl) new LoginPageImpl(DriverManager.driver, userType).login();
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


}