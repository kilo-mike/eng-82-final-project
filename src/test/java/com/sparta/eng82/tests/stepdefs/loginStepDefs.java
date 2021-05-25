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


public class loginStepDefs {

    @Before
    public void setUp() {
        DriverManager.setUp();
    }

    @After
    public void tearDown() {
        DriverManager.tearDown();
    }

    @Given("I am on the login page as a {string}")
    public void iAmOnTheLoginPage(String userType) {
        Pages.loginPage = new LoginPageImpl(DriverManager.driver, userType).driverGet();
    }

    @When("I type the username")
    public void iTypeTheUsername() {
        Pages.loginPage.enterEmail();
    }

    @And("I type the password")
    public void iTypeThePassword() {
        Pages.loginPage.enterPassword();
    }

    @And("I click sign in as an admin")
    public void iClickSignInAsAnAdmin() {
        Pages.adminHomePage = (AdminHomePageImpl) Pages.loginPage.clickLogin();
    }

    @Then("I should be directed to the admin homepage")
    public void iShouldBeDirectedToTheAdminHomepage() {
        Assertions.assertTrue(Pages.adminHomePage.isOnHomePage());
    }

    //Trainee
    @And("I click sign in as a trainee")
    public void iClickSignInAsATrainee() {
        Pages.traineeHomePage = (TraineeHomePageImpl) Pages.loginPage.clickLogin();
    }

    @Then("I should be directed to the trainee homepage")
    public void iShouldBeDirectedToTheTraineeHomepage() {
        Assertions.assertTrue(Pages.traineeHomePage.isOnHomePage());
    }

    //Trainer
    @And("I click sign in as a trainer")
    public void iClickSignInAsATrainer() {
        Pages.trainerHomePage = (TrainerHomePageImpl) Pages.loginPage.clickLogin();
    }

    @Then("I should be directed to the trainer homepage")
    public void iShouldBeDirectedToTheTrainerHomepage() {
        Assertions.assertTrue(Pages.trainerHomePage.isOnHomePage());
    }
}
