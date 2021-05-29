package com.sparta.eng82.tests.stepdefs.admin;

import com.sparta.eng82.components.pages.admin.AddTrainerPageImpl;
import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.tests.stepdefs.stepdefutil.DriverManager;
import com.sparta.eng82.tests.stepdefs.stepdefutil.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AdminStepDefs {

    private String first;
    private String last;
    private String group;

    @Given("I am on the admin homepage")
    public void iAmOnTheAdminHomepage() {
        Pages.adminHomePage = (AdminHomePageImpl) new LoginPageImpl(DriverManager.driverDoNotSubmit, "admin").login();
    }

    @When("I click add trainer")
    public void iClickAddTrainer() {
        Pages.addTrainerPage = (AddTrainerPageImpl) Pages.adminHomePage.addTrainer();
    }

    @And("I add a trainer firstname {string}")
    public void iAddATrainerFirstname(String firstName) {
        first = firstName;
        Pages.addTrainerPage.enterFirstName(firstName);

    }

    @And("I add a trainer lastname {string}")
    public void iAddATrainerLastname(String lastName) {
        last = lastName;
        Pages.addTrainerPage.enterSecondName(lastName);

    }

    @And("I select trainer group {string}")
    public void iSelectTrainerGroup(String groupName) {
        if (groupName.equals("No Group")) {
            group = "Not Assigned";
        } else {
            group = groupName;
        }
        Pages.addTrainerPage.selectGroup(groupName);

    }

    @And("I click add new trainer")
    public void iClickAddNewTrainer() {
        Pages.addTrainerPage.addNewTrainer();
    }

    @Then("Trainer should be visible on list of trainers")
    public void trainerShouldBeVisibleOnListOfTrainers() {
        Assertions.assertTrue(Pages.adminHomePage.isTrainerAdded(first, last, "Not Assigned"));
    }
}
